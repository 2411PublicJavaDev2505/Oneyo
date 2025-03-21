<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<<<<<<< HEAD
                <a href="/recipe/RecipeList">레시피</a>
                <a href="/">게시판</a>
                <a href="/">마이페이지</a>
=======
                <a href="/recipe">레시피</a>
                <a href="/board/list">게시판</a>
                <a href="/mypage/mypage">마이페이지</a>
>>>>>>> refs/remotes/origin/master
                <div class="search-container">
                    <input type="text" class="search-input" placeholder="검색">
                    <button class="search-btn">🔍</button>
                </div>

                <a href="/member/login" class="login">로그인</a>

            </nav>
        </div>
    </header>
</body>
</html>