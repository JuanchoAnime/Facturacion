package com.example.Facturacion.infrastructure.exception;

public class ErrorCode 
{
	private String code;
	private String errorMessage;
	
	public ErrorCode(String code, String msg) {
		this.code = code;
		this.errorMessage = msg;
	}
	
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public String getErrorMessage() { return errorMessage; }
	public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
