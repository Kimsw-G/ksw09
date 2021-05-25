<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${loginInfo.m_name}'s TODO</title>
<link href="/css/privacy/daily.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./todonav/todoNav.jsp"/>
		<button onclick="location.href='/todo/dailyWrite'">+</button>
		<form action="/todo/daily" method="post">
			<button>모두 보기</button>
		</form>
		<div id="todoList" class="daily">
		<c:forEach var="todo" items="${todoList}">
		<div class="index">
			<input type="checkbox" class="check">
			<p class="dday_ct">${todo.dday_pk}</p> <%-- 이걸 통해서 값 가져오기! --%>
			<p class="ctnt">${todo.ctnt}</p>
			<p class="regDate">${todo.date}</p>
			<button class="delete" onclick="location.href='/todo/dailyDelete?daily_pk=${todo.daily_pk}'">
				삭제하기
			</button>
		</div>
		</c:forEach>
		</div>
		<%-- 별도의 페이지에서 daily todo를 작성하기 --%>
	</div>
	
<script>
	document.getElementById("daily").style.borderBottom="21px solid whitesmoke";
</script>
</body>
</html>