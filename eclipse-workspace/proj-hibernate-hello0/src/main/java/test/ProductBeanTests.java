package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.ProductBean;

public class ProductBeanTests {
	public static void main(String[] args) throws Exception {
		StandardServiceRegistry serviceRegistry =
				new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(
				serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//select
		ProductBean select = session.get(ProductBean.class, 10);
		System.out.println("select="+select);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
