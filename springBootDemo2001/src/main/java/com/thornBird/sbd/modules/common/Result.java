package com.thornBird.sbd.modules.common;

public class Result<T> {

	private int status;
	private T object;
	private String message;

	public Result(int status, T object, String message) {
		super();
		this.status = status;
		this.object = object;
		this.message = message;
	}

	public Result(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Result() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public enum ResultEnum {
		SUCCESS(200), FAILD(500);
		public int status;

		private ResultEnum(int status) {
			this.status = status;
		}

	}

}
