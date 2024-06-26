package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Categories;
import com.repository.CategoriesRepository;

@Service

public class CategoriesService {
	@Autowired
	private CategoriesRepository catrepo;
	
	public List<Categories> listAll()
	{
		return catrepo.findAll();
	}
	
	public void save(Categories categories)
	{
		 catrepo.save(categories);
	}
	
	public Categories get(long id)
	{
		return catrepo.findById(id).get();
	}
	
	public void delete(long id)
	{
		catrepo.deleteById(id);
	}

}
