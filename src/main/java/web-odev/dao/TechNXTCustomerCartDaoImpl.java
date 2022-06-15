package technxt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.CustomerCart;
import technxt.model.CustomerCartItems;

@Repository
public class TechNXTCustomerCartDaoImpl implements TechNXTCustomerCartDao {
	
	@Autowired
	private SessionFactory sf;
	
	
	@Transactional
	public CustomerCart getCart(String cartid) {
		Session ses=sf.openSession();
		CustomerCart cart=(CustomerCart)ses.get(CustomerCart.class, cartid);
		ses.close();
		return cart;
	}
	
	@Transactional
	public int getCartSize(CustomerCart cart) {
		List<CustomerCartItems> cartitems = cart.getCustomercartitems();
		return cartitems.size();
		
	}

	@Transactional
	public void updateCart(CustomerCart cart) {
		Session session=sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(cart);
		tr.commit();
		session.close();
	}

}
