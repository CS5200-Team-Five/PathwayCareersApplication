<%--<%@ page import="java.util.Map" %>--%>
<%--<%@ page import="java.util.HashMap" %>--%>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Create User</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Create a New User</h2>--%>
<%--<form action="usercreate" method="post">--%>
<%--    <label for="USERNAME">Username:</label>--%>
<%--    <input type="text" id="USERNAME" name="USERNAME"><br>--%>
<%--    <label for="EMAIL">Email:</label>--%>
<%--    <input type="text" id="EMAIL" name="EMAIL"><br>--%>
<%--    <label for="PASSWORD_HASH">Password:</label>--%>
<%--    <input type="password" id="PASSWORD_HASH" name="PASSWORD_HASH"><br>--%>
<%--    <button type="submit">Create User</button>--%>
<%--</form>--%>

<%--<p style="color:green;">--%>
<%--    ${messages.success}--%>
<%--</p>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 20px;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
      }

      h2 {
        color: #4CAF50;
      }

      form {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: auto;
      }

      label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
      }

      input {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 4px;
      }

      button {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
      }

      button:hover {
        background-color: #45a049;
      }

      .return {
        display: block;
        text-align: center;
        margin-top: 20px;
      }

      .return a {
        color: #4CAF50;
        text-decoration: none;
        font-size: 16px;
      }

      .return a:hover {
        text-decoration: underline;
      }

      p {
        text-align: center;
        font-size: 14px;
      }
    </style>
</head>
<body>
<h2>Create a New User</h2>
<form action="usercreate" method="post">
    <label for="USERNAME">Username:</label>
    <input type="text" id="USERNAME" name="USERNAME" required>

    <label for="EMAIL">Email:</label>
    <input type="email" id="EMAIL" name="EMAIL" required>

    <label for="PASSWORD_HASH">Password:</label>
    <input type="password" id="PASSWORD_HASH" name="PASSWORD_HASH" required>

    <button type="submit">Create User</button>
</form>

<p style="color:green;">
    ${messages.success}
</p>

<div class="return">
    <a href="index.jsp">&#8592; Return to Main Page</a>
</div>
</body>
</html>
