package com.micheal.dts.io;

/**
 * 分页响应返回体
 */
public class RespPage<T> extends RespData<T> {
	private PageRes page;

	public PageRes getPage() {
		return page;
	}

	public void setPage(PageRes page) {
		this.page = page;
	}

}
