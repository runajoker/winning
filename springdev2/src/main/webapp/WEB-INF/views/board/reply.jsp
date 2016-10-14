<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="vo" value="${boardVO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.png" />
</head>
<body>
	<table>
	<caption>게시물 입력</caption>
	<form action="replyAction" method="post">
		<tr>
			<th>답글할번호</th>
			<td><input type="hidden" name="pno" value="${vo.no}" />${vo.no}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="re : ${vo.title}" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="10" name="content" >${vo.content}

--------------------
</textarea></td>
		</tr>
		<tr>
			<input type="submit" value="전송">
			
		</tr>
		</form>
	</table>
</body>
</html>