<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập thành công</title>
</head>
<body>
    <h2>Xác nhận đăng nhập</h2>
<%
    // Lấy thông tin từ session có sẵn mà không cần khai báo lại
    if (session != null && session.getAttribute("username") != null) {
        String username = (String) session.getAttribute("username");
%>
        <p>Đăng nhập thành công. Xin chào, <%= username %>!</p>
<%
    } else {
%>
        <p>Không có người dùng nào đăng nhập.</p>
<%
    }
%>

</body>
</html>
