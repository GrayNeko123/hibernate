package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.DeptBean;

public class DeptBeanTest {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry =
				new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(
				serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
//insert
		DeptBean insert = new DeptBean();
		insert.setDeptid(100);
		insert.setDeptname("hahahah");
		session.save(insert);
		
//select
//		DeptBean select = session.get(DeptBean.class, 10);
//		System.out.println("select="+select);

		
		transaction.commit();
		session.close();
		factory.close();
	}
}
