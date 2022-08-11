package egovframework.example.service.vo;

public class Pagination {
	
	private int currentPageNo;
	private int recordCountPerPage;
	private int pageSize;
	private int totalRecordCount;
	
	private int firstPageNoOnPageList;
	private int firstRecordIndex;
	private int lastPageNoOnPageList;
	
	private boolean xprev;
	private boolean xnext;
	private int realEnd;
	
	
	
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getFirstPageNoOnPageList() {
		lastPageNoOnPageList = (int)(Math.ceil(currentPageNo/10.0))* 10;
		
		firstPageNoOnPageList = lastPageNoOnPageList -9;
		return firstPageNoOnPageList;
	}

	public int getLastPageNoOnPageList() {
		lastPageNoOnPageList = (int)(Math.ceil(getCurrentPageNo()/10.0))* 10;
		
		int realEnd = (int)(Math.ceil((getTotalRecordCount()*1.0)/getRecordCountPerPage()));
		
		if(realEnd < lastPageNoOnPageList) {
			lastPageNoOnPageList = realEnd;
		}
		return lastPageNoOnPageList;
	}
	
	public void setLastPageNoOnPageList(int lastPageNoOnPageList) {
		this.lastPageNoOnPageList = lastPageNoOnPageList;
	}
	
	public int getFirstRecordIndex() {
		firstRecordIndex = (getCurrentPageNo()-1) * getRecordCountPerPage();
		return firstRecordIndex;
	}
	
	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}
	
	public boolean getXprev() {
		xprev= getFirstPageNoOnPageList()>1;
		return xprev;
	}
	
	public void setXprev(boolean xprev) {
		this.xprev = xprev;
	}
	
	public boolean getXnext() {
		int realEnd = (int)(Math.ceil((getTotalRecordCount() * 1.0 / getRecordCountPerPage())));
		
		xnext = getLastPageNoOnPageList() < realEnd;
		return xnext;
	}
	
	public void setXnext(boolean xnext) {
		this.xnext = xnext;
	}
	
	public int getRealEnd() {
		realEnd = (int)(Math.ceil((getTotalRecordCount()* 1.0)/getRecordCountPerPage()));
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}	
}
