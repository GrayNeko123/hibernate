package example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import model.ProductBean;
import model.hibernate.HibernateUtil;

public class TestNativeQuery {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "SELECT * FROM PRODUCT";
		
		NativeQuery query3 = session.createNativeQuery(sql, ProductBean.class);
		List<ProductBean> data3 = (List<ProductBean>) query3.list();
		System.out.println("data3="+data3);

		String sql4 = "SELECT * FROM PRODUCT where id > :id";
		NativeQuery query4 = session.createNativeQuery(sql4, ProductBean.class)
			.setParameter("id", 8);
		List<ProductBean> data4 = (List<ProductBean>) query4.list();
		System.out.println("data4="+data4);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
