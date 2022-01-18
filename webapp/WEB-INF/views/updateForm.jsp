<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[Phonebook3]</h1>
	<h2>전화번호 수정폼</h2>
	<br>
	<p>수정화면입니다.
	   아래의 값을 수정하고 "수정" 버튼을 클릭하세요</p>
	
	<form action="/phonebook3/phone/update" method="get">
		이름(name):<input type="text" name="name" value="${pVo.name}"><br>
		핸드폰(hp):<input type="text" name="hp" value="${pVo.hp}"><br>
		회사(company):<input type="text" name="company" value="${pVo.company}"><br>
		코드(id):<input type="text" name="pId" value="${pVo.personId}"><br>
		<!-- action:<input type="text" name="action" value="update"><br>--> <!-- 컨트롤러의 action=update -->
		<button id="testId" type="submit">수정</button>
	</form>   
</body>
</html>