package com.niit.shoppingbackendDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackendmodel.Login;

import com.niit.shoppingbackendmodel.Login;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public LoginDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void save(Login user) {
		sessionFactory.getCurrentSession().save(user);
	}
	@Transactional
	public void Update(Login user) {
		sessionFactory.getCurrentSession().update(user);
	}
	@Transactional
	public void delete(int id) {
		Login userToDelete =new Login();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}
	@Transactional
	public Login get(int id) {
		String hql ="from Login where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Login> listUser =(List<Login>) query.getResultList();
		if(listUser != null || listUser.isEmpty()){
			return listUser.get(0);
		}	
		return null;
	}
	
@Transactional
	public List<Login> list() {
		/*@SuppressWarnings("unchecked")
		List<Login> listUser =(List<Login>)
		sessionFactory.getCurrentSession().createCriteria(Login.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listUser;*/
	Session session=sessionFactory.openSession();
	List<Login> list=session.createQuery("from Login").list();
	session.close();
	return list;
	}
public void update(Login login) {
	// TODO Auto-generated method stub
	
}

}

	


