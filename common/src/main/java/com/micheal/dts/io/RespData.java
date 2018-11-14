package com.micheal.dts.io;

/**
 * 
 */
public class RespData<T> extends RespCode {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
