<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원  수정</title>
</head>
<body>
	<h1>${PosVo.POS_NAME} 수정페이지</h1>
	<form action="/mod.do" method="post">
		<div>
			<input type="hidden" name="POS_NUM" placeholder="사번" value="${PosVo.POS_NUM}">
		</div>
		<div>
			<select name="POS_POSITION" placeholder="직급">
				<option>사장</option>
				<option>전무이사</option>
				<option>상무이사</option>
				<option>이사</option>
				<option>부장</option>
				<option>차장</option>
				<option>과장</option>
				<option>대리</option>
				<option>주임</option>
				<option>사원</option>
			</select>
		</div>
		<div>
			<input type="text" name="POS_NAME" placeholder="이름" value="${PosVo.POS_NAME}">
		</div>
		<div>
			<input type="text" name="POS_PHONE" placeholder="휴대폰 번호(-를 제외하고 입력해주세요)" value="${PosVo.POS_PHONE}" >
		</div>
		<div>
			<select name="POS_TEAM" placeholder="부서">
				<option value=01000>경영관리팀</option>
				<option value=02000>혁신사업부문</option>
				<option value=03000>연구기획부문</option>
				<option value=99999>기타</option>
				<option value=02100>부문기획PO팀</option>
				<option value=02200>전략사업본부</option>
				<option value=02300>혁신사업본부</option>
				<option value=02400>SI사업본부</option>
				<option value=02500>클라우드센터</option>
				<option value=02410>분부기획팀</option>
				<option value=02420>교육사업부</option>
				<option value=02430>공공사업부</option>
				<option value=03100>금융사업본부</option>
				<option value=03200>미래사업기획실</option>
				<option value=03300>부설연구소</option>			
			</select>			
		</div>	
		<div>
			<input type="text" name="POS_ETC" placeholder="기타" value="${requestScope.PosVo.POS_ETC }">
		</div>
		<div>
			<input type="submit" value="저장">
			<input type="reset" value="리셋">
			
		</div>		
	</form>
	<div>
		<input onclick="moveToDetail(${PosVo.POS_NUM})" type="button" value="뒤로가기">
	</div>
	
	    <script src="/js/mod.js"></script>
</body>
</html>