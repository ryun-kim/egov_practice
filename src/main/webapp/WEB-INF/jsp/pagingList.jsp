<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
		display: block;
		width: 60%;
		margin: auto;
	}
	a {
		text-decoration: none;
	}
	.record{
		cursor:pointer;
		}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 리스트</title>
</head>
<body>
	<h1>직원 리스트</h1>	
		<c:choose>
			<c:when test="${fn:length(requestScope.dept) == 0}">
	                게시글이 없습니다.
	        </c:when>
	        <c:otherwise>
	        	<table>
	        		<tr>	        			
	        			<th>사원번호</th>
	        			<th>직급</th>
	        			<th>이름</th>
	        			<th>휴대폰번호</th>
	        			<th>부서</th>
	        			<th>기타</th>
	        		</tr>
	        		<c:forEach items="${requestScope.dept}" var="item" >
			        		<tr class="record"  onmouseover="this.style.backgroundColor='gray'"
						onmouseout="this.style.backgroundColor='transparent'" onclick="moveToDetail(${item.POS_NUM})">			        			
			        			<td>${item.POS_NUM}</td>
			        			<td>${item.POS_POSITION}</td>
			        			<td>${item.POS_NAME}</td>
			        			<td>${item.POS_PHONE}</td>
			        			<td>${item.DEPT_NM}</td>
			        			<td>${item.POS_ETC}</td>		
			        		</tr>			        			
	        		</c:forEach>
	        	</table>
	        </c:otherwise>
	      </c:choose>
	      <br/>
	<div id="content" align="center">
		<!-- pageNum -->
		<c:forEach var="num" begin="${pageVO.startPage }"
			end="${pageVO.endPage }">
			<a class="${pageVO.pageNum == num ? 'active': '' }" href="${num }">
				<input type="button" value="${num }" />
			</a>
		</c:forEach>
	</div>
	      <div>
	      	<a href="/write.do"><button>글쓰기</button></a>
	      </div>
	      
	      
	<form id="actionForm" action="pagingList.do" method="get">
		<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> 
		<input type="hidden" name="amount" value="${pageVO.amount }" />		
	</form>
	
	<script src="/js/list.js">
	
	</script>
</body>
</html>