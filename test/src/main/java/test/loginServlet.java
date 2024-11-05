package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form đăng nhập
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        if ("sang".equals(username) && "2801".equals(password)) {
            // Tạo session và lưu username
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Chuyển hướng tới trang confirmLogin.jsp
            response.sendRedirect("confirmLogin.jsp");
        } else {
            // Trả về lỗi nếu thông tin đăng nhập không đúng
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng về trang login.jsp nếu truy cập bằng GET
        response.sendRedirect("login.jsp");
    }
}
