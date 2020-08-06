package com.example.Facturacion.shared.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<Rest, Domain, Dto>
{
	Rest getRest(Domain domain);
	
	Dto getDto(Domain domain);
	
	Domain getByRest(Rest rest);
	
	Domain getByDto(Dto dto);
	
	default List<Rest> getListRest(List<Domain> domains){
		return domains.stream().map(domain -> getRest(domain)).collect(Collectors.toList());
	}
	
	default List<Dto> getListDto(List<Domain> domains){
		return domains.stream().map(domain -> getDto(domain)).collect(Collectors.toList());
	}
	
	default List<Domain> getListByRest(List<Rest> rests){
		return rests.stream().map(rest -> getByRest(rest)).collect(Collectors.toList());
	}
	
	default List<Domain> getListByDto(List<Dto> dtos){
		return dtos.stream().map(dto -> getByDto(dto)).collect(Collectors.toList());
	}
}
