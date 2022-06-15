package technxt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	private String cus_id;
	private String cus_name;
	private String cus_emailid;
	private String cus_mobileno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cus_loginid")
	private CustomerDetails customerdetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cus_billingaddressid")
	private CustomerBillingAddress customerbillingaddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cus_shippingaddressid")
	private CustomerShippingAddress customershippingaddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cus_cartid")
	private CustomerCart customercart;
	

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_emailid() {
		return cus_emailid;
	}

	public void setCus_emailid(String cus_emailid) {
		this.cus_emailid = cus_emailid;
	}

	public String getCus_mobileno() {
		return cus_mobileno;
	}

	public void setCus_mobileno(String cus_mobileno) {
		this.cus_mobileno = cus_mobileno;
	}

	public CustomerDetails getCustomerdetails() {
		return customerdetails;
	}

	public void setCustomerdetails(CustomerDetails customerdetails) {
		this.customerdetails = customerdetails;
	}

	public CustomerBillingAddress getCustomerbillingaddress() {
		return customerbillingaddress;
	}

	public void setCustomerbillingaddress(CustomerBillingAddress customerbillingaddress) {
		this.customerbillingaddress = customerbillingaddress;
	}

	public CustomerShippingAddress getCustomershippingaddress() {
		return customershippingaddress;
	}

	public void setCustomershippingaddress(CustomerShippingAddress customershippingaddress) {
		this.customershippingaddress = customershippingaddress;
	}

	public CustomerCart getCustomercart() {
		return customercart;
	}

	public void setCustomercart(CustomerCart customercart) {
		this.customercart = customercart;
	}
	
	
}
