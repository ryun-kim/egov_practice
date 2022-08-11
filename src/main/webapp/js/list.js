/**
 * 
 */
function moveToDetail(posNum){
    location.href='/detail.do?posNum=' + posNum;
}

var actionForm = $("#actionForm");


$("#content a").on("click", function(e){
	e.preventDefault();
	console.log('click');
	console.log($(this).attr("href"));
	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	actionForm.submit();	
})

/*var actionForm = document.querySelector("#actionForm");

actionForm.addEventListener('click', function(e){
	e.preventDefault();
	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	actionForm.submit();
})
*/