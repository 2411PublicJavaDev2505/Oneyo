<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>oneyo-header</title>
		<link rel ="stylesheet" href="../resources/css/header.css">
	</head>
<body>
    <header class="header">
        <div class="header-content">
            <h1 class="logo" ><a href="/">ONEYO</a></h1>
            <nav class="nav-menu">
                
                <c:if test="${memberId ne null && memberId ne '' }">
                	<a href="/">레시피</a>
                	<a href="/board/boardlist">게시판</a>
					<a href="/mypage/mypage">마이페이지</a><br>
				<div class="search-container">
                    <input type="text" class="search-input" placeholder="검색">
                    <button class="search-btn">🔍</button>
                </div>
					<a href="/member/logout">로그아웃</a>
				</c:if>
				
				<c:if test="${memberId eq null || memberId eq '' }">
				<a href="/recipe">레시피</a>
                	<a href="/board/boardlist">게시판</a>
                <div class="search-container">
                    <input type="text" class="search-input" placeholder="검색">
                    <button class="search-btn">🔍</button>
                </div>
                <a href="/member/login" class="login">로그인</a>
				</c:if>
            </nav>
        </div>
    </header>
</body>
</html>