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
</head>
<body>
	<h2>findAll.jsp</h2>
	
	<form action="/board/search" method="get">
		<select name="searchtype">
			<option value="b_title">제목</option>
			<option value="b_writer">작성자</option> 
		</select>
			<input type="text" name="keyword" placeholder="검색어">
			<input type=submit vlaue ="검색">
	</form>
	
	
	<a href ="/">홈</a> 
	
	<table>
		<tr>
        	<th>번호</th>
       		<th>작성자</th>
       		<th>비밀번호</th>
       		<th>제목</th>
       		<th>내용</th>
       		<th>작성시간</th>
       		<th>조회수</th>
       		<th>삭제</th>
       		<th>수정</th>
        </tr>
	<c:forEach items="${bList}" var="b">
		<tr>
			<td>${b.b_number}</td>
			<td>${b.b_writer}</td>
			<td>${b.b_password} </td>
			<td>${b.b_title} </td>
			<td><a href="/board/view?b_number=${b.b_number}&page=${paging.page}">${b.b_contentsl}</a></td>
			<td>${b.b_date} </td>
			<td>${b.b_hits} </td>

	
		 </tr> 
		<br>
	</c:forEach>
	</table>
	
	<div>
		<c:choose>				
			<c:when test="${paging.page<=1}"> 
				[이전]&nbsp;
			</c:when>
			<c:otherwise>                     
		
				<a href="paging?page=${paging.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
					${i}
				</c:when>
				<c:otherwise>
					<a href="/board/paging?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<c:choose>
			<c:when test="${paging.page>=paging.maxPage}">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="paging?page=${paging.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>