package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTCustomerDetailsDao;
import technxt.model.CustomerDetails;

@Service
public class TechNXTCustomerDetailsServiceImpl implements TechNXTCustomerDetailsService {

	@Autowired
	private TechNXTCustomerDetailsDao technxtCDD;
	
	public CustomerDetails getCustomerDetailsById(String cusid) {
		return technxtCDD.getCustomerDetailsById(cusid);
	}

	public CustomerDetails loginvalidate(CustomerDetails cusid) {
		return technxtCDD.loginvalidate(cusid);
	}

	public List<CustomerDetails> getAllCustomers() {

		return technxtCDD.getAllCustomers();
	}

}
