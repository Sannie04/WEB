<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ page import="java.util.List" %> 
 <%@ page import="test.Client" %> 
 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Khách hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.2);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-data {
            text-align: center;
            color: #666;
            font-style: italic;
        }
    </style>
</head>
<body>
    <h1>Danh sách Khách hàng</h1>
     <div class="add-client">
        <form action="addClient" method="post">
            <h2>Thêm mới khách hàng</h2>
            <input type="text" name="name" placeholder="Tên" required>
            <input type="email" name="email" placeholder="Email" required>
            <button type="submit">Thêm mới</button>
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
	        <%
	            // Retrieve the clients list from the request attribute
	            List<Client> clients = (List<Client>) request.getAttribute("clients");
	            
	            if (clients != null && !clients.isEmpty()) {
	                for (int i = 0; i < clients.size(); i++) {
	                    Client client = clients.get(i);
	        %>
	                    <tr>
	                        <td><%= i + 1 %></td>
	                        <td><%= client.getName() %></td>
	                        <td><%= client.getEmail() %></td>
	                    </tr>
	        <%
	                }
	            } else {
	        %>
	                <tr>
	                    <td colspan="3" class="no-data">Không tìm thấy khách hàng nào.</td>
	                </tr>
	        <%
	            }
	        %>
    	</tbody>
    </table>
</body>
</html>