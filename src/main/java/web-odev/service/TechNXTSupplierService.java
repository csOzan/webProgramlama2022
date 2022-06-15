package technxt.service;

import java.util.List;

import technxt.model.Supplier;

public interface TechNXTSupplierService {

	public abstract void addSupplier(Supplier supplier);
	public abstract void deleteSupplier(String supplier_id);
	public abstract void updateSupplier(Supplier supplier);
	public abstract List<Supplier> getAllSuppliers();
	public abstract Supplier getSupplierById(String supplier_id);
}
