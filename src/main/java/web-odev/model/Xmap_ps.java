package technxt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="xmap_ps")
public class Xmap_ps {

	@Id
	private String xps_id;
	/*private String product_id;
	private String supplier_id;*/
	private int xps_price;
	private int xps_stock;
	private boolean xps_isenabled;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	@OneToMany(mappedBy="xmap_ps", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CustomerCartItems> customercartitems;
	
	public int getXps_price() {
		return xps_price;
	}
	public void setXps_price(int xps_price) {
		this.xps_price = xps_price;
	}
	public int getXps_stock() {
		return xps_stock;
	}
	public void setXps_stock(int xps_stock) {
		this.xps_stock = xps_stock;
	}
	public String getXps_id() {
		return xps_id;
	}
	public void setXps_id(String xps_id) {
		this.xps_id = xps_id;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public boolean isXps_isenabled() {
		return xps_isenabled;
	}
	public void setXps_isenabled(boolean xps_isenabled) {
		this.xps_isenabled = xps_isenabled;
	}
	public List<CustomerCartItems> getCustomercartitems() {
		return customercartitems;
	}
	public void setCustomercartitems(List<CustomerCartItems> customercartitems) {
		this.customercartitems = customercartitems;
	}
	
	
	
	
}
