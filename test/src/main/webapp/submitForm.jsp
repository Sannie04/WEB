<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Tin Khách Hàng</title>
</head>
<body>
    <h2>Thông Tin Khách Hàng Đã Đăng Ký</h2>
    <p>Email: <%= request.getParameter("email") %></p>
    <p>Họ và Tên: <%= request.getParameter("name") %></p>
    <p>Ngày Sinh: <%= request.getParameter("dob") %></p>
    <p>Địa Chỉ: <%= request.getParameter("address") %></p>
    <p>Thành Phố: <%= request.getParameter("city") %></p>
    <p>Giới Tính: <%= request.getParameter("gender") %></p>
    <p>Nghề Nghiệp: <%= request.getParameter("job") %></p>
    <p>Phương Thức Giao Hàng: <%= request.getParameter("delivery") %></p>
</body>
</html>
