package com.micheal.dts.io;

/**
 * 分页请求报文
 */
public class PageReq<E> {
	private E condition;
	private Page page;

	public E getCondition() {
		return condition;
	}

	public void setCondition(E condition) {
		this.condition = condition;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
