package com.ABCBank.ABC.ABCBank.model;

public class RequestWrapper<T>  {
	
		private T body;
		private String status;
		private String message;
		public RequestWrapper() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RequestWrapper(T body, String status, String message) {
			super();
			this.body = body;
			this.status = status;
			this.message = message;
		}
		public T getBody() {
			return body;
		}
		public void setBody(T body) {
			this.body = body;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		

}
