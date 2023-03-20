package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

public class ProductBeanTests {
	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//insert
//		ProductBean insert = new ProductBean();
//		insert.setId(100);
//		insert.setName("hahaha");
//		insert.setPrice(12.34);
//		insert.setMake(new java.util.Date());
//		insert.setExpire(56);
//		session.save(insert);
		
//select
//		ProductBean select = session.get(ProductBean.class, 10);
//		System.out.println("select="+select);

//update
//		ProductBean update = session.get(ProductBean.class, 100);
//		update.setName("hohoho");
//		update.setPrice(4.5);
//		update.setMake(new java.util.Date(0));
//		update.setExpire(6);

//delete
//		ProductBean delete = session.get(ProductBean.class, 100);
//		session.delete(delete);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
