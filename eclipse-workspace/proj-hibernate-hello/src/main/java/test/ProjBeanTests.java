package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ProjBean;
import model.hibernate.HibernateUtil;

public class ProjBeanTests {
	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//insert
//		ProjBean insert = new ProjBean();
//		insert.setProjid(300);
//		insert.setProjname("hahahah");
//		session.save(insert);

//select
		ProjBean select = session.get(ProjBean.class, 300);
		System.out.println("select="+select);

//update
//		ProjBean update = session.get(ProjBean.class, 300);
//		update.setProjname("hohoho");
		
//delete
//		ProjBean delete = session.get(ProjBean.class, 300);
//		session.delete(delete);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
