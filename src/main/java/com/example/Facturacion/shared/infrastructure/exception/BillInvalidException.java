package com.example.Facturacion.shared.infrastructure.exception;

import org.springframework.context.MessageSource;

public class BillInvalidException extends BusinessException 
{
	
	private static final long serialVersionUID = 9211084656898118913L;

	public BillInvalidException(MessageSource messageSource) {
		super("exception.billInvalid", messageSource);
	}
}
