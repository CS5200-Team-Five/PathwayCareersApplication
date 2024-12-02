<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sponsorship Analysis</title>
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
            align-items: flex-start; /* 支持顶部对齐 */
            height: 100vh;
            padding-top: 20px; /* 添加一些顶部填充 */
        }

        .container {
            text-align: center;
            background: #fff;
            padding: 20px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 850px; /* 更大的宽度，适合表格 */
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #4CAF50;
        }

        h2 {
            color: #333;
            margin: 20px 0;
            font-size: 1.5rem;
        }

        table {
            width: 100%; /* 表格宽度 */
            border-collapse: collapse; /* 合并边框 */
            margin-bottom: 20px; /* 表格底部的间距 */
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd; /* 分隔线 */
        }

        th {
            background-color: #4CAF50; /* 表头背景色 */
            color: white; /* 表头文字颜色 */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* 隔行换色 */
        }

        tr:hover {
            background-color: #ddd; /* 鼠标悬停效果 */
        }

        p {
            margin-top: 20px; /* 段落的顶部间距 */
            font-size: 0.9rem; /* 调整段落字体大小 */
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
    <h1>Frequent Foreign Worker Sponsors Analysis</h1>

    <span id="successMessage"><b>${messages.success}</b></span>
    <br/>
    <br/>

    <h2>Companies with 5+ Sponsorship Applications</h2>
    <table>
        <tr>
            <th>Company Name</th>
            <th>Location</th>
            <th>Total Sponsorships</th>
            <th>Approved Sponsorships</th>
            <th>Success Rate</th>
        </tr>
        <c:forEach items="${sponsorshipSummaries}" var="summary">
            <tr>
                <td><c:out value="${summary.companyName}" /></td>
                <td><c:out value="${summary.location}" /></td>
                <td><c:out value="${summary.totalApplications}" /></td>
                <td><c:out value="${summary.approvedApplications}" /></td>
                <td>
                    <fmt:formatNumber value="${summary.successRate}" pattern="#.#"/>%
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>

    <p>Note: Only showing companies with 5 or more sponsorship applications. Success rate is calculated based on approved applications.</p>
    <p>Sponsorship Types include: H1B, PERM, and Labor Certification.</p>
</div>
</body>
</html>