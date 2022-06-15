package technxt.service;

import technxt.model.CustomerCartItems;

public interface TechNXTCustomerCartItemsService {

	public abstract void addCartItem(CustomerCartItems cartItem);
	public abstract CustomerCartItems getCartItem(String cartItemId);
	public abstract void removeCartItem(String cartItemId);
	public abstract void removeAllCartItems(String customerid);
}
