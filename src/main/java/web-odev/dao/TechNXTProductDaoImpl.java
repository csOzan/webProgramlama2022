package technxt.dao;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import technxt.model.Product;

@Repository
public class TechNXTProductDaoImpl implements TechNXTProductDao {

	@Autowired
	public SessionFactory sf;
	
	@Transactional
	public void addProduct(Product product) {
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		product.setProduct_id(generateProductId());
		ses.save(product);
		saveProductImage(product);
		tr.commit();
		ses.close();
	}
	
	@Transactional
	public List<Product> getAllProducts() {
		Session ses = sf.openSession();
		Query qr = ses.createQuery("from Product");
		List<Product> productlist = qr.list();
		ses.close();
		return productlist;
	}

	@Transactional
	public void deleteProduct(String product_id) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Product product = ses.get(Product.class, product_id);
		ses.delete(product);
		deleteProductImage(product);
		tr.commit();
		ses.close();
		
	}
	
	@Transactional
	public void updateProduct(Product product) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(product);
		updateProductImage(product);
		tr.commit();
		ses.close();	
		
	}
	
	@Transactional
	public Product getProductById(String product_id) {
		Session ses = sf.openSession();
		Product temp = ses.get(Product.class, product_id);
		ses.close();		
		return temp;
	}
	
	@Transactional
	private String generateProductId(){
		
		String newPid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from Product");
		List<Product> data = qr.list();
		s.close();
		if(data.size()==0){
			newPid="PRD00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(product_id) from Product");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newPid="PRD0000"+id;
			else if(id<=99)
				newPid="PRD000"+id;
			else if(id<=999)
				newPid="PRD00"+id;
			else if(id<=9999)
				newPid="PRD0"+id;
			else
				newPid="PRD"+id;		
			System.out.print("\nGenerated : "+newPid);		
			ss.close();		
		}
			return newPid;
	}

	@Transactional
	private void saveProductImage(Product product)
	{
		System.out.println("Product Image - "+ product.getProduct_image());
			try{
				if(product.getProduct_image()!= null)
				{
					Path path=Paths.get("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//products//"+ product.getProduct_id()+".png");
					product.getProduct_image().transferTo(new File(path.toString()));
					System.out.println("Product Image Saved !!!");
				}
			}
			catch(Exception e)
			{
				System.out.println("Failed to Save image !!");
			}
	}
	@Transactional
	private void deleteProductImage(Product product)
	{
		 try { 
	         File file = new File("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//products//"+ product.getProduct_id()+".png");
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
	private void updateProductImage(Product product)
	{
		
	         File file = new File("C://Users//Ayush//Desktop//NiiT-Spring MVC//workspace//TechNXT//src//main//webapp//resources//images//products//"+ product.getProduct_id()+".png");
	         System.out.println(file.exists());
	         if(!file.exists()) { 
	        	 saveProductImage(product);
	         } else {
	        	 deleteProductImage(product);
	        	 saveProductImage(product);
	    		}
	      
	}
	

}


