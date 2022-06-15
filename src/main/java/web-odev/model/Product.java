package technxt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
public class Product {

	@Id
	private String product_id;
	private String product_name;
	private String product_desc;
	private boolean product_isenabled;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Xmap_ps> xmap_ps;
	
	@Transient
	private MultipartFile product_image;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public boolean isProduct_isenabled() {
		return product_isenabled;
	}

	public void setProduct_isenabled(boolean product_isenabled) {
		this.product_isenabled = product_isenabled;
	}

	public MultipartFile getProduct_image() {
		return product_image;
	}

	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}

	public List<Xmap_ps> getXmap_ps() {
		return xmap_ps;
	}

	public void setXmap_ps(List<Xmap_ps> xmap_ps) {
		this.xmap_ps = xmap_ps;
	}

	
	
}


