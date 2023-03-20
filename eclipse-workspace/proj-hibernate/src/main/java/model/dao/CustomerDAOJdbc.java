package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.domain.CustomerBean;
import model.hibernate.HibernateUtil;

public class CustomerDAOJdbc implements CustomerDAO {
	private SessionFactory sessionFactory = null;
	public CustomerDAOJdbc(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		CustomerDAO dao = new CustomerDAOJdbc(sessionFactory);
		CustomerBean bean = dao.select("Babe");
		System.out.println("bean="+bean);
		
		boolean result = dao.update("E".getBytes(),
				"ellen@lab.com", new java.util.Date(0), "Ellen");
		System.out.println("result="+result);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public CustomerBean select(String custid) {
		if(custid!=null) {
			return this.getSession().get(CustomerBean.class, custid);
		}
		return null;
	}
	
	@Override
	public boolean update(byte[] password, String email, java.util.Date birth, String custid) {
		if(custid!=null) {
			CustomerBean temp = this.getSession().get(CustomerBean.class, custid);
			if(temp!=null) {
				temp.setPassword(password);
				temp.setEmail(email);
				temp.setBirth(birth);
				return true;
			}
		}
		return false;
	}
}
