<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	input,textarea{
	
	display:block;
	}
	</style>
</head>
<body>
<h2>insert.jsp</h2>
	<form action="/board/insert" method="POST">
		작성자 : <input type="text" name="b_writer">
		비밀번호 : <input type="password" name="b_password">
		제목 : <input type="text" name="b_title">
		내용 : <textarea name="b_contentsl" rows="5"></textarea>
		<!-- 작성시간 : <input type="date" name="b_date"> -->
		<input type="submit" value="글쓰기">

	</form>

<h2>파일첨부 글쓰기</h2>
	<form action="/board/insertfile" method="POST" enctype="multipart/form-data">
		작성자 : <input type="text" name="b_writer">
		비밀번호 : <input type="password" name="b_password">
		제목 : <input type="text" name="b_title">
		내용 : <textarea name="b_contentsl" rows="5"></textarea>
		파일 : <input type="file" name="b_file"><br>
		<input type="submit" value="글쓰기">
	</form>
	
</body>
</html>