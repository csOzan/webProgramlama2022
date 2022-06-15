package technxt.dao;

import technxt.model.CustomerCartItems;

public interface TechNXTCustomerCartItemsDao {
	
	public abstract void addCartItem(CustomerCartItems cartItem);
	public abstract CustomerCartItems getCartItem(String cartItemId);
	public abstract void removeCartItem(String cartItemId);
	public abstract void removeAllCartItems(String customerid);

}
