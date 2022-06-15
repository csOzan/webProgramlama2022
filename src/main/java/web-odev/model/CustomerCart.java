package technxt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customercart")
public class CustomerCart {

	@Id
	private String cus_cartid;
	private double cus_cartgrandtotal;
	
	@OneToOne(mappedBy="customercart")
	private Customer customer;
	
	@OneToMany(mappedBy="customercart", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CustomerCartItems> customercartitems;

	public String getCus_cartid() {
		return cus_cartid;
	}

	public void setCus_cartid(String cus_cartid) {
		this.cus_cartid = cus_cartid;
	}

	public double getCus_cartgrandtotal() {
		return cus_cartgrandtotal;
	}

	public void setCus_cartgrandtotal(double cus_cartgrandtotal) {
		this.cus_cartgrandtotal = cus_cartgrandtotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerCartItems> getCustomercartitems() {
		return customercartitems;
	}

	public void setCustomercartitems(List<CustomerCartItems> customercartitems) {
		this.customercartitems = customercartitems;
	}

	
}
