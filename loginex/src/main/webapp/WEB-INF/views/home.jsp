<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	로그인 페이지  
</h1>
<form method="get" action="success">
	<input name="id" type="text">
	<input name="password" type="password">
	<button>Login</button>
</form>
</body>
</html>
