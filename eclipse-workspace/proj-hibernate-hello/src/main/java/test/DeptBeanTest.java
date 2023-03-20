package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DeptBean;
import model.hibernate.HibernateUtil;

public class DeptBeanTest {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
//insert
		DeptBean insert = new DeptBean();
		insert.setDeptid(100);
		insert.setDeptname("hahahah");
		session.save(insert);
		
//select
//		DeptBean select = session.get(DeptBean.class, 10);
//		System.out.println("select="+select);

		
//update
//		DeptBean update = session.get(DeptBean.class, 300);
//		update.setDeptname("heheeh");
		
//delete		
//		DeptBean delete = session.get(DeptBean.class, 100);
//		session.delete(delete);

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
