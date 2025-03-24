<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
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
<button class="deleteMember" onclick="location.href='member/delete?memberId=${member.memberId }'">회원탈퇴</button>
              <button class="updateMember"  onclick="location.href='member/modify?memberId=${member.memberId }'">회원정보수정</button>
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
        <select class="refridgeTitle" name="selectStorage" >
            <option value="C">냉장고</option>
            <option value="I">냉동고</option>
        </select><br>
        <button class="insertSource" ><a href="javascript:popup()" target="_self">재료 추가</a></button> 
        </div>
        
        
        <div>
            <section class="my-sources" >
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
                                     
					<%-- <p>cList 크기: ${cList != null ? cList.size() : 0}</p>   --%> 
					
         

	                    <tbody>
	                        <div class="sources-Lists" id="coolStorage">
	                           	<c:forEach items= "${cList }" var="source">
		                            <tr  class="sources" id="">
		                                <td class="num">1</td>
		                                <td class="source-name">${source.sourceName }</td>
		                                <td class="due-date">${source.dueDate }</td>
		                                <td class="count">${source.sourceCount }</td>
		                                <td class="action">
		                                    <button><a href="#">수정</a></button>
		                                    <button><a href="#">삭제</a></button>
		                                </td>
		                             </tr>
	                           	 </c:forEach>
	                        </div>                        
	                    </tbody>

	                    <tbody>
	                        <div class="sources-Lists" id="iceStorage">
	                           	<c:forEach items= "${iList }" var="source">
		                            <tr  class="sources">
		                                <td class="num">1</td>
		                                <td class="source-name">${source.sourceName }</td>
		                                <td class="due-date">${source.dueDate }</td>
		                                <td class="count">${source.sourceCount }</td>
		                                <td class="action">
		                                    <button><a href="#">수정</a></button>
		                                    <button><a href="#">삭제</a></button>
		                                </td>
		                             </tr>
	                           	 </c:forEach>
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
 		
 	
    <script>
        function popup() {
            var url="insertMySource";
            var name="popup test";
            var option="width = 500, height= 500, top = 100, left= 200, location = no"
            window.open(url, name, option);
        }
       
        
        
        
        
    </script> 		
 		
 		
</body>
</html>