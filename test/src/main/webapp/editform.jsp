<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="test.US" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Khách Hàng</title>
</head>
<body>
<%
    US us = (US) request.getAttribute("us");// chuyen thong tin 
    String[] transportTypes = us.getDeliveryMethods(); // Sửa đổi ở đây
%>
<h1>Thông Tin Đăng Ký</h1><br>
<label>Your name: </label>
<input type="text" id="name" name="name" value="<%= us.getName() %>" readonly><br>

<label>Email Address: </label>
<input type="email" id="email" name="email" value="<%= us.getEmail() %>" readonly><br>

<label>Gender:</label>
<input type="text" id="gender" name="gender" value="<%= us.getGender() %>" readonly><br>

<label>Kind of transport:</label>
<ul>

</ul>
</body>
</html>
