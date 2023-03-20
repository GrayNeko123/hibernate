package example;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ProductBean;
import model.hibernate.HibernateUtil;

public class TestCriteria {
	public static List<ProductBean> method1(Session session) {
//		select * from product where name like '%c%' and price > 10 order by id desc
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = criteriaBuilder.createQuery(ProductBean.class);
		
//		from product
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		
//		name like '%c%'
		Predicate p1 = criteriaBuilder.like(root.get("name"), "%c%");
		
//		price > 10
		Predicate p2 = criteriaBuilder.greaterThan(root.get("price"), 10);
		
//		where name like '%c%' and price > 10
		criteriaQuery = criteriaQuery.where(p1, p2);
		
//		order by id desc
		criteriaQuery = criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
		
		TypedQuery<ProductBean> typedQuery = session.createQuery(criteriaQuery);
		List<ProductBean> result = typedQuery.getResultList();
		for(ProductBean row : result) {
			System.out.println("row="+row);
		}
		return result;
	}
	public static List<Object[]> method2(Session session) {
//		select price, count(price) from product where name like '%c%' or price > 10 group by price order by price desc
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

//		from product
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);

//		select price, count(price)
		criteriaQuery = criteriaQuery.multiselect(
				root.get("price"),
				criteriaBuilder.count(root.get("price"))
		);
		
//		name like '%c%'
		Predicate p1 = criteriaBuilder.like(root.get("name"), "%c%");
		
//		price > 10
		Predicate p2 = criteriaBuilder.greaterThan(root.get("price"), 10);
		
//		name like '%c%' or price > 10
		Predicate p3 = criteriaBuilder.or(p1, p2);
		
//		where name like '%c%' or price > 10
		criteriaQuery = criteriaQuery.where(p3);
		
//		group by price
		criteriaQuery = criteriaQuery.groupBy(root.get("price"));

//		order by price desc
		criteriaQuery = criteriaQuery.orderBy(criteriaBuilder.desc(root.get("price")));
		
		TypedQuery<Object[]> typedQuery = session.createQuery(criteriaQuery);
		List<Object[]> result = typedQuery.getResultList();
		for(Object[] row : result) {
			System.out.println(row[0]+":"+row[1]);
		}
		return result;
	}
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
//		method1(session);
		method2(session);

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
