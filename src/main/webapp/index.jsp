<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Welcome PathwayCareersApplication</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1>Welcome PathwayCareersApplication</h1>--%>
<%--    <ul>--%>
<%--        <li><a href="UserCreate.jsp">Create User</a></li>--%>
<%--        <li><a href="UserRead.jsp">Read User</a></li>--%>
<%--        <li><a href="UserUpdate.jsp">Update User</a></li>--%>
<%--        <li><a href="UserDelete.jsp">Delete User</a></li>--%>
<%--    </ul>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome PathwayCareersApplication</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            background: #fff;
            padding: 20px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 600px;
        }

        .container h1 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #4CAF50;
        }

        .links {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px;
        }

        .links a {
            display: block;
            text-decoration: none;
            color: #fff;
            background: #4CAF50;
            padding: 10px;
            border-radius: 6px;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .links a:hover {
            background-color: #45a049;
        }

        footer {
            margin-top: 20px;
            font-size: 0.9rem;
            color: #666;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Pathway Careers Application</h1>
    <p>Manage users with the options below:</p>
    <div class="links">
        <a href="UserCreate.jsp">Create User</a>
        <a href="UserRead.jsp">Read User</a>
        <a href="UserUpdate.jsp">Update User</a>
        <a href="UserDelete.jsp">Delete User</a>
        <a href="${pageContext.request.contextPath}/sponsoranalysis">Check Sponsor Analysis</a>
        <%--        <a href="SponsorAnalysis.jsp">Check Sponsor Analysis</a>--%>
    </div>
</div>
</body>
</html>