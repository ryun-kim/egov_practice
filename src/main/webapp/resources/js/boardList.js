/**
 * 
 */

function moveToDetail(idx){
    location.href='/board/read.do?board_idx=' + idx;
}

function fn_search(){
	$("#listForm").submit();
	return false;
	}

function fn_go_page(pageNo) {
	$("#pageIndex").val(pageNo);
	$("#listForm").submit();
	return false;
}

function fn_search(){
	$("#pageIndex").val("1");
	$("#listForm").submit();
	return false;
}