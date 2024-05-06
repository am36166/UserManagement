package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class Impuser implements IUser {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		Query query = session.createQuery("select u from User u");
		List<User> users = query.list() ;
		session.getTransaction().commit();
			return users;
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession() ;
		session.beginTransaction();
		User user = session.get(User.class, id) ;
		if(user != null) session.delete(user);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		session.getTransaction().commit();
		return user;
	}

}