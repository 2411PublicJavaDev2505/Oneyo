<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>레시피 페이지</title>
    <link rel="stylesheet" href="../ONEYO/css/detail.css">
    <link rel="stylesheet" href="../ONEYO/css/header.css">
    <link rel="stylesheet" href="../ONEYO/css/footer.css">
</head>
<body>
    <header class="header">
        <div class="header-content">
            <h1 class="logo" ><a href="/">ONEYO</a></h1>
            <nav class="nav-menu">
                <a href="#">레시피</a>
                <a href="#">게시판</a>
                <a href="#">마이페이지</a>
                <div class="search-container">
                    <input type="text" class="search-input" placeholder="검색">
                    <button class="search-btn">🔍</button>
                </div>
                <a href="#" class="login">로그인</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="container">
            <div class="recipe-card">
                <button class="edit-button">수정</button>
                <div style="height: 200px; background-color: #ffffcc; display: flex; align-items: center; justify-content: center; border-radius: 5px;">
                    image
                </div>
                <div class="recipe-info">
                    <span>레시피 명</span>
                    <span>작성자</span>
                    <span>조회수: 0</span>
                </div>
                <h2>재료 양념</h2>
                <div class="wrapper">
                    <div class="section">
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                    </div>
                    <div class="section">
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                        <div class="item"> <input type="text" placeholder="재료명"> <input type="text" placeholder="수량"> </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="footer-content">
                        <a href="#">사이트 소개</a>
                        <a href="#">연락처</a>
                    </div>
                </footer>
            </div>
        </div>
    </main>
</body>
</html>