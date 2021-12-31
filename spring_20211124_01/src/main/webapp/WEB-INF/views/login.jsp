<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login.jsp</h2>
	<!-- controller에서 가져온 memberDTO객에 출력 -->
	${member.id}
	${member.pw}
	${member.name}
	${member.mail}
	${member.gender}
	
</body>
</html>