package example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.EmpBean;
import model.hibernate.HibernateUtil;

public class TestNamedQuery {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		List<EmpBean> beans = session.createNamedQuery("bySalary", EmpBean.class)
			.setParameter("salary", 100)
			.list();
		System.out.println("beans="+beans);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
