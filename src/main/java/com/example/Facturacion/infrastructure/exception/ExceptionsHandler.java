package com.example.Facturacion.infrastructure.exception;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionsHandler
{
	private static final Logger LOG = Logger.getLogger(ExceptionsHandler.class.getName());
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode HandlerException(Exception ex)  {
		String msg = ex==null ? "Error no Controlado" : ex.getMessage();
		return this.ThrowInfraExecption(msg);
	}
	
	@ExceptionHandler(InvalidateNameException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode InvalidateName(InvalidateNameException ex) {
		return this.ThrowInfraExecption(ex.getMessage());
	}
	
	@ExceptionHandler(CantidadErrorException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode CantidadError(CantidadErrorException ex)  {
		return this.ThrowInfraExecption(ex.getMessage());
	}
	
	@ExceptionHandler(ValueErrorException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode ValueErrror(ValueErrorException ex)  {
		return this.ThrowInfraExecption(ex.getMessage());
	}
	
	
	private ErrorCode ThrowInfraExecption(String exMessage) 
	{
		ErrorCode ec = new ErrorCode(this.getId(), exMessage);
		LOG.severe(ec.getCode());
		LOG.severe(ec.getErrorMessage());
		LOG.severe(exMessage);
		return ec;
	}
	
	private String getId() {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
