<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BananaTodo</title>
<link href="/css/common.css" rel="stylesheet" type="text/css" />
<link href="/css/public/public.css" rel="stylesheet" type="text/css" />
<link href="/css/public/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>BananaTODO</h1>

<form action="/member/login" method="post" id="wrapper">
	<input type="text" id="id" name="m_id" placeholder="아이디" value="kimsw">
	<input type="password" id="password" name="m_pw" placeholder="비밀번호" value="3445"><br>
	<button type="submit" id="login" form="wrapper">로그인</button>
	<%-- 후에 구글, 네이버 로그인 기능 구현해주기 --%>
	<a href="/member/regist" id="regist">BananaTODO 무료 회원가입</a>
</form>


</body>
</html>