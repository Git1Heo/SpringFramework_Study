<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function logout(){
		location.href="logout";
		
	}
	</script>
</head>
<body>

	<h2>main.jsp</h2>
	세션에 저장한 데이터 출력 : ${sessionScope.loginID}
	<button onclick="logout()">로그아웃</button>
	
	<c:if test="${sessionScope.loginID eq 'admin'}">
		<a href ="findAll">관리자용 회원목록</a> <br>
	</c:if>
	
	<a href ="findAll">회원목록</a>
	
	<a href ="/">홈<a>        
	<a href ="./">홈<a>   
	<a href ="../">홈<a>  
	
	
</body>
</html>