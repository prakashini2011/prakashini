package com.niit.shoppingbackendDAO;

import java.util.List;

import com.niit.shoppingbackendmodel.Category;

public interface CategoryDAO {
	public List<Category> list();
	public Category get(int id);
	public void saveOrUpdate(Category category);
	public void delete(int id);
}
