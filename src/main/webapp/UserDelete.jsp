<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Delete User</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Delete User</h2>--%>
<%--<form action="userdelete" method="post">--%>
<%--    <label for="USER_ID">User ID:</label>--%>
<%--    <input type="text" id="USER_ID" name="USER_ID"><br>--%>
<%--    <button type="submit">Delete User</button>--%>
<%--</form>--%>

<%--<p style="color:green;">--%>
<%--    ${messages.success}--%>
<%--</p>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
      }

      h2 {
        color: #333;
        text-align: center;
        margin-top: 20px;
      }

      form {
        margin: 20px auto;
        padding: 20px;
        max-width: 400px;
        background: #fff;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }

      label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #555;
      }

      input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }

      button {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
      }

      button:hover {
        background-color: #45a049;
      }

      .return {
        display: block;
        margin: 10px auto 0;
        text-align: center;
        color: #4CAF50;
        text-decoration: none;
        font-size: 14px;
      }

      .return:hover {
        text-decoration: underline;
      }

      p {
        text-align: center;
        font-size: 14px;
      }

      p.success {
        color: green;
      }

    </style>
</head>
<body>
<h2>Delete User</h2>
<form action="userdelete" method="post">
    <label for="USER_ID">User ID:</label>
    <input type="text" id="USER_ID" name="USER_ID">
    <button type="submit">Delete User</button>
</form>
<a class="return" href="index.jsp">Return to Main Page</a>
<c:if test="${not empty messages.error}">
    <p class="error">${messages.error}</p>
</c:if>
<c:if test="${not empty messages.success}">
    <p class="success">${messages.success}</p>
</c:if>
</body>
</html>
