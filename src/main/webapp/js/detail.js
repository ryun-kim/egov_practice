q/**
 * 
 */
{
var btnContainerElem = document.querySelector('#btnContainer');
var btnDelElem = btnContainerElem.querySelector('#btnDel');
var btnModElem = btnContainerElem.querySelector('#btnMod');


btnDelElem.addEventListener('click',function (){
    if(confirm('삭제하시겠습니까')){
        location.href= '/del.do?posNum='+ btnContainerElem.dataset.iboard;
    }
});

btnModElem.addEventListener('click',function(){
	location.href= '/mod.do?posNum=' + btnContainerElem.dataset.iboard;
})

}