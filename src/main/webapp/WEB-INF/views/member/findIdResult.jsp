<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과 페이지</title>
<link rel="stylesheet" href="../resources/css/member/findid.css">
	</head>
	<body>
	<form action="member/findIdresult" method="post">
		    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		
		<main>
	        <div class="login-box">
	            <h2>아이디 찾기 결과</h2>
	            <p>회원님의 아이디는 <strong>${memberId}</strong> 입니다 </p>
	            <a href="member/login" class="register-link">로그인하기</a>
	        </div>
	    </main>
	    </form>
	    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>