package com.Thymeleaf.ExpenseTracker.advice;

import java.time.LocalDateTime;

//Keys in errorMessage: status, message, timestamp

public class ErrorMsg {
	public String status;
	public String message;
	public LocalDateTime timestamp;
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
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public ErrorMsg(String status, String message, LocalDateTime timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
	public ErrorMsg() {
		super();
	}
	@Override
	public String toString() {
		return "ErrorMsg [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
	
}
