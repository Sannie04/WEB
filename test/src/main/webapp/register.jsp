<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Đăng Ký Khách Hàng</title>
</head>
<body>
    <h2>Form Đăng Ký Thông Tin Khách Hàng</h2>
    <form action="/test/fixServlet" method="POST">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        
        <label for="name">Họ và Tên:</label>
        <input type="text" id="name" name="name" required><br><br>
        
      <label for="phone">Số Điên Thoại</label>
        <input type="text" id="phone" name="phone" required><br><br>
         
        
        <label for="dob">Ngày Sinh:</label>
        <input type="date" id="dob" name="dob" required><br><br>

        
        <label for="address">Địa Chỉ:</label>
        <input type="text" id="address" name="address" required><br><br>

        
        <label for="city">Thành Phố:</label>
        <select id="city" name="city" required>
            <option value="">--Chọn Thành Phố--</option>
            <option value="hanoi">Hà Nội</option>
            <option value="hcm">TP Hồ Chí Minh</option>
            <option value="danang">Đà Nẵng</option>
            <option value="haiphong">Hải Phòng</option>
            <option value="cantho">Cần Thơ</option>
        </select><br><br>

        Giới Tính
        <label>Giới Tính:</label><br>
        <input type="radio" id="male" name="gender" value="male" required>
        <label for="male">Nam</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Nữ</label><br>
         <input type="radio" id="female" name="gender" value="female">
        <label for="female">Khác</label><br><br>
        Nghề Nghiệp
        <label for="job">Nghề Nghiệp:</label>
        <input type="text" id="job" name="job"><br><br>

        Giao Hàng
        <label>Phương Thức Giao Hàng:</label><br>
        <input type="checkbox" id="home" name="delivery" value="home">
        <label for="home">Tại nhà</label><br>
        <input type="checkbox" id="office" name="delivery" value="office">
        <label for="office">Văn phòng</label><br>
        <input type="checkbox" id="other" name="delivery" value="other">
        <label for="other">Khác</label><br><br> 
        
        <input type="checkbox"  id="edit" name="edit" value="edit">
        <input type="submit" value="Đăng Ký">
    </form>
</body>
</html>
