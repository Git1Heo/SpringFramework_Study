<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
	display: block;
	}
</style>

</head>
<body>
	<form action="inputparam" method="post">
		입력 1: <input type="text" name="id">
		입력 2: <input type="password" name="pw">
		<input type="submit" value="전송">
	</form>
</body>
</html>