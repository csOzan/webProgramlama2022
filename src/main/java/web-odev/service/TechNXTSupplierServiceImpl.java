package technxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technxt.dao.TechNXTSupplierDaoImpl;
import technxt.model.Supplier;



@Service
public class TechNXTSupplierServiceImpl implements TechNXTSupplierService {

	@Autowired
	private TechNXTSupplierDaoImpl technxtSD;
	
	public void addSupplier(Supplier supplier) {
		 technxtSD.addSupplier(supplier);
	}

	public void deleteSupplier(String supplier_id) {
		technxtSD.deleteSupplier(supplier_id);

	}

	public void updateSupplier(Supplier supplier) {
		technxtSD.updateSupplier(supplier);
	}

	public List<Supplier> getAllSuppliers() {
		return technxtSD.getAllSuppliers();
	}

	public Supplier getSupplierById(String supplier_id) {
		return technxtSD.getSupplierById(supplier_id);
	}

}
