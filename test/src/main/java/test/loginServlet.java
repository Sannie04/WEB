package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy dữ liệu từ form đăng nhập
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Kiểm tra thông tin đăng nhập
            if ("sang".equals(username) && "2801".equals(password)) {
                // Tạo session và lưu username
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Lấy danh sách client từ cơ sở dữ liệu
                List<Client> clients = Data.getAllClients(); // Make sure this method works correctly
                request.setAttribute("clients", clients);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmLogin.jsp"); 
                dispatcher.forward(request, response);
                // Chuyển hướng tới trang confirmLogin.jsp
//                request.getRequestDispatcher("confirmLogin.jsp").forward(request, response);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/confirmLogin.jsp"); 
//                dispatcher.forward(request, response);
            } else {
                // Trả về lỗi nếu thông tin đăng nhập không đúng
                request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // This will print the error stack trace to the console
            request.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response); // Redirect to an error page
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng về trang login.jsp nếu truy cập bằng GET
        response.sendRedirect("login.jsp");
    }
}
