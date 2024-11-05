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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/clientList")
public class clientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Client> clientList = new ArrayList<>();

        try (Connection conn = Data.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement("SELECT name, email FROM client"); 
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clientList.add(new Client(
                    rs.getString("name"), 
                    rs.getString("email")
                )); 
            }

            request.setAttribute("clients", clientList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmLogin.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace(); 
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMessage", "Error retrieving client data: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
