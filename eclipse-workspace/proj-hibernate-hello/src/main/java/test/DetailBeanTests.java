package test;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DetailBean;
import model.hibernate.HibernateUtil;

public class DetailBeanTests {
	public static void main(String[] args) throws Exception {
		String path = "C:/Users/Student/Desktop";
		
		File input1 = new File(path+"/01.jpg");
		int length1 = (int) input1.length();
		byte[] photo1 = new byte[length1];
		FileInputStream fis1 = new FileInputStream(input1);
		fis1.read(photo1);
		fis1.close();

		File input2 = new File(path+"/02.jpg");
		int length2 = (int) input2.length();
		byte[] photo2 = new byte[length2];
		FileInputStream fis2 = new FileInputStream(input2);
		fis2.read(photo2);
		fis2.close();

		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//insert
//		DetailBean insert = new DetailBean();
//		insert.setPhotoid(10);
//		insert.setPhoto(photo1);
//		session.save(insert);

//select
		DetailBean select = session.get(DetailBean.class, 10);
		System.out.println("select="+select);

//update
//		DetailBean update = session.get(DetailBean.class, 10);
//		update.setPhoto(photo2);

//delete
//		DetailBean delete = session.get(DetailBean.class, 10);
//		session.delete(delete);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
