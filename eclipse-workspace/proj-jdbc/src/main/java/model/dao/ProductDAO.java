package model.dao;

import java.util.List;

import model.domain.ProductBean;

public interface ProductDAO {

	public abstract ProductBean select(Integer id);

	public abstract List<ProductBean> select();

	public abstract ProductBean insert(ProductBean bean);

	public abstract ProductBean update(String name, Double price,
			java.util.Date make, Integer expire, Integer id);

	public abstract boolean delete(Integer id);

}