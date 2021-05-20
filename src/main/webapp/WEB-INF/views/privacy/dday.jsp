<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memberVO.m_name}'s TODO</title>
<link href="/css/privacy/dday.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./todonav/todoNav.jsp"/>
		<button onclick="location.href='/todo/ddayWrite'">+</button>
		<div id="todoList" class="dday">
		<c:forEach var="todo" items="${todoList}">
		<div class="index">
		<input type="hidden" name="dday" value="${todo.dday}"> <%-- 이 값을 js로 넘기기 --%>
			<p class="dday">D
			<c:choose>
				<c:when test="${todo.nowDday eq 0}">-DAY</c:when>
				<c:when test="${todo.nowDday gt 0}">+${todo.nowDday}</c:when>
				<c:otherwise>${todo.nowDday}</c:otherwise>
			</c:choose>
			</p>
			<p class="ctnt">${todo.content }</p>
			<button class="delete">삭제하기</button>
		</div>
		</c:forEach>
		</div>
	</div>

<script>
	document.getElementById("dday").style.borderBottom="21px solid whitesmoke";
</script>
</body>
</html>