/**
 * 
 */

/*$(document).ready(function() {
	
	var msg = "${msg}";
	
	if(msg != ""){
		alert(msg);	
	}
	
});*/

function moveToDel(idx){
	if(!confirm("삭제 하시겠습니까?")){
		return false;
	}else{
		location.href='/board/delete.do?board_idx='+ idx;
	}
}

function moveToUpdate(idx){
    location.href='/board/update.do?board_idx=' + idx;
}