package technxt.dao;

import technxt.model.CustomerCart;

public interface TechNXTCustomerCartDao {
	
	public abstract CustomerCart getCart(String cartid); 
	public abstract int getCartSize(CustomerCart cart);
	public abstract void updateCart(CustomerCart cart);

}
