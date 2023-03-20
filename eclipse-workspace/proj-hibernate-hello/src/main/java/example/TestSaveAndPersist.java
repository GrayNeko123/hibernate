package example;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.EmpBean;
import model.hibernate.HibernateUtil;

public class TestSaveAndPersist {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		EmpBean insert1 = new EmpBean();
		insert1.setEmpname("save()");
		insert1.setDeptid(10);

		EmpBean insert2 = new EmpBean();
		insert2.setEmpname("persist()");
		insert2.setDeptid(10);

		Serializable pk1 = session.save(insert1);
		System.out.println("save() finished");
		System.out.println(pk1+":"+insert1.getEmpid());
		
		session.persist(insert2);
		System.out.println("persist() finished");
		System.out.println("insert2.getEmpid():"+insert2.getEmpid());

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
