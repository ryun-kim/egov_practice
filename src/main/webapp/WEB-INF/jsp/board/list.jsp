<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	.read
	{
		cursor:pointer;
		
	};
	
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">



$(document).ready(function() {
	
	var msg = "${msg}";
	
	if(msg != ""){
		alert(msg);	
	}
	
});

</script>

<%@include file="../includes/header.jsp" %>

<form method="get" id="listForm" action="/board/list.do">




<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Tables</h1>
<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                For more information about DataTables, please visit the 
				<a target="_blank" href="https://datatables.net">official DataTables documentation</a>.
</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">CRUD 테이블 연습</h6>
	</div>
	<!-- 검색 시작 -->
	<div class="card-header py-3">
		<input type="text" id="searchKeyword" name="searchKeyword" value="${list.searchKeyword}" 
			style="width:300px; height:40px;" placeholder="검색어를 입력하세요." />
		<a href="#" onclick="fn_search();" class="btn btn-primary">검색</a>
  	</div>
	<!-- 검색 끝 -->
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered"  width="100%" id="dataTable" cellspacing="0" style="text-align:center;"><!--id="dataTable"  -->
				<thead>
					<tr>
	                    <th>글번호</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                    <th>작성날짜</th>	                    
	                </tr>
				</thead>
				<c:forEach var="list" items="${boardList }">
					<tr>
						<td><c:out value="${list.board_idx }"/></td>
						<td onclick="moveToDetail(${list.board_idx})" class="read">						
						<c:out value="${list.board_title }"/>						
						</td>
						<td><c:out value="${list.board_writer }"/></td>
						<td><c:out value="${list.board_regdate }"/></td>
					</tr>
				</c:forEach>
			</table>
			<a href="/board/create.do" class="btn btn-primary">등록</a>
		</div>
	</div>
</div>
</div>
</form>
<!-- /.container-fluid -->
<%@include file="../includes/footer.jsp" %>


	<script src="/resources/js/boardList.js"></script>

    <!-- Bootstrap core JavaScript-->
    
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>
    

</body>

</html>