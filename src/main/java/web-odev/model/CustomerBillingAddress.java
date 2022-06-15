package technxt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerbillingaddress")
public class CustomerBillingAddress {
	
	@Id
	private String cus_billingaddressid;
	private String cus_houseno;
	private String cus_street;
	private String cus_area;
	private String cus_city;
	private String cus_state;
	private String cus_country;
	private String cus_pincode;
	
	@OneToOne(mappedBy="customerbillingaddress")
	private Customer customer;

	public String getCus_billingaddressid() {
		return cus_billingaddressid;
	}

	public void setCus_billingaddressid(String cus_billingaddressid) {
		this.cus_billingaddressid = cus_billingaddressid;
	}

	public String getCus_houseno() {
		return cus_houseno;
	}

	public void setCus_houseno(String cus_houseno) {
		this.cus_houseno = cus_houseno;
	}

	public String getCus_street() {
		return cus_street;
	}

	public void setCus_street(String cus_street) {
		this.cus_street = cus_street;
	}

	public String getCus_area() {
		return cus_area;
	}

	public void setCus_area(String cus_area) {
		this.cus_area = cus_area;
	}

	public String getCus_city() {
		return cus_city;
	}

	public void setCus_city(String cus_city) {
		this.cus_city = cus_city;
	}

	public String getCus_state() {
		return cus_state;
	}

	public void setCus_state(String cus_state) {
		this.cus_state = cus_state;
	}

	public String getCus_country() {
		return cus_country;
	}

	public void setCus_country(String cus_country) {
		this.cus_country = cus_country;
	}

	public String getCus_pincode() {
		return cus_pincode;
	}

	public void setCus_pincode(String cus_pincode) {
		this.cus_pincode = cus_pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
