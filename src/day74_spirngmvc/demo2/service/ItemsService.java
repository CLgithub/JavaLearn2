package day74_spirngmvc.demo2.service;

import java.util.List;

import day74_spirngmvc.demo2.entity.Items;

public interface ItemsService {

	List<Items> findAll();
	
	Items findbyId(int id) throws Exception;
}
