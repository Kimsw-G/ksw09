<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="/css/common.css" rel="stylesheet" type="text/css" />
<link href="/css/public/public.css" rel="stylesheet" type="text/css" />
<link href="/css/public/regist.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="/member/regist" method="post" id="wrapper">
	<strong>아이디</strong>
	<input type="text" placeholder="아이디" name="m_id" id="id" required>
	<%-- <button>중복체크</button> --%>
	<strong>비밀번호</strong>
	<input type="password" placeholder="비밀번호" name="m_pw" id="pw"required><br>
	<input type="password" placeholder="비밀번호 체크" name="m_pwck" id="pwck"required><br>
	<strong>이름</strong>
	<input type="text" placeholder="이름" name="m_name" id="name"required><br>
	<strong>전화번호</strong><br>
	<div id="tel">
	<%-- 첫 박스는 드롭다운으로 구현 --%>
		<input type="text" name="m_tel" id="tel_1"required>
		<input type="text" name="m_tel" id="tel_2"required>
	</div>
	<input type="submit" value="회원가입">
</form>
</body>
</html>