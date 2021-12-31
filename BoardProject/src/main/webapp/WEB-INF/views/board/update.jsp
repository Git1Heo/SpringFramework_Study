<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function update(){
	const pwValue=document.getElementById("pwCheck").value;
	if(pwValue==${updateShow.b_password})
		update_form.submit();	
	else
		alert("비밀번호가 틀렸습니다.")
	
}
</script>


</head>
<body>
	<h2>update.jsp</h2>
	
		<form action="/board/update" method="POST"  name="update_form">
		작성자 : <input type="text" name="b_writer" value="${updateShow.b_writer }" readonly>
		비밀번호 : <input type="passowrd" name="b_password" id="pwCheck" >
		제목 : <input type="text" name="b_title" value="${updateShow.b_title }">
		<%-- 내용 : <input type="text" name="b_contentsl" value="${updateShow.b_contentsl }"> --%>
		내용 : <textarea name="b_contentsl" rows="5">${updateShow.b_contentsl }</textarea>
		 <input type="hidden" name="b_number" value="${updateShow.b_number }">
		 <input type="hidden" name="b_date" value="${updateShow.b_date }">
		 <input type="hidden" name="b_hits" value="${updateShow.b_hits }">
		<input type="button" value="수정" onclick="update()">
		<input type="hidden" name="page" value=${page}>
	</form>
</body>
</html>