package technxt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.Customer;
import technxt.model.CustomerCart;
import technxt.model.CustomerCartItems;

@Repository
public class TechNXTCustomerCartItemsDaoImpl implements TechNXTCustomerCartItemsDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void addCartItem(CustomerCartItems cartItem) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		cartItem.setCus_cartitemid(generateCartItemId());
		ses.save(cartItem);
		tr.commit();
		ses.close();
		
	}
	
	private String generateCartItemId(){		
		String newCid="";		
		Session s = sf.openSession();
		Query qr = s.createQuery("from CustomerCartItems");
		List<CustomerCartItems> data = qr.list();
		s.close();
		if(data.size()==0){
			newCid="CCI00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_cartitemid) from CustomerCartItems");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newCid="CCI0000"+id;
			else if(id<=99)
				newCid="CCI000"+id;
			else if(id<=999)
				newCid="CCI00"+id;
			else if(id<=9999)
				newCid="CCI0"+id;
			else
				newCid="CCI"+id;		
			System.out.print("\nGenerated : "+newCid);		
			ss.close();		
		}
			return newCid;
	}

	@Transactional
	public CustomerCartItems getCartItem(String cartItemId) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		CustomerCartItems cartitem=(CustomerCartItems)ses.get(CustomerCartItems.class, cartItemId);
		tr.commit();
		ses.close();
		return cartitem;
	}

	@Transactional
	public void removeCartItem(String cartItemId) {
		Session ses =sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.delete(cartItemId);
		tr.commit();
		ses.close();
		
	}

	public void removeAllCartItems(String customerid) {
		Session session=sf.openSession();
		Customer customer = session.get(Customer.class, customerid);
		CustomerCart cart = customer.getCustomercart();
		List<CustomerCartItems> cartItems=cart.getCustomercartitems();
		for(CustomerCartItems cartItem:cartItems)
			removeCartItem(cartItem.getCus_cartitemid());
	}


}
