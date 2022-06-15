package technxt.service;

import java.util.List;

import technxt.model.CustomerDetails;

public interface TechNXTCustomerDetailsService {

	public abstract CustomerDetails getCustomerDetailsById(String cusid);
	
	public abstract CustomerDetails loginvalidate(CustomerDetails cusid);
	public abstract List<CustomerDetails> getAllCustomers();
}
