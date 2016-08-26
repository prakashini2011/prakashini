package com.niit.shoppingbackendDAO;
import java.util.List;

import com.niit.shoppingbackendmodel.Login;
import com.niit.shoppingbackendmodel.Login;

public interface LoginDAO {
	public List<Login> list();
	public Login get(int id);
	public void save(Login login);
	public void delete(int id);
	public void update(Login login);
}

