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
import technxt.model.CustomerBillingAddress;
import technxt.model.CustomerCart;
import technxt.model.CustomerDetails;
import technxt.model.CustomerShippingAddress;
import technxt.model.Product;




@Repository
public class TechNXTCustomerDaoImpl implements TechNXTCustomerDao {
	
	@Autowired
	private SessionFactory sf;

	
	@Transactional
	private String generateCustomerid(){	
	
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from Customer");
		List<Customer> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="CUS00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_id) from Customer");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CUS0000"+id;
			else if(id<=99)
				newUid="CUS000"+id;
			else if(id<=999)
				newUid="CUS00"+id;
			else if(id<=9999)
				newUid="CUS0"+id;
			else
				newUid="CUS"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}
		return newUid;
	}
	
	@Transactional
	private String generateCustomershippingid(){	
	
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from CustomerShippingAddress");
		List<CustomerShippingAddress> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="CSA00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_shippingaddressid) from CustomerShippingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CSA0000"+id;
			else if(id<=99)
				newUid="CSA000"+id;
			else if(id<=999)
				newUid="CSA00"+id;
			else if(id<=9999)
				newUid="CSA0"+id;
			else
				newUid="CSA"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}
		return newUid;
	}
	
	@Transactional
	private String generateCustomerBillingid(){	
	
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from CustomerBillingAddress");
		List<CustomerBillingAddress> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="CBA00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_billingaddressid) from CustomerBillingAddress");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CBA0000"+id;
			else if(id<=99)
				newUid="CBA000"+id;
			else if(id<=999)
				newUid="CBA00"+id;
			else if(id<=9999)
				newUid="CBA0"+id;
			else
				newUid="CBA"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}
		return newUid;
	}
	
	@Transactional
	private String generateCustomerCartid(){	
	
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from CustomerCart");
		List<CustomerCart> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="CUC00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_cartid) from CustomerCart");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CUC0000"+id;
			else if(id<=99)
				newUid="CUC000"+id;
			else if(id<=999)
				newUid="CUC00"+id;
			else if(id<=9999)
				newUid="CUC0"+id;
			else
				newUid="CUC"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}
		return newUid;
	}
	
	@Transactional
	private String generateCustomerLoginid(){	
	
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from CustomerDetails");
		List<CustomerDetails> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="CUD00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(cus_loginid) from CustomerDetails");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="CUD0000"+id;
			else if(id<=99)
				newUid="CUD000"+id;
			else if(id<=999)
				newUid="CUD00"+id;
			else if(id<=9999)
				newUid="CUD0"+id;
			else
				newUid="CUD"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
		}
		return newUid;
	}

	@Transactional
	public String addCustomer(Customer customer) {
		System.out.println("CustomerDao -TechNXT\n");
		Session ses = sf.openSession();
		customer.setCus_id(generateCustomerid());
	/*	customer.setCustomerbillingaddress(new CustomerBillingAddress());
	    customer.setCustomershippingaddress(new CustomerShippingAddress());
	    customer.setCustomercart(new CustomerCart());*/
	    customer.getCustomerdetails().setCus_loginid(generateCustomerLoginid());
		customer.getCustomerbillingaddress().setCus_billingaddressid(generateCustomerBillingid());
		customer.getCustomershippingaddress().setCus_shippingaddressid(generateCustomershippingid());
		customer.getCustomercart().setCus_cartid(generateCustomerCartid());
		customer.getCustomerdetails().setCus_isenabled(true);
	    customer.getCustomerdetails().setCus_role("ROLE_USER");
	    Transaction tr = ses.beginTransaction();
	        
		ses.save(customer);
		tr.commit();
		ses.close();
		return customer.getCustomerdetails().getCus_loginid();
	}


	@Transactional
	public List<Customer> getAllCustomers() {
		Session ses = sf.openSession();
	/*	Query qr = ses.createQuery("from Customer");
		List<Product> productlist = qr.list();*/
		ses.close();
		return null;
	}


	public Customer getCustomerByUserId(String loginid) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Query qr = ses.createQuery("from Customer where cus_loginid=?");
		qr.setParameter(0, loginid);
		Customer cust = (Customer)qr.uniqueResult();
		tr.commit();
		ses.close();
		return cust;
	}
	

}
