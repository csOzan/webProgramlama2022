package technxt.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customercartitems")
public class CustomerCartItems {

	@Id
	private String cus_cartitemid;
	private int cus_cartquantity;
	private int cus_cartitemwisetotal;
	
	@ManyToOne
	@JoinColumn(name="cus_cartid")
	private CustomerCart customercart;
	
	@ManyToOne
	@JoinColumn(name="xps_id")
	private Xmap_ps xmap_ps;

	public String getCus_cartitemid() {
		return cus_cartitemid;
	}

	public void setCus_cartitemid(String cus_cartitemid) {
		this.cus_cartitemid = cus_cartitemid;
	}

	public int getCus_cartquantity() {
		return cus_cartquantity;
	}

	public void setCus_cartquantity(int cus_cartquantity) {
		this.cus_cartquantity = cus_cartquantity;
	}

	public int getCus_cartitemwisetotal() {
		return cus_cartitemwisetotal;
	}

	public void setCus_cartitemwisetotal(int cus_cartitemwisetotal) {
		this.cus_cartitemwisetotal = cus_cartitemwisetotal;
	}

	public CustomerCart getCustomercart() {
		return customercart;
	}

	public void setCustomercart(CustomerCart customercart) {
		this.customercart = customercart;
	}

	public Xmap_ps getXmap_ps() {
		return xmap_ps;
	}

	public void setXmap_ps(Xmap_ps xmap_ps) {
		this.xmap_ps = xmap_ps;
	}

	
	
}
