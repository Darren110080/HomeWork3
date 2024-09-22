<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lottery Game</title>
</head>
<body>

<div style="text-align:center;"><h1>Welcome To Lottery Game!</h1></div>
	<form action="LotteryController.do" method=post>
		<table border="0" style="margin: auto; text-align: Left">
			<tbody>
				<tr>
					<td>組數</td><td><input type="text" name="group" value="${param.group}"/></td>
				</tr>
				<tr>
					<td>排除</td><td><input type="text" name="exclude" value="${param.exclude}"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type=reset value="Reset"/>
						<input type=submit value="Submit"/>
					</td>
				</tr>
		</table>
	</form>
	<div style="text-align:center;"><a href="../">回首頁</a></div>

</body>
</html>