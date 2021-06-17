package springMVC.productapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import springMVC.productapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/// create
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);

	}
	// get all product
	
	public List<Product> getProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}

	// Delete the single product
	
	@Transactional
	public void deleteProduct(int pId) {
		Product product = this.hibernateTemplate.load(Product.class, pId);
		this.hibernateTemplate.delete(product);
	}
	/// get single product
	
	public Product getProduct(int pId) {
		Product p = this.hibernateTemplate.get(Product.class, pId);
		return p;
	}
}
