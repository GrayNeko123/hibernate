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
		Session session=factory.openSession();
		Transaction trx=session.beginTransaction();
		
		DeptBean insert=new DeptBean();
		insert.setDeptid(66);
		insert.setDeptname("G");
		session.save(insert);
		
		trx.commit();
		
		session.close();
		factory.close();
	}

}
