package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.EmpBean;

public class EmpBeanTests {
	public static void main(String[] args) throws Exception {
		StandardServiceRegistry serviceRegistry =
				new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(
				serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//insert
		EmpBean insert = new EmpBean();
		insert.setEmpname("hehehe");
		insert.setDeptid(10);
		session.save(insert);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
