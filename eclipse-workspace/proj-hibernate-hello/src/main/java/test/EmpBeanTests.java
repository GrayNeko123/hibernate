package test;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.EmpBean;
import model.hibernate.HibernateUtil;

public class EmpBeanTests {
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
//		EmpBean insert = new EmpBean();
//		insert.setEmpname("hehehe");
//		insert.setSalary(100);
//		insert.setSex("F");
//		insert.setPhoto(photo1);
//		insert.setDeptid(10);
//		Serializable pk = session.save(insert);
//		System.out.println("insert="+pk);
		
//select
//		EmpBean select = session.get(EmpBean.class, 1);
//		System.out.println("select="+select);

//update
		EmpBean update = session.get(EmpBean.class, 7);
		update.setEmpname("hehehe");
		update.setSalary(1234);
		update.setSex("M");
		update.setPhoto(photo2);
		update.setDeptid(20);

//delete
//		EmpBean delete = session.get(EmpBean.class, 5);
//		session.delete(delete);

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}
}
