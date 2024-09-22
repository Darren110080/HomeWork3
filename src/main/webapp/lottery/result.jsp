<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery Result</title>
</head>
<body>
    <div style="text-align:center;">
        <h1>Lottery Game Result</h1>
        <p>組數: ${group}</p>
        <p>排除: ${exclude}</p>
        <p>結果<br/> ${result}</p>
    </div>
    <div style="text-align:center;">
    <a href="main.jsp">Play again</a>
    </div>
    <div style="text-align:center;"><a href="../">回首頁</a></div>
</body>
</html>