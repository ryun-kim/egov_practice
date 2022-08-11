/**
 * 
 */

function moveToDetail(posNum){

	if(confirm('수정을 취소 하시겠습니까?')){
		location.href='/detail.do?posNum=' + posNum;
    }
    
}