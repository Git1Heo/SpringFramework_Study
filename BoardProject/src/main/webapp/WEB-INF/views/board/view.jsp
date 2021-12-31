<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<link href="/resources/css/test.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h2>view.jsp</h2>

			${view.b_number} 
			${view.b_writer} 
			${view.b_password} 
			${view.b_title} 
			${view.b_contentsl} 
			${view.b_date} 
			${view.b_hits} <br>
			<img alt="" src="/resources/upload/${view.b_filename}"> <br>
			<a href="/board/delete?b_number=${view.b_number}">삭제</a> 
			<a href="/board/update?b_number=${view.b_number}&page=${page}">수정</a>
	
	<br>
	<a href ="../">이전</a>
	<th><a href="/board/paging?page=${page}">목록</a> </th>
	
	<!-- 댓글 작성 -->
	<div id="comment-write">
		<input type="text" id="c_content" placeholder="댓글내용">
		<button id="comment-write-btn">댓글등록</button>	
	</div>
	
	<!-- 댓글목록출력 -->
	<div id="comment-list">
	<table class="table">
		<tr>
			<th>댓글번호</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성시간</th>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr>		
			<td>${comment.c_number}</td>
			<td>${comment.c_writer}</td>
			<td>${comment.c_contents}</td>
			<td>${comment.c_date}</td>
			</tr>		
		</c:forEach>
	</table>
	</div>
	
</body>
<script>
 	const commentBtn =document.getElementById("comment-write-btn");
 	commentBtn.addEventListener("click", function() {
 		
 		/* 		const c_writer=document.getElementById("c_writer").value;
		const c_content=document.getElementById("c_content").value; */
		
		const c_writer=document = $("#c_writer").val();
		const c_content=document = $("#c_content").val();
		const b_number = '${view.b_number}';
		
		$.ajax({
			type: 'post',
			url : 'comment/save',
			data:{'c_writer':c_writer,'c_contents':c_content,'b_number':b_number},
			dataType:'json', 
			success:function(result){
				console.log(result);
				let output = "<table class='table'>";
				output += "<tr><th>댓글번호</th>";
				output += "<th>작성자</th>";
				output += "<th>내용</th>";
				output += "<th>작성시간</th></tr>";
				for(let i in result){
					output += "<tr>";
					output += "<td>"+result[i].c_number+"</td>";
					output += "<td>"+result[i].c_writer+"</td>";
					output += "<td>"+result[i].c_contents+"</td>";
					output += "<td>"+result[i].c_date+"</td>";
					output += "</tr>";
				}
				output += "</table>";
				// id가 comment-list인 div에 출력
				document.getElementById('comment-list').innerHTML = output;
				// 댓글 입력창을 비움. 
				document.getElementById('c_writer').value='';
				document.getElementById('c_content').value='';
			},
			error:function(){
				console.log("오류오류")
			}
			
		});			
 	});	
 		
 	

 		  
 		 
	
 /* 	$("#comment-write-btn").click(function(){
		console.log("댓글등록버튼클릭");
	});  */
	
	
	
	
</script>

</html>