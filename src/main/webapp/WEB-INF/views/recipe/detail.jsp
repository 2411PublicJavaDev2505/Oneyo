<!DOCTYPE html>
<html lang="ko">
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
        <div class="recipe-card">
            <button class="edit-btn">수정</button>
            <div class="image-placeholder">image</div>
            <div class="recipe-info">
                <div class="text1">레시피 명</div>
                <div class="text2">작성자</div>
                <div class="text2">조회수:0</div>
            </div>
        </div>
    </main>
    
        <div class="ingredient-container">
            <div class="ingredient-group">
                <h2>재료</h2>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
            </div>
            <div class="ingredient-group">
                <h2>양념</h2>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
                <div class="ingredient-box">
                    <input type="text" placeholder="재료명">
                    <input type="text" placeholder="수량">
                </div>
            </div>
        </div>
        <div class="recipe">
            <div class="recipe-number">1</div>
            <div class="recipe-info">
                <h2>레시피 상세 내용</h2>
            </div>
            <div class="recipe-image">image</div>
        </div>
    
        <div class="recipe">
            <div class="recipe-number">2</div>
            <div class="recipe-info">
                <h2>레시피 상세 내용</h2>
            </div>
            <div class="recipe-image">image</div>
        </div>
    
        <div class="recommend">
            <button class="star">⭐</button>
            <p>추천해요!</p>
        </div>
        <footer class="footer">
            <div class="footer-content">
                <a href="#">사이트 소개</a>
                <a href="#">연락처</a>
            </div>
        </footer>
    
</body>
</html>