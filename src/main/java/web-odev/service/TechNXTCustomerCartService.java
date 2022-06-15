package technxt.service;

import technxt.model.CustomerCart;

public interface TechNXTCustomerCartService {

	public abstract CustomerCart getCart(String cartid); 
	public abstract int getCartSize(CustomerCart cart);
	public abstract void updateCart(CustomerCart cart);
}
