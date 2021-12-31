<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		input{
		display : block
		}
	</style>
</head>
<body>
 	<h1>인서트</h1>
	<form action="inputparam" method="post">
		이름 : <input type="text" name="t_name">
		나이 : <input type="text" name="age">
		전화번호 : <input type="text" name="phoneNumber">
		성별 : <input type="text" name="gender">
		생년월일 : <input type="text" name="birth" >
		집주소 : <input type="text" name="address">
		<input type="submit" value="전송">
	</form>
</body>
</html>