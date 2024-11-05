<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
    <h2>Form Đăng Nhập</h2>
    
    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">
            <p>${errorMessage}</p>
        </div>
    </c:if>

    <!-- Form login -->
    <form action="LoginServlet" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Đăng nhập">
    </form>
</body>
</html>
