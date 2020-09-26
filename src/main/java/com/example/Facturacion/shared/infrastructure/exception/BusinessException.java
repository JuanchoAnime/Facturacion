package com.example.Facturacion.shared.infrastructure.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class BusinessException extends RuntimeException 
{
	
	private static final long serialVersionUID = -6270183634410328700L;

	public BusinessException(String message, MessageSource messageSource) {
		super(messageSource.getMessage(message, null, LocaleContextHolder.getLocale()));
	}
}
