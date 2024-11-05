package test;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/from")
public class fixServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
       String gender = request.getParameter("gender");
     String job = request.getParameter("job");
       String phone = request.getParameter("phone"); 
        String dob = request.getParameter("dob"); 
      String edit = request.getParameter("edit");
       String[] delivery = request.getParameterValues("delivery");

   
        String maxConnections = getServletContext().getInitParameter("maxConnections");

        // Tạo đối tượng US
        US us = new US();
        us.setEmail(email);
        us.setName(name);
        us.setAddress(address);
        us.setCity(city);
        us.setGender(gender);
        us.setJob(job);
        us.setDelivery(delivery);

   
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

       
        if (gender == null) {
            errorMessage.append("Vui lòng chọn giới tính!<br>");
            isValid = false;
        }

        if (delivery == null || delivery.length == 0) {
            errorMessage.append("Vui lòng chọn ít nhất một loại giao hàng!<br>");
            isValid = false;
        }

       
        String phonePattern = "^\\d{10}$";  
        if (!Pattern.matches(phonePattern, phone)) {
            errorMessage.append("Số điện thoại không hợp lệ! Phải có 10 chữ số.<br>");
            isValid = false;
        }


        if (dob == null || dob.isEmpty()) {
            errorMessage.append("Vui lòng chọn ngày sinh!<br>");
            isValid = false;
        }

  
        if (!isValid) {
            request.setAttribute("errorMessage", errorMessage.toString());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;  
        }

       
        System.out.println("Email: " + us.getEmail());
        System.out.println("Name: " + us.getName());
        System.out.println("Address: " + us.getAddress());
        System.out.println("City: " + us.getCity());
        System.out.println("Gender: " + us.getGender());
        System.out.println("Job: " + us.getJob());

    
        if (delivery != null) {
            for (String deli : us.getDeliveryMethods()) {
                System.out.println("Delivery: " + deli);
            }
        }

       
        String url = "";
        if ("edit".equals(edit)) {
            url = "/editform.jsp";
        } else {
            url = "/submitForm.jsp";
        }

        System.out.println("Max Connections: " + maxConnections);

        // Chuyển tiếp đối tượng US tới trang JSP để hiển thị
        request.setAttribute("us", us);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
