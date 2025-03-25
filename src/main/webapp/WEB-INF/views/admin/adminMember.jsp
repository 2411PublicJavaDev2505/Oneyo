<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자-회원관리</title>
	<link rel="stylesheet" href="../resources/css/mypage/myReply.css"> 
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page ="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
	<main class="main">
	    <div class="myPageMain">
		    <section class="Info"> <!-- 왼쪽 -->
		    <nav class="myInfomation">
		        <div class="myPicture"></div>
		        <div class="detailInformation">
		            <div>이름 : ${memberName }</div>
		            <div>닉네임 : ${memberNickname }</div>
					<button class="deleteMember" onclick="location.href='member/delete?memberId=${memberId }'">회원탈퇴</button>
	              <button class="updateMember"  onclick="location.href='member/modify'">회원정보수정</button>
		        </div>
		    </nav>
		    </section>
	
			<!-- 마이 페이지 기본틀 -->
		    <div class="myDetail-container">
		        <div class="adminMenu">
			        <button><a href="/admin/member">전체 회원 정보</a></button>
			        <button><a href="#">재료 관리</a></button>
		        </div>			        
		        <div class="search-container">
		            <form class="search-form"  action="/board/search">
		                <select class="search-select"  name="searchCondition" >
		                    <option value="total">전체</option>
		                    <option value="id">아이디</option>
		                    <option value="nick">닉네임</option>
		                </select>
		                <input class="search-input" type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
		                <button type="submit">검색</button>
		            </form>
		        </div>			
	
			    <div>
			        <section class="my-sources">
			            <table> <!-- 회원 목록 --> 
			                <thead>
			                    <tr>
			                        <th class="member-id">아이디</th>
			                        <th class="member-nick">닉네임</th>
			                        <th class="member-name">이름</th>
			                        <th class="member-birth">생년월일</th>
			                        <th class="member-del">삭제</th>
			                    </tr>
			                </thead>
			                <tbody>
                    			<c:forEach items="${mList }" var="member" varStatus="i"> 
			                        <tr class="sources">
			                            <td class="member-id">${member.memberId}</td>
			                            <td class="member-nick">${member.memberNickname }</a></td>
			                            <td class="member-name">${member.memberName }</td>
			                            <td class="member-birth">${member.memberBirth }</td>
			                            <td class="member-del"><button><a href="#">DEL</a></button></td>
			                        </tr>
		                        </c:forEach>	
			                </tbody>
			            </table>
			            <!-- 페이지네이션 --> 
			            <div class="pagination">
							<a href="/admin/member?currentPage=1"> ◁◁ </a>
							<c:if test= "${startNavi ne 1 }">
								<a href="/admin/member?currentPage=${startNavi-1 }" class="prev">◀</a>
							</c:if>	
							<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
								<a href="/admin/member?currentPage=${p }">${p }</a>
							</c:forEach>					
							<c:if test="${endNavi ne maxPage }">
								<a href="/admin/member?currentPage=${endNavi+1 }" class="next">▶</a>
							</c:if>    
				           	<a href="/admin/member?currentPage=${maxPage }"> ▷▷ </a>
			            </div>
			        </section>
			    </div>
			</div>
	    </div>		
	</main>
	<!-- 푸터 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>