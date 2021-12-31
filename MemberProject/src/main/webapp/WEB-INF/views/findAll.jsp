<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function detailAjax(m_number){
		console.log(m_number);
		const view=document.getElementById('detail-view');
		$.ajax({
			type: 'post',
			url : 'detailAjax',
			data:{'m_number':m_number},
			dataType:'json', //JSON 자바스크립트를 사용해 객체를 표현
			success:function(result){
				console.log(result);
				console.log(result.m_id);
				
				let output = "<table class='table'>";
				output += "<tr><th>number</th> <th>id</th> <th>password</th> <th>name</th>";
				output += "<th>email</th> <th>phone</th> </tr>";
				output += "<tr>";
				output += "<td>"+result.m_number+"</td>";
				output += "<td>"+result.m_id+"</td>";
				output += "<td>"+result.m_password+"</td>";
				output += "<td>"+result.m_name+"</td>";
				output += "<td>"+result.m_email+"</td>";
				output += "<td>"+result.m_phone+"</td>";
				output += "</tr>";
				output += "</table>";
				
				view.innerHTML = output;
			},
			error:function(){
				console.log("오타 찾으세요");
			}
			
		});		
	}
</script>


</head>
<body>
<h2>findAll</h2>

	<table>
		<tr>
        	<th>번호</th>
       		<th>아이디</th>
       		<th>비밀번호</th>
       		<th>이름</th>
       		<th>메일</th>
       		<th>전화번호</th>
       		<th>조회</th>
       		<th>ajax 상세조회</th>
       		<th>삭제</th>
       		<th>수정</th>
        </tr>
	<c:forEach items="${mList}" var="m">
		 <tr>
		<td>${m.m_number} </td>
		<td>${m.m_id} </td>
		<td>${m.m_password} </td>
		<td>${m.m_name} </td>
		<td>${m.m_email} </td>
		<td>${m.m_phone} </td>
		<td><a href="detail?m_number=${m.m_number}">조회</a> </td>
		<td><button onclick="detailAjax('${m.m_number}')">조회(ajax)</button></td>
		<td><a href="remove?m_number=${m.m_number}">삭제</a> </td>
		<td><a href="update?m_number=${m.m_number}">수정</a> </td>
		 </tr> 
		<br>
	</c:forEach>
	</table>
	
	<!-- ajax로 가져온 상세조회 결과를 여기에 보여줌 -->
	<div id="detail-view"></div>


</body>
</html>