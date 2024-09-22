<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess Number</title>
</head>
<body>
<div style="text-align:center;"><h1>Welcome To Guess Number Game!</h1></div>
<div style="text-align:center;"><h2>請輸入數字1~10</h2></div>

<% 
    Integer remains = (Integer) session.getAttribute("remains");
    if (remains != null) {
%>
    <div style="text-align:center;"><h3>你還有 <%= remains %> 次機會</h3></div>
<% } %>

<% 
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div style="text-align:center; color: red;"><h3><%= message %></h3></div>
<% } %>

<form action="GameController.do" method=post>
    <table border="0" style="margin: auto; text-align: Left">
        <tbody>
            <tr>
                <td>你猜的數字</td><td><input type="text" name="group"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type=submit value="Submit"/></td>
            </tr>
        </tbody>
    </table>
</form>
<div style="text-align:center;"><a href="../">回首頁</a></div>
</body>
</html>