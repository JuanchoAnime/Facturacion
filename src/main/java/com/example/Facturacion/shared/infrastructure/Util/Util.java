package com.example.Facturacion.shared.infrastructure.Util;

public class Util
{
	public static void throwException(String code, String param) 
	{
		new UtilComponent().throwException(code, param);
	}
}
