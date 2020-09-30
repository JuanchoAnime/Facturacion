package com.example.Facturacion.application;

import com.example.Facturacion.domain.modeldomain.UserDomain;
import com.example.Facturacion.domain.service.UserService;
import com.example.Facturacion.infrastructure.mapper.v2.UserMapper;
import com.example.Facturacion.infrastructure.rest.UserRest;

public class UserApplication 
{
	private final UserService service;
	
	public UserApplication(UserService service) {
		this.service = service;
	}
	
	public UserRest save(UserRest user) {
		UserDomain userDomain = UserMapper.INSTANCE.getByRest(user);
		user = UserMapper.INSTANCE.getRest(this.service.save(userDomain));
		user.setPassword("");
		return user;
	}
}
