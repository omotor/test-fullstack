package com.test.service;

import java.util.List;

public interface BaseService<Entity,ID> {

	List<Entity> findAll();
	Entity getById(ID id);
	void save(Entity entity);
	void delete(ID id);
	
}
