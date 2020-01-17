package com.example.Facturacion.application;

import java.util.UUID;

public class GetID {
	public static String GetId() 
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
