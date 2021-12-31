<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input {
display : blcok;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function idDuplicate(){
		const id=document.getElementById("m_id").value;
		console.log(id);
		const checkResult=document.getElementById("id-dup-check");
		
		$.ajax({
			type:'post', // 전송방식(get,post,delete, put)
			url: 'idDuplicate', // 요청주소(컨트롤러를 요청하는 주소)
			data : {'4k':id}, //전송할 데이터
			dataType : 'text', // 요청 후 리턴받을 때의 데이터 형식
			success : function(result){ //요청이 성공적으로 처리됐을때 실행할 함수
				console.log('ajax성공')
				console.log(result)
				
				if(result=="ok"){
					checkResult.style.color = 'green';
					checkResult.innerHTML='멋진아이디네요!!';
				}
				else{
					checkResult.style.color = 'red';
					checkResult.innerHTML='이미 사용중인 아이디입니다.';
				}
			
			},
			error : function(){
				console.log('ajax실패');
			}
		});
		
	}


</script>
</head>
<body>
<h2>signup.jsp</h2>
<form action="insert" method="post">
	아이디 : <input type="text" name="m_id" id="m_id" onblur="idDuplicate()">
	<span id="id-dup-check"></span><br>
	비밀번호 : <input type="text" name="m_password">
	이름 : <input type="text" name="m_name">
	이메일 : <input type="text" name="m_email">
	전화번호 : <input type="text" name="m_phone">
	<input type="submit" value="회원가입">
</form>

</body>
</html>