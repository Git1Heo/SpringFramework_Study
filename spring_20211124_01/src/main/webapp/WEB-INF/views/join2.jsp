<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input{
	display : block; 
}
</style>
</head>
<body>
	<form action="memberjoin2" method="get">
		입력 1: <input type="text" name="id">
		입력 2: <input type="password" name="pw">
		입력 3: <input type="text" name="name">
		입력 4: <input type="email" name="mail">
		입력 5: <input type="radio" name="gender" value="male">
				<label for="m">남성</label>
			  <input type="radio" name="gender" value="female">
				<label for="f">여성</label>
		<input type="submit" value="전송">
	</form>
</body>
</html>