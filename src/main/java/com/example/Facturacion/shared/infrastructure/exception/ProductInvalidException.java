package com.example.Facturacion.shared.infrastructure.exception;

import org.springframework.context.MessageSource;

public class ProductInvalidException extends BusinessException 
{
	
	private static final long serialVersionUID = 9211084656898118913L;

	public ProductInvalidException(MessageSource messageSource) {
		super("exception.productInvalid", messageSource);
	}
}
