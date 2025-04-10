<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디찾기</title>
		<link rel="stylesheet" href="../resources/css/member/findid.css">
	</head>
	<body>
	<form action="/member/findid" method="get">
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
	        <div class="login-box">
	            <h2>아이디 찾기</h2>
	            <label>이름</label>
	            <input type="text" placeholder="이름" name="memberName">
                <label>전화번호</label>	            
	            <input type="number" placeholder="전화번호를 입력하세요" name="memberPhone">
		        <button class="getid-link"><a href="/member/findIdResult">아이디찾기 </a></button>
	            <div class="linkButtons">
		            <a href="/member/join" class="register-link">회원가입</a>
	        	</div>
	        </div>
	    </main>
	    </form>
	    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>