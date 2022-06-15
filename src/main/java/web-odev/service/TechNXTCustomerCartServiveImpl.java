package technxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTCustomerCartDao;
import technxt.model.CustomerCart;

@Service
public class TechNXTCustomerCartServiveImpl implements TechNXTCustomerCartService {

	@Autowired
	private TechNXTCustomerCartDao ccd;
	
	public CustomerCart getCart(String cartid) {
		return ccd.getCart(cartid);
	}

	public int getCartSize(CustomerCart cart) {
		return ccd.getCartSize(cart);
	}

	public void updateCart(CustomerCart cart) {
		ccd.updateCart(cart);
	}

}
