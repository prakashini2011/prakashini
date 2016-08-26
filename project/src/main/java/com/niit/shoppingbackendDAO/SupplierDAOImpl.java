package com.niit.shoppingbackendDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingbackendmodel.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Supplier Supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(Supplier);
	}
	@Transactional
	public void delete(int id) {
		Supplier SupplierToDelete =new Supplier();
		SupplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
		
	}
	@Transactional
	public Supplier get(int id) {
		String hql ="from Supplier where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier =(List<Supplier>) query.list();
		if(listSupplier != null || listSupplier.isEmpty()){
			return listSupplier.get(0);
		}	
		return null;
	}
	
@Transactional
	public List<Supplier> list() {
		/*@SuppressWarnings("unchecked")
		List<Supplier> listSupplier =(List<Supplier>)
		sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listSupplier;*/
	Session session=sessionFactory.openSession();
	List<Supplier> list=session.createQuery("from Supplier").list();
	session.close();
	return list;
	}
	

}
		
	


