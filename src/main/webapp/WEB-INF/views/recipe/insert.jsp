<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>레시피 페이지-등록</title>
    <link rel="stylesheet" href="../resources/css/recipe/insert.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

    <main>
        <form action="/recipe/insert" method="post" enctype="multipart/form-data">
            <div class="recipe-card">
                <button class="edit-btn" type="submit">등록</button>
                <div class="image-placeholder">
                    <img src="" alt="레시피 사진"/>
                </div>
                <div class="recipe-info">
                    <div class="text1">레시피 명: <input type="text" name="recipeTitle" placeholder="레시피 제목"></div>
                    <div class="text2">작성자: <input type="text" name="recipeWriter" placeholder="작성자"></div>
                    <div class="text2">조회수: 0</div>
                </div>
            </div>
            
            <div>
            	<label for="uploadFile">레시피 사진 업로드</label>
            	<input type="file" name="uploadFile" id="uploadFile" />
            </div>

            <div class="ingredient-container">
                <div class="ingredient-group">
                    <h2>재료</h2>
                    <div class="ingredient-box">
                        <input type="text" name="ingredientName1" placeholder="재료명">
                        <input type="text" name="ingredientAmount1" placeholder="수량">
                    </div>
                    <div class="ingredient-box">
                        <input type="text" name="ingredientName2" placeholder="재료명">
                        <input type="text" name="ingredientAmount2" placeholder="수량">
                    </div>
                    <div class="ingredient-box">
                        <input type="text" name="ingredientName3" placeholder="재료명">
                        <input type="text" name="ingredientAmount3" placeholder="수량">
                    </div>
                    <div class="ingredient-box">
                        <input type="text" name="ingredientName4" placeholder="재료명">
                        <input type="text" name="ingredientAmount4" placeholder="수량">
                    </div>
                    <div class="ingredient-box">
                        <input type="text" name="ingredientName5" placeholder="재료명">
                        <input type="text" name="ingredientAmount5" placeholder="수량">
                    </div>
                </div>
            </div>

            <div class="recipe">
                <div class="recipe-number"></div>
                <div class="recipe-info">
                    <textarea class="recipe-content" name="recipeContent" placeholder="레시피 내용을 단계별로 입력해주세요"></textarea>
                </div>
                <div class="recipe-image">
                    <img src="" alt="레시피 사진"/>
                </div>
            </div>
        </form>
    </main>
    
    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>