package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DeptBean;
import model.hibernate.HibernateUtil;

public class TestLoadAndGet {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

//		DeptBean get1 = session.get(DeptBean.class, 10);
//		System.out.println("get1="+get1);
//
//		DeptBean load1 = session.load(DeptBean.class, 20);
//		System.out.println("load1="+load1);

		DeptBean get2 = session.get(DeptBean.class, 101);
		if(get2!=null) {
			System.out.println("get2="+get2);
		} else {
			System.out.println("get2 is null");
		}

		DeptBean proxy2 = session.load(DeptBean.class, 201);
//		if(proxy2!=null) {
//			System.out.println("proxy2 is not null");
//		} else {
//			System.out.println("proxy2 is null");
//		}
		try {
			System.out.println("proxy2="+proxy2);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("proxy2 is null");
		}

//		DeptBean get3 = session.get(DeptBean.class, 10);
//		DeptBean proxy = session.load(DeptBean.class, 20);
//		System.out.println("get3="+get3);
//		System.out.println("proxy="+proxy);

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
