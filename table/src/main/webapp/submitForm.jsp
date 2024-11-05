<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="demo.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Tin Khách Hàng</title>
</head>
<body>
    <h2>Cảm ơn bạn đã đăng ký</h2>
    <h2>Thông Tin Khách Hàng Đã Đăng Ký</h2>
    
   <%
    User user = (User) request.getAttribute("user");
    if (user != null) {
%>
    <p>Email: <%= user.getEmail() %></p>
    <p>Họ và Tên: <%= user.getName() %></p>
    <p>Địa Chỉ: <%= user.getAddress() %></p>
    <p>Thành Phố: <%= user.getCity() %></p>
    <p>Giới Tính: <%= user.isGender() ? "Nam" : "Nữ" %></p>
    <p>Nghề Nghiệp: <%= user.getJob() %></p>
    <p>Phương Thức Giao Hàng: <%= String.join(", ", user.getDeliveryMethods()) %></p>
<%
    } else {
%>
    <p>Không có thông tin khách hàng.</p>
<%
    }
%>
   
</body>
</html>
