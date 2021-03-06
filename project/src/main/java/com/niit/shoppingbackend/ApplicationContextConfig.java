package com.niit.shoppingbackend;


import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;


import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingbackendDAO.CategoryDAO;
import com.niit.shoppingbackendDAO.CategoryDAOImpl;
import com.niit.shoppingbackendDAO.ProductDAO;
import com.niit.shoppingbackendDAO.ProductDAOImpl;
import com.niit.shoppingbackendDAO.SupplierDAO;
import com.niit.shoppingbackendDAO.SupplierDAOImpl;
import com.niit.shoppingbackendDAO.RegisterDAO;
import com.niit.shoppingbackendDAO.RegisterDAOImpl;
import com.niit.shoppingbackendmodel.Category;
import com.niit.shoppingbackendmodel.Product;
import com.niit.shoppingbackendmodel.Supplier;
import com.niit.shoppingbackendmodel.Login;
import com.niit.shoppingbackendmodel.Register;





@Configuration
@ComponentScan("com.niit.shoppingbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/pizzacart");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.addProperties(getHibernateProperties());
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		sessionFactoryBuilder.addAnnotatedClass(Login.class);
		sessionFactoryBuilder.addAnnotatedClass(Register.class);
		
		return sessionFactoryBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="registerDAO")
	public RegisterDAO getUserDAO(SessionFactory sessionFactory)
	{
		return new RegisterDAOImpl(sessionFactory);
	}
}

