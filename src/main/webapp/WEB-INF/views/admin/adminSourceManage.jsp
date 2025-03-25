<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 재료관리</title>

</head>
<body>
	<div class="admin-container">
        <main class="admin-manage-page">
            <article class="profile">
                <div class="adminPicture"></div>
                <div class="admin-info">
                    <p class="adminMode">관리자로 접속 중입니다.</p>
                    <a href="#"><span>전체회원 정보</span></a>
                    <a href="/admin/source"><span>재료관리</span></a>
                    <div class="btn-group">
                        <button class="admin-logout">로그아웃</button>
                        <button class="admin-modify">관리자 정보 수정</button>
                    </div>
                </div>
            </article>
            <article class="manage-controll">
                <section class="manage-container">
                    <div class="manage-btn-group">
                        <button class="member-manage-btn">전체 회원 정보</button>
                        <button class="grocery-manage-btn">재료 관리</button>
                    </div>
                    <div class="grocery-manage-box">
                        <!-- 카테고리 관리 -->
                        <section class="category-controll">
                            <div class="category-group">
                                <label for="category">분류</label>
                                <input type="text" id="category"/>
                            </div>
                            <div class="category-name-group">
                                <label for="category-name">카테고리명</label>
                                <input type="text" id="category-name"/>
                            </div>    
                            <div class="control-btn-group">
                                <button>등록</button>
                                <button>수정</button>
                                <button>삭제</button>
                            </div>
                        </section>
                        <!-- 재료 관리 -->
                        <section class="grocery-controll">
                            <div class="sub-category-group">
                                <label for="sub-category">소분류명</label>
                                <input type="text" id="sub-category"/>
                            </div>
                            <div class="ingredient-name-group">
                                <label for="ingredient-name">재료명</label>
                                <input type="text" id="ingredient-name"/>
                            </div>
                            <div class="control-btn-group">
                                <button>등록</button>
                                <button>수정</button>
                                <button>삭제</button>
                            </div>
                        </section>
                    </div>
                </section>
            </article>
        </main>
    </div>
    <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
</body>
</html>