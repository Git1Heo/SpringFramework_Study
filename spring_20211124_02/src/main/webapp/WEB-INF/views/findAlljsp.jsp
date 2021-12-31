<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL(JSP Standard Tag Library --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
       table, th,tr,td{
            border: 1px solid black;           
        	border-collapse: collapse;
        }
       
</style>
</head>
<body>
	<table>
		<tr>
        	<th>번호</th>
       		<th>이름</th>
       		<th>나이</th>
       		<th>전화번호</th>
       		<th>성별</th>
       		<th>생일</th>
       		<th>주소</th>
        </tr>
	<h2>findAll.jsp </h2>
	<c:forEach items="${tList}" var="t">
		 <tr>
		<td>${t.tnumber} </td>
		<td>${t.t_name} </td>
		<td>${t.age} </td>
		<td>${t.phoneNumber} </td>
		<td>${t.gender} </td>
		<td>${t.birth} </td>
		<td>${t.address} </td>
		<!-- detail이라는 주소로 tnumber 파라미터를 전달함
			링크로 서버에 데이터 전송 
			서버에서 tnumber를 받아서 sysout으로 출력하세요-->
		<td><a href="findById?tnumber=${t.tnumber}">조회</a> </td>
		 </tr>
		<br>
	</c:forEach>
		</table>
</body>
</html>