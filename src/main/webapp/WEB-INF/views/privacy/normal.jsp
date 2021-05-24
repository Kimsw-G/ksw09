<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${loginInfo.m_name}'s TODO</title>
	<link href="/css/privacy/normal.css" rel="stylesheet" type="text/css" />
	<script src="/js/normal.js" type="text/javascript" defer></script>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="./todonav/todoNav.jsp"/>
		<div id="todoList" class="normal">
		<%-- 스크롤 설정하기! --%>
		<c:forEach var="todo" items="${todoList}">
		<div class="index">
			<input type="checkbox" class="check">
			<p class="ctnt">${todo.ctnt}</p>
			<p class="regDate">${todo.regDate}</p>		
		</div>
		</c:forEach>
		</div>
		<%--normal input--%>
<%--		<form action="/todo/normal" method="post" onsubmit="return insertNormal()">--%>
		<input type="text" name="ctnt" id="ctnt">
		<button onclick="insertNormal();">등록</button>
<%--		</form>--%>
	</div>
	
<script>
	document.getElementById("normal").style.borderBottom="21px solid whitesmoke";
</script>
</body>
</html>