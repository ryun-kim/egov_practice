<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원 등록</title>
</head>
<body>
	<h1>직원 등록</h1>
	<form action="/write.do" method="post">
		<div>
			<input type="text" name="POS_NUM" placeholder="사번" >
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
			<input type="text" name="POS_NAME" placeholder="이름">
		</div>
		<div>
			<input type="text" name="POS_PHONE" placeholder="휴대폰 번호(-를 빼고 입력하여 주세요)" >			
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
			<input type="text" name="POS_ETC" placeholder="기타">
		</div>
		
		<div>
			<input type="submit" value="저장">
			
		</div>
	</form>
</body>
</html>