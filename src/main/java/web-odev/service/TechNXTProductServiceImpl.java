package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTProductDaoImpl;
import technxt.model.Product;


@Service
public class TechNXTProductServiceImpl implements TechNXTProductService {

	@Autowired
	private TechNXTProductDaoImpl technxtPD;
	
	public void addProduct(Product product) {
		
		technxtPD.addProduct(product);
	}

	public void deleteProduct(String product_id) {
		technxtPD.deleteProduct(product_id);

	}

	public void updateProduct(Product product_id) {
		 technxtPD.updateProduct(product_id);

	}

	public List<Product> getAllProducts() {
	
		return technxtPD.getAllProducts();
	}

	public Product getProductById(String product_id) {
	
		return technxtPD.getProductById(product_id);
	}

}
