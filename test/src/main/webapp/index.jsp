<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Đăng Ký</title>
</head>
<body>
    <h2>Form Đăng Ký</h2>
    
    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">
            <h3>Có lỗi xảy ra:</h3>
            <p>${errorMessage}</p>
        </div>
    </c:if>

    <form action="fixServlet" method="post">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="name">Họ và tên:</label>
        <input type="text" id="name" name="name" required><br><br>


        <label for="address">Địa chỉ:</label>
        <input type="text" id="address" name="address" required><br><br>

  
        <label for="city">Thành phố:</label>
        <input type="text" id="city" name="city"><br><br>


        <label>Giới tính:</label>
        <input type="radio" id="male" name="gender" value="Nam"> Nam
        <input type="radio" id="female" name="gender" value="Nữ"> Nữ
        <input type="radio" id="other" name="gender" value="Khác"> Khác
        <br><br>

   
        <label for="job">Nghề nghiệp:</label>
        <input type="text" id="job" name="job"><br><br>

    
        <label for="phone">Số điện thoại:</label>
        <input type="text" id="phone" name="phone" required pattern="^\d{10}$" title="Số điện thoại phải gồm 10 chữ số"><br><br>


        <label for="dob">Ngày sinh:</label>
        <input type="date" id="dob" name="dob" required><br><br>
        <label>Phương thức giao hàng:</label><br>
        <input type="checkbox" id="standard" name="delivery" value="Tại nhà"> Giao hàng tại nhà<br>
        <input type="checkbox" id="express" name="delivery" value="Văn Phòng"> Giao hàng văn phòng<br>
        <input type="checkbox" id="overnight" name="delivery" value="Khác"> Giao hàng ở chỉ địa khác<br><br>

        <input type="submit" value="Đăng Ký">
    </form>
</body>
</html>
