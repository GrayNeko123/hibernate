package example;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.EmpBean;
import model.hibernate.HibernateUtil;

public class TestHQL {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
//		String hql9 = "select new map(emp as key1, dept.deptname as key2) from DeptBean dept, EmpBean emp where dept.deptid=emp.deptid";			
//		List<Map> results9 = session.createQuery(hql9, Map.class)
//			.list();
//		for(Map map : results9) {
//			EmpBean key1 = (EmpBean) map.get("key1");
//			String key2 = (String) map.get("key2");
//			
//			System.out.println(key1+":"+key2);
//		}

//		String hql10 = "select new list(emp, dept.deptname) from DeptBean dept, EmpBean emp where dept.deptid=emp.deptid";
//		List<List> results10 = session.createQuery(hql10, List.class)
//				.list();
//		System.out.println(results10);
		
//		String hql8 = "select emp, dept.deptname from DeptBean dept, EmpBean emp where dept.deptid=emp.deptid";
//		List<Object[]> results8 = session.createQuery(hql8, Object[].class)
//			.list();
//		for(Object[] array : results8) {
//			System.out.println(array[0]+":"+array[1]);
//		}


//		String hql7 = "select id, name from ProductBean";
//		List<Object[]> results7 = session.createQuery(hql7, Object[].class)
//			.list();
//		for(Object[] array : results7) {
//			System.out.println(array[0]+":"+array[1]);
//		}

//		String hql6 = "select deptname from DeptBean";
//		List<String> results6 = session.createQuery(hql6, String.class)
//			.list();
//		System.out.println("results6="+results6);
		
//		String hql5 = "from ProductBean";
//		List<ProductBean> results5 = session.createQuery(hql5, ProductBean.class)
//			.setFirstResult(3)
//			.setMaxResults(2)
//			.list();
//		System.out.println("results5="+results5); 
		
//		String hql4 = "from DeptBean where deptid in (:ids)";
//		List<DeptBean> results4 = session.createQuery(hql4, DeptBean.class)
//			.setParameterList("ids", Arrays.asList(10, 100))
//			.list();
//		System.out.println("results4="+results4); 
		
//		String hql3 = "from DeptBean where deptname like :xyz";
//		List<DeptBean> results3 = session.createQuery(hql3, DeptBean.class)
//			.setParameter("xyz", "%a%")
//			.list();
//		System.out.println("results3="+results3); 
		
//		String hql2 = "from DeptBean where deptname like ?100";
//		List<DeptBean> results2 = session.createQuery(hql2, DeptBean.class)
//				.setParameter(100, "%a%")
//				.list();
//		System.out.println("results2="+results2); 
		
//		String hql1 = "from DeptBean";
//		List<DeptBean> results1 = session.createQuery(hql1, DeptBean.class)
//				.list();
//		System.out.println("results1="+results1);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
