package egovframework.example.service.vo;

import egovframework.example.service.Criteria;

public class PageVO {

	private int startPage, endPage, total, pageNum, amount;
	
	private boolean next, prev;
	
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.pageNum = cri.getPageNum();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int) Math.ceil(this.pageNum / 10.0) * 10;
		
		this.startPage = this.endPage - 10 + 1;
		
		int realEnd = (int) Math.ceil(this.total /(double) this.amount);	
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage >1;
		
		this.next = realEnd > this.endPage;		
	}
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", next=" + next + ", prev=" + prev
				+ ", total=" + total + ", pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
