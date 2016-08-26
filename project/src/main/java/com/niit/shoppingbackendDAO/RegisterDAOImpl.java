package com.niit.shoppingbackendDAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackendmodel.Supplier;
import com.niit.shoppingbackendmodel.Register;

@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {
	public List<Register> List(){
		//TODO Auto-generated method stub
		return null;
	}
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public RegisterDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Register user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	@Transactional
	public void delete(int id) {
		Register userToDelete =new Register();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}
	@Transactional
	public Register get(int id) {
		String hql ="from user where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Register> listUser =(List<Register>) query.getResultList();
		if(listUser != null && listUser.isEmpty()){
			return listUser.get(0);
		}	
		return null;
	}
	
@Transactional
	public List<Register> list() {
		@SuppressWarnings("unchecked")
		List<Register> listUser =(List<Register>)
		sessionFactory.getCurrentSession().createCriteria(Register.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listUser;
	}
		
	public boolean isValidUser(int id,String name){
		return false;
		
	}

}









