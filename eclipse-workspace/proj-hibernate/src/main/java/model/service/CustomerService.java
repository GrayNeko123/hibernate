package model.service;

import java.util.Arrays;

import model.dao.CustomerDAO;
import model.domain.CustomerBean;

public class CustomerService {
	private CustomerDAO customerDao;
	public CustomerService(CustomerDAO customerDao) {
		super();
		this.customerDao = customerDao;
	}
	public static void main(String[] args) {
//		CustomerService customerService = new CustomerService();
//		CustomerBean login = customerService.login("Alex", "A");
//		System.out.println("login="+login);	
//		
//		boolean change = customerService.changePassword(
//				"Ellen", "E", "EEE");
//		System.out.println("change="+change);	
	}
	public CustomerBean login(String username, String password) {
		CustomerBean bean = customerDao.select(username);
		if(bean!=null) {
			if(password!=null && password.length()!=0) {
				byte[] pass = bean.getPassword();
				byte[] temp = password.getBytes();
				if(Arrays.equals(pass, temp)) {
					return bean;
				}
			}
		}
		return null;
	}
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		CustomerBean bean = this.login(username, oldPassword);
		if(bean!=null) {
			byte[] temp = newPassword.getBytes();
			return customerDao.update(temp, bean.getEmail(), bean.getBirth(), username);
		}
		return false;
	}
}
