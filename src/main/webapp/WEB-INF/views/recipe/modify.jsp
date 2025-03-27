<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>레시피 페이지 - 수정 및 삭제</title>
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/recipe/modify.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
</head>
<body>
  <c:choose>
	    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
	        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
	    </c:when>
	    <c:otherwise>
	       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	    </c:otherwise>
	</c:choose>

  <!-- 레시피 카드 -->
  <main>
    <div class="recipe-card">
      <div class="image-placeholder">
        <img src="" alt="레시피 사진">
      </div>
      <div class="recipe-info">
        <div class="recipe-title-box">
          <input type="text" placeholder="레시피 명을 입력해주세요" value="${recipe.recipeTitle}">
        </div>
        <span>작성자: ${recipe.memberId}</span>
      </div>
    </div>
  </main>

<%-- <%--   <!-- 재료 입력 -->
  <div class="ingredient-container">
    <h2>재료</h2>
    <c:forEach items="${sourceList}" var="source">
      <div class="ingredient-box">
	    <input type="text" placeholder="재료명" value="${source.sourcesName}">
      </div>
    </c:forEach>
  </div>

  <!-- 레시피 단계 수정 -->
  <div class="recipe-step">
    <h2>레시피 단계</h2>
    <c:forEach items="${stepList}" var="step" varStatus="status">
      <div class="step-container">
        <div class="step-number">
          <p>${status.index + 1}</p>
        </div>
        <div class="step-info">
          <input type="hidden" name="stepNo" value="${step.stepNo}">
          <input type="text" placeholder="상세내용을 입력해주세요" value="${step.stepContent}">
          <input type="text" placeholder="수량을 입력해주세요" value="${step.stepAmount}">
        </div>
        <div class="recipe-image">
          <img src="${step.stepFilePath}" alt="등록된 사진이 없습니다.">
        </div>
      </div>
    </c:forEach>
  </div>

  <br>
  <div class="button-container">
	  <button type="button" class="left-btn" onclick="addStep();">단계 추가하기</button>
	  <div class="right-btns">
	    <form action="/step/update" method="POST">
        <input type="hidden" name="recipeNo" value="${recipe.recipeNo}">
        <button type="submit" class="edit-btn1">수정완료</button>
      </form>
      <button type="button" class="edit-btn2" onclick="deleteConfirm(${recipe.recipeNo});">삭제하기</button>
    </div>
  </div> --%> --%>
  
  <script>
		  function addStep() {
		    const stepContainer = document.querySelector(".recipe-step");
		    const stepCount = stepContainer.querySelectorAll(".step-container").length + 1;

		    const stepDiv = document.createElement("div");
		    stepDiv.classList.add("step-container");
		    stepDiv.innerHTML = `
		      <div class="step-number">
		        <p>\${stepCount}</p>
		      </div>
		      <div class="step-info">
		        <input type="text" placeholder="상세내용을 입력해주세요">
		        <input type="text" placeholder="수량을 입력해주세요">
		      </div>
		      <div class="recipe-image">
		        <img src="" alt="등록된 사진이 없습니다.">
		      </div>
		    `;
		    stepContainer.appendChild(stepDiv);
		  }

		  function showModifyForm(recipeNo) {
		    alert("레시피가 수정되었습니다.");
		    location.href = "/recipe/list";
		  }

		  function deleteConfirm(recipeNo) {
		    const check = confirm("정말로 삭제하시겠습니까?");
		    if (check) {
		      alert("레시피가 삭제되었습니다.");
		      location.href = "/recipe/list";
		    }
		  }
		</script>
  

  <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>