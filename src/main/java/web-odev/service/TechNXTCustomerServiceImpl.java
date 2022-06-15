package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTCustomerDao;
import technxt.model.Customer;


@Service
public class TechNXTCustomerServiceImpl implements TechNXTCustomerService {
	
	@Autowired
	private TechNXTCustomerDao technxtCD;
	
	public String addCustomer(Customer customer) {
		return technxtCD.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return technxtCD.getAllCustomers();
	}

	public Customer loginValidate(Customer customer) {
		return null;
	}

	public Customer getCustomerByUserId(String customerid) {
		return technxtCD.getCustomerByUserId(customerid);
	}

}
