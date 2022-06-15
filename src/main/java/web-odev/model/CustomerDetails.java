package technxt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="customerdetails")
public class CustomerDetails {

	@Id
	private String cus_loginid;
	private String cus_password;
	private boolean cus_isenabled;
	private String cus_role;
	
	@OneToOne(mappedBy="customerdetails")
	private Customer customer;

	@Transient
	private MultipartFile cus_image;

	public String getCus_loginid() {
		return cus_loginid;
	}

	public void setCus_loginid(String cus_loginid) {
		this.cus_loginid = cus_loginid;
	}

	public String getCus_password() {
		return cus_password;
	}

	public void setCus_password(String cus_password) {
		this.cus_password = cus_password;
	}

	public boolean isCus_isenabled() {
		return cus_isenabled;
	}

	public void setCus_isenabled(boolean cus_isenabled) {
		this.cus_isenabled = cus_isenabled;
	}

	public String getCus_role() {
		return cus_role;
	}

	public void setCus_role(String cus_role) {
		this.cus_role = cus_role;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MultipartFile getCus_image() {
		return cus_image;
	}

	public void setCus_image(MultipartFile cus_image) {
		this.cus_image = cus_image;
	}
	
	
}
