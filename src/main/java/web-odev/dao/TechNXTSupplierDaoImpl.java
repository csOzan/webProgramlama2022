package technxt.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.Supplier;


@Repository
public class TechNXTSupplierDaoImpl implements TechNXTSupplierDao {
	
	@Autowired
	public SessionFactory sf;

	@Transactional
	public void addSupplier(Supplier supplier) {
		
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		supplier.setSupplier_id(generateSupplierId());
		ses.save(supplier);
		saveSupplierImage(supplier);
		tr.commit();
		ses.close();

	}
	
	@Transactional
	public void deleteSupplier(String supplier_id) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Supplier supplier = ses.get(Supplier.class, supplier_id);
		ses.delete(supplier);
		deleteSupplierImage(supplier);
		tr.commit();
		ses.close();

	}

	@Transactional
	public void updateSupplier(Supplier supplier) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(supplier);
		updateSupplierImage(supplier);
		tr.commit();
		ses.close();

	}
	@Transactional
	public Supplier getSupplierById(String supplier_id) {
		Session ses = sf.openSession();
		Supplier temp = ses.get(Supplier.class, supplier_id);
		ses.close();		
		return temp;
	}


	@Transactional
	public List<Supplier> getAllSuppliers() {
		Session  ses = sf.openSession();
		Query qr = ses.createQuery("from Supplier");
		List<Supplier> supplierlist = qr.list();
		ses.close();
		return supplierlist;
	}
	
	@Transactional
	private String generateSupplierId(){
		
	String newSid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from Supplier");
		List<Supplier> data = qr.list();
		s.close();
		if(data.size()==0){
			newSid="SUP00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(supplier_id) from Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newSid="SUP0000"+id;
			else if(id<=99)
				newSid="SUP000"+id;
			else if(id<=999)
				newSid="SUP00"+id;
			else if(id<=9999)
				newSid="SUP0"+id;
			else
				newSid="SUP"+id;		
			System.out.print("\nGenerated : "+newSid);		
			ss.close();		
		}
		return newSid;
	}

	@Transactional
	private void saveSupplierImage(Supplier supplier)
	{
		System.out.println("Supplier Image - "+ supplier.getSupplier_image());
			try{
				if(supplier.getSupplier_image()!= null)
				{
					Path path=Paths.get("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//suppliers//"+ supplier.getSupplier_id()+".png");
					supplier.getSupplier_image().transferTo(new File(path.toString()));
					System.out.println("Supplier Image Saved !!!");
				}
			}
			catch(Exception e)
			{
				System.out.println("Failed to Supplier Save image !!");
			}
	}
	@Transactional
	private void deleteSupplierImage(Supplier supplier)
	{
		 try { 
	         File file = new File("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//suppliers//"+ supplier.getSupplier_id()+".png");
	         if(file.delete()) { 
	            System.out.println(file.getName() + " is deleted!");
	         } else {
	            System.out.println("Delete operation is failed.");
	    		}
	      }
			catch(Exception e)
			{
				System.out.println("Failed to Delete image !!");
			}
	}
	@Transactional
	private void updateSupplierImage(Supplier supplier)
	{
		  
	         File file = new File("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//suppliers//"+ supplier.getSupplier_id()+".png");
	         System.out.println(file.exists());
	         if(!file.exists()) { 
	        	 saveSupplierImage(supplier);
	         } else {
	        	 deleteSupplierImage(supplier);
	        	 saveSupplierImage(supplier);
	    		}
	      
	}

}
