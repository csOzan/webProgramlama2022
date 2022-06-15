package technxt.service;


import java.util.List;

import technxt.model.Customer;


public interface TechNXTCustomerService {
	public abstract String addCustomer(Customer customer);
	public abstract List<Customer> getAllCustomers();
	public abstract Customer getCustomerByUserId(String customerid);

}
