package com.example.Facturacion.shared.infrastructure.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.example.Facturacion.shared.infrastructure.exception.BusinessException;

public class Util
{
	public static Util INSTANCE = new Util();
	
	@Autowired
	private MessageSource messageSource;

	public void throwException(String code, String param) {
		String messaje = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
		throw new BusinessException(messaje + ": " + param);
	}
}
