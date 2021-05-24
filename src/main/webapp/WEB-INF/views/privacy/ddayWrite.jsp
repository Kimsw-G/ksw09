<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${loginInfo.m_name}'s TODO</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./todonav/todoNav.jsp"/>
	<form action="/todo/ddayWrite" method="post">
		
		<input type="date" value="" name="dday"> 
		<input type="text" name="content">
		<input type="submit" value="등록하기">
	</form>
	</div>
</body>
</html>