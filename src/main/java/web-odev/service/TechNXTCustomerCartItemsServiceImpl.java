package technxt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTCustomerCartItemsDao;
import technxt.model.CustomerCartItems;

@Service
public class TechNXTCustomerCartItemsServiceImpl implements TechNXTCustomerCartItemsService {

	@Autowired
	private TechNXTCustomerCartItemsDao ccid;
	
	public void addCartItem(CustomerCartItems cartItem) {

		ccid.addCartItem(cartItem);
		
	}

	public CustomerCartItems getCartItem(String cartItemId) {
		return ccid.getCartItem(cartItemId);
	}

	public void removeCartItem(String cartItemId) {
		
		ccid.removeCartItem(cartItemId);
		
	}

	public void removeAllCartItems(String customerid) {
	
		ccid.removeAllCartItems(customerid);
		
	}

}
