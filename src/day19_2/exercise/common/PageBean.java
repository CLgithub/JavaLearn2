package day19_2.exercise.common;

import java.util.List;

public class PageBean {
	private int page; // 第几页
	private int pageSize; // 每页多少条记录
	private int total; // 总记录数
	private int totalPage; // 总页数
	private List<?> rows; // 要返回的某一页的记录列表
//	private int pageNum; // 当前页码
//
//	public int getPageNum() {
//		return pageNum;
//	}
//
//	public void setPageNum(int pageNum) {
//		this.pageNum = pageNum;
//	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getTotalPage() {
		return  (int) Math.ceil(total*1.0/pageSize);
	}

}
