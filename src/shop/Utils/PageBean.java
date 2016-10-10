package shop.Utils;

import java.util.List;

public class PageBean<T> {
	private Integer page;//当前要查询的页数
	private Integer limit;//每页显示几条记录
	private Integer totalCount;//数据库中总共存储的记录数
	private List<T> list;//显示到浏览器的数据
	private int TotalPage;//总页数
	
	
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

}
