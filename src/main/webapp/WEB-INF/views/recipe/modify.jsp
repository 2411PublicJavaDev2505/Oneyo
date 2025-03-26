<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 페이지 - 수정 및 삭제</title>
		<link rel="stylesheet" href="../ONEYO/css/modify.css">
	</head>
	<body>
	
		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
	    <main>
	        <div class="recipe-card">
	            <div class="image-placeholder">
	            	<img src="" alt="레시피 사진"/>
	            </div>
	            <div class="recipe-info">
	                <div class="recipe-title-box">
	                    <input type="text" placeholder="레시피 명을 입력해주세요">
	                </div>
	                <span>작성자: {recipeWriter}</span>
	            </div>
	        </div>
	    </main>
	    <div class="ingredient-container1">
	        <div class="ingredient-group1">
	            <h2>재료</h2>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	               
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	               
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	             
	            </div>
	        </div>
	        <!-- <div class="ingredient-group">
	            <h2>양념</h2>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">               
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	        </div> -->
	    </div>
	    <div class="recipe">   
	            
	            <div class="ingredient-group">
	            	<h2>레시피 상세 내용</h2>
	            	
	                <div class="ingredient-box">
	                	첫번째 :
	                    <input type="text" placeholder="상세내용을 입력해주세요">
	                    <input type="text" placeholder="수량을 입력해주세요">
	                </div>
	                <div class="ingredient-box">
	                	두번째 :
	                    <input type="text" placeholder="상세내용을 입력해주세요">
	                    <input type="text" placeholder="수량을 입력해주세요">
	                </div>
	                <div class="ingredient-box">
	                	세번째 :
	                    <input type="text" placeholder="상세내용을 입력해주세요">
	                    <input type="text" placeholder="수량을 입력해주세요">
	                </div>
	                <div class="ingredient-box">
	                	네번째 :
	                    <input type="text" placeholder="상세내용을 입력해주세요">
	                    <input type="text" placeholder="수량을 입력해주세요">
	                </div>
	                <div class="ingredient-box">
	                	다섯번째 :
	                    <input type="text" placeholder="상세내용을 입력해주세요">
	                    <input type="text" placeholder="수량을 입력해주세요">
	                </div>
	            </div>
	        </div>
	
			
			<br>
			
			<div>
			  <button type="button" onclick="addStep();">단계 추가하기</button>
			  <button type="button" onclick="showModifyForm(${recipe.recipeNo});">수정완료</button>
			  <button type="button" onclick="deleteConfirm(${recipe.recipeNo});">삭제하기</button>
			</div>
			
			<script>
			  // 단계 추가하기
			  function addStep() {
			    const stepContainer = document.querySelector(".recipe");
			    if (!stepContainer) {
			      alert("단계를 추가할 수 없습니다. '.recipe' 클래스를 가진 div가 존재하지 않습니다.");
			      return;
			    }
			
			    const stepCount = stepContainer.querySelectorAll(".ingredient-box").length + 1;
			
			    const stepDiv = document.createElement("div");
			    stepDiv.classList.add("ingredient-box");
			    stepDiv.innerHTML = `
			      ${stepCount}번째 :
			      <input type="text" placeholder="상세내용을 입력해주세요">
			      <input type="text" placeholder="수량을 입력해주세요">
			    `;
			    stepContainer.appendChild(stepDiv);
			  }
			
			  // 수정완료
			  function showModifyForm(recipeNo) {
			    alert("레시피가 수정되었습니다.");
			    location.href = "/recipe/list";
			  }
			
			  // 삭제하기
			  function deleteConfirm(recipeNo) {
			    const check = confirm("정말로 삭제하시겠습니까?");
			    if (check) {
			      alert("레시피가 삭제되었습니다.");
			      location.href = "/recipe/list";
			    }
			  }
			</script>
			
			
			
			
			
	   <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
</html>

