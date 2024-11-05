package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addClient")
public class AddClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try (Connection conn = Data.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO client (name, email) VALUES (?, ?)")) {
             
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();

            // Redirect to the client list page to show updated list
            response.sendRedirect("clientList");

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error adding client: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
