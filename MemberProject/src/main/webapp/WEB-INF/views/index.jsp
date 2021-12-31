<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> index.jsp</h2>
<a href = "signup"> 회원가입 </a> <br>
<a href = "signin"> 로그인 </a>  <br>
<a href ="findAll">회원목록</a>   <br>

	세션값 : ${sessionScope.loginID}
</body>
</html>