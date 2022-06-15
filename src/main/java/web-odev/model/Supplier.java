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
@Table(name="supplier")
public class Supplier {

	@Id
	private String supplier_id;
	private String supplier_name;
	private String supplier_desc;
	private boolean supplier_isenabled;
	
	@OneToMany(mappedBy="supplier", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Xmap_ps> xmap_ps;
	
	@Transient
	private MultipartFile supplier_image;

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_desc() {
		return supplier_desc;
	}

	public void setSupplier_desc(String supplier_desc) {
		this.supplier_desc = supplier_desc;
	}

	public boolean isSupplier_isenabled() {
		return supplier_isenabled;
	}

	public void setSupplier_isenabled(boolean supplier_isenabled) {
		this.supplier_isenabled = supplier_isenabled;
	}

	public MultipartFile getSupplier_image() {
		return supplier_image;
	}

	public void setSupplier_image(MultipartFile supplier_image) {
		this.supplier_image = supplier_image;
	}

	public List<Xmap_ps> getXmap_ps() {
		return xmap_ps;
	}

	public void setXmap_ps(List<Xmap_ps> xmap_ps) {
		this.xmap_ps = xmap_ps;
	}

	
	
}
