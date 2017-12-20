package com.DaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;
import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
		public UserDaoImpl()
		{}
	
	
	@Autowired
	private SessionFactory sessionFactory;

	

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public boolean saveUser(User user) {
		
		
		try {
			Session	session =sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	

}
