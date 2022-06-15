

package technxt.dao;

import java.util.List;

import technxt.model.CustomerDetails;

public interface TechNXTCustomerDetailsDao {

	public abstract CustomerDetails getCustomerDetailsById(String cusid);
	public abstract CustomerDetails loginvalidate(CustomerDetails cusid);
	public abstract List<CustomerDetails> getAllCustomers();
	
}
