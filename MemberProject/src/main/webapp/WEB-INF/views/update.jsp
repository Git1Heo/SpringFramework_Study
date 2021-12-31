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
<script>
	function update(){
		const idValue=document.getElementById("m_password").value;
		const pwValue=${updateShow.m_password };
		if(idValue==pwValue){			
		//이 문장이 아래 form을 전송하는 문장
			update_form.submit();	}	
		else		{
		 alert("다시입력하세요");
		
	}
	}	
		
	

</script>

</head>
<body>

	<form action="update" method="post" name="update_form">
		번호 : <input type="text" name="m_number" value="${updateShow.m_number }" readonly>
		아이디 : <input type="text" name="m_id" value="${updateShow.m_id }" readonly>
		비밀번호 : <input type="text" name="m_password" id="m_password">
		이름 : <input type="text" name="m_name" value="${updateShow.m_name }" readonly>
		이메일 : <input type="text" name="m_email" value="${updateShow.m_email }">
		전화번호 : <input type="text" name="m_phone" value="${updateShow.m_phone }">
		<input type="button" value="전송" onclick="update()">
	</form>

</body>
</html>