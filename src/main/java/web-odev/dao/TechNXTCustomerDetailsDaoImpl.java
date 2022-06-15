package technxt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.CustomerDetails;

@Repository
public class TechNXTCustomerDetailsDaoImpl implements TechNXTCustomerDetailsDao {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public CustomerDetails getCustomerDetailsById(String cusid) {
		Session ses = sf.openSession();
		CustomerDetails cd = ses.get(CustomerDetails.class, cusid);
		ses.close();		
		return cd;
	}

	public CustomerDetails loginvalidate(CustomerDetails cusid) {
		Session ses = sf.openSession();
		Query qr = ses.createQuery("from CustomerDetails where cus_loginid=? and cus_password=? and cus_isenabled=true");
		qr.setParameter(0, cusid.getCus_loginid());
		qr.setParameter(1, cusid.getCus_password());
		// qr.list(); // return multiple records
		CustomerDetails temp = (CustomerDetails)qr.uniqueResult(); // returns one record	
		return temp;
	}

	public List<CustomerDetails> getAllCustomers() {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Query qr = ses.createQuery("from CustomerDetails where cus_loginid like 'CUD%'");
		List <CustomerDetails> customer = qr.list();
		tr.commit();
		ses.close();
		return customer;
	}
}
