package model.service;

import java.util.ArrayList;
import java.util.List;

import model.dao.ProductDAO;
import model.dao.ProductDAOJdbc;
import model.domain.ProductBean;

public class ProductService {
	private ProductDAO productDao = new ProductDAOJdbc();
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		List<ProductBean> selects = productService.select(null);
		System.out.println("selects="+selects);
	}
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		if(bean!=null && bean.getId()!=null && !bean.getId().equals(0)) {
			ProductBean temp = productDao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else {
			result = productDao.select(); 
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null && bean.getId()!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null && bean.getId()!=null) {
			result = productDao.update(bean.getName(), bean.getPrice(),
					bean.getMake(), bean.getExpire(), bean.getId());
		}
		return result;
	}
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null && bean.getId()!=null) {
			result = productDao.delete(bean.getId());
		}
		return result;
	}
}
