package com.niit.shoppingbackendDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackendmodel.Category;
import com.niit.shoppingbackendmodel.Product;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	@Transactional
	public void delete(int id) {
		Category categoryToDelete =new Category();
		categoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
		
	}
	@Transactional
	public Category get(int id) {
		String hql ="from Category where id="+"'"+id+"'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory =(List<Category>) query.list();
		if(listCategory != null || listCategory.isEmpty()){
			return listCategory.get(0);
		}	
		return null;
	}
	
@Transactional
	public List<Category> list() {
		/*@SuppressWarnings("unchecked")
		List<Category> listCategory =(List<Category>)
		sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listCategory;*/
	Session session=sessionFactory.openSession();
	List<Category> list=session.createQuery("from Category").list();
	session.close();
	return list;
	
	}

}
		
	


