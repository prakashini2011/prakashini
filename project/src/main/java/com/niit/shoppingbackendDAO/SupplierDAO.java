package com.niit.shoppingbackendDAO;

import java.util.List;

import com.niit.shoppingbackendmodel.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();
	public Supplier get(int id);
	public void saveOrUpdate(Supplier Supplier);
	public void delete(int id);
}
