package com.niit.shoppingbackendDAO;

import java.util.List;


import com.niit.shoppingbackendmodel.Product;

public interface ProductDAO {
	public List<Product> list();
	public Product get(int id);
	public void saveOrUpdate(Product product);
	public void delete(int id);
	public int deleteProduct(int id);
	public List getAllProducts();

	
}

