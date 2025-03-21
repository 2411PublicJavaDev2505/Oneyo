<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage/myRefridge.css"> 
</head>
<body>
		<!--  헤더-->
 		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
 		
   <main class="main">
        <div class="myPageMain">
        <section class="Info">
        <nav class="myInfomation">
            <div class="myPicture"></div>
            <div class="detailInformation">
                <div>이름 : 일용자</div>
                <div>닉네임 : 마셰코</div>
                <button class="deleteMember"><a href="/"></a></button>
                <button class="updateMember"><a href="/"></a></button>
            </div>
        </nav>
        </section>

    <!--       마이 냉장고 기본틀 -->
        <div class="myDetail-container">
            <div class="myPageMenu">
            <button><a href="/mypage/mypage">마이냉장고</a></button>
            <button><a href="/mypage/myBoard">내가 쓴글</a></button>
            <button><a href="/mypage/myReply">나의 댓글</a></button>
            </div>

    <!-- 		재료 등록 페이지 부분-->
        <div class="search-container">
        <form class="search-form"  action="/#">
            <input class="search-input" type="text" name="searchKeyword" placeholder="재료명을 입력하세요">
            <button type="submit">검색</button>
        </form>
    </div>               

        <div class="selectform">
        <select class="refridgeTitle">
            <option>냉장고</option>
            <option>냉동고</option>
        </select><br>
        <button class="insertSource" ><a href="javascript:popup()" target="_self">재료 추가</a></button> 

        </div>
        
        
        <div>
            <section class="my-sources">
                <table>
                    <thead>
                        <tr>
                            <th class="num">순서</th>
                            <th class="source-name">재료명</th>
                            <th class="due-date">유통기한</th>
                            <th class="count">수량</th>
                            <th class="action">수정/삭제</th>

                        </tr>
                    </thead>
                    <tbody>
                        <!-- 일반게시판 --> 
                        <div class="sources-Lists">
                            <tr  class="sources">
                                <td class="num">1</td>
                                <td class="source-name">삼겹살</td>
                                <td class="due-date">2024-03-20</td>
                                <td class="count">100g</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">2</td>
                                <td class="source-name">소금</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">3</td>
                                <td class="source-name">설탕</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">4</td>
                                <td class="source-name">등심</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">5</td>
                                <td class="source-name">팽이버섯</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">6</td>
                                <td class="source-name">새우</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">7</td>
                                <td class="source-name">고등어</td>
                                <td class="due-date">2025-08-30</td>
                                <td class="count">9999</td>
                                <td class="action">
                                    <button><a href="#">수정</a></button>
                                    <button><a href="#">삭제</a></button>
                                </td>
                            </tr>
                        </div>                        
                    </tbody>
                </table>
                
                <!-- 페이지네이션 --> 
                <div class="pagination">
                    <a href="#"> ◁◁ </a>
                    <a href="#"> ◀ </a>                        
                    <a href="#"> 1 </a>                        
                    <a href="#"> 2 </a>                        
                    <a href="#"> 3 </a>                        
                    <a href="#"> 4 </a>                        
                    <a href="#"> 5 </a>                        
                    <a href="#"> 6 </a>                        
                    <a href="#"> 7 </a>                        
                    <a href="#"> 8 </a>                        
                    <a href="#"> 9 </a>                        
                    <a href="#"> 10 </a>                        
                    <a href="#"> ▶ </a>                        
                    <a href="#"> ▷▷ </a>                    
                </div>
            </section>
        </div>
        </div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	 		
 		
 		
 		
 		
</body>
</html>