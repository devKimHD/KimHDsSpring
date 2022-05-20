package com.kh.myex01.vo;

public class PagingDto {
	private int page=1;
	private String searchType;
	private String keyword;
	private int count;
	private int startRow;
	private int endRow;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int perPage=10;
	private final int PAGE_BLOCK=10;
	
	public PagingDto() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		this.endRow= this.page*this.perPage;
		this.startRow=this.endRow-(this.perPage-1);
		this.totalPage=(int)(Math.ceil((double)this.count/this.perPage));
		this.startPage=((page-1)/PAGE_BLOCK)*PAGE_BLOCK+1;
		this.endPage=startPage+(PAGE_BLOCK-1);
		if(endPage > totalPage) {
			this.endPage=this.totalPage;
		}
		
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}



	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", searchType=" + searchType + ", keyword=" + keyword + ", count=" + count
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", TotalPage=" + totalPage + ", startPage="
				+ startPage + ", endPage=" + endPage + ", perPage=" + perPage + "]";
	}
	
	
}
