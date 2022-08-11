<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 상세 정보</title>
</head>
<body>	
	<h2><c:out value="${requestScope.posVo.POS_NAME}"/> 상세정보</h2>
    <div>사원번호 : <c:out value="${requestScope.posVo.POS_NUM}"/> </div>
    <div>직급 : <c:out value="${requestScope.posVo.POS_POSITION}"/> </div>
    <div>이름 : <c:out value="${requestScope.posVo.POS_NAME}"/></div>
    <div>휴대폰 번호 : <c:out value="${requestScope.posVo.POS_PHONE}"/> </div>
    <div>부서 : <c:out value="${requestScope.posVo.DEPT_NM}"/> </div>
    <div>기타 : <c:out value="${requestScope.posVo.POS_ETC}"/> </div>
    <br>
    <div id="btnContainer" data-iboard="${requestScope.posVo.POS_NUM}">
    	<a href="/pagingList.do"><button>리스트로 돌아가</button></a>
    	<button id="btnDel">삭제</button>
    	<button id="btnMod">수정</button>
    </div>
    
    <script src="/js/detail.js"></script>
</body>
</html>