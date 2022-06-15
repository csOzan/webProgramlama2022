package technxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import technxt.model.Product;
import technxt.model.Supplier;
import technxt.model.Xmap_ps;
import technxt.service.TechNXTProductServiceImpl;
import technxt.service.TechNXTSupplierServiceImpl;
import technxt.service.TechNXTXpsService;


@Controller
public class TechNXTAdminController {
	
	@Autowired
	private TechNXTProductServiceImpl technxtPS;
	
	@Autowired
	private TechNXTSupplierServiceImpl technxtSS;
	
	@Autowired
	private TechNXTXpsService technxtXS;
	
	@RequestMapping(value={"/adminreqhomepage"})
	public String displayadminhomepage(Model m)
	{
		List<Product> productslist = technxtPS.getAllProducts();
		m.addAttribute("productslist",productslist);
		List<Supplier> supplierslist = technxtSS.getAllSuppliers();
		m.addAttribute("supplierslist", supplierslist);
		return "adminhomepage";	
	}

	
	@RequestMapping(value={"/adminreqdisplayproducts"})
	public String displayadmindisplayproductspage(Model m)
	{
		List<Product> productslist = technxtPS.getAllProducts();
		m.addAttribute("productslist",productslist);
		return "admindisplayallproducts";	
	}
	
	@RequestMapping(value={"/adminreqdisplaysuppliers"})
	public String displayadmindisplaysupplierspage(Model m)
	{
		List<Supplier> supplierslist = technxtSS.getAllSuppliers();
		m.addAttribute("supplierslist", supplierslist);
		return "admindisplayallsuppliers";	
	}
	
	@RequestMapping(value={"/adminreqdisplayps"})
	public String displayadmindisplaypspage(Model m)
	{
		List<Xmap_ps> xpslist = technxtXS.getallxps();
		m.addAttribute("xpslist",xpslist);
		return "admindisplayallps";	
	}
	
	@RequestMapping(value={"/adminreqaddproduct"})
	public String displayadminaddproductpage(Model m)
	{
		m.addAttribute("productobj",new Product());
		return "adminaddproductpage";	
	}
	
	@RequestMapping(value={"/adminreqaddsupplier"})
	public String displayadminaddsupplierpage(Model m)
	{
		m.addAttribute("supplierobj",new Supplier());
		return "adminaddsupplierpage";	
	}
	
	@RequestMapping(value={"/adminreqaddps"})
	public String displayadminaddpspage(Model m)
	{
		List<Product> productslist = technxtPS.getAllProducts();
		List<Supplier> supplierslist = technxtSS.getAllSuppliers();
		Xmap_ps xpslist = new Xmap_ps();
		/*List<Xmap_ps> xpslist = technxtXS.getallxps();*/
		m.addAttribute("productslist", productslist);
		m.addAttribute("supplierslist", supplierslist);
		/*m.addAttribute("xpslist",xpslist);*/
		m.addAttribute("xpsobj",xpslist);
		
		return "adminaddpspage";	
	}
	
	
	
	@RequestMapping(value={"/adminaddproducttodb"})
	public String adminaddproducttodb(@ModelAttribute("productobj")Product product)
	{
		System.out.println("adminaddproducttodb()- technxtAdminController");
		technxtPS.addProduct(product);
		return "redirect:/adminreqdisplayproducts";
	}
	
	@RequestMapping(value={"/adminaddsuppliertodb"})
	public String adminaddsuppliertodb(@ModelAttribute("supplierobj")Supplier supplier)
	{
		System.out.println("adminaddsuppliertodb()- technxtAdminController");
		technxtSS.addSupplier(supplier);
		return "redirect:/adminreqdisplaysuppliers";
	}
	
	
	
	
	@RequestMapping(value={"/adminaddxpstodb"})
	public String adminaddxpstodb(@ModelAttribute("xpsobj")Xmap_ps xps,@RequestParam("productid")String productid, @RequestParam("supplierid")String supplierid)
	{
		System.out.println("adminaddxpstodb()- technxtAdminController");
		Product product = technxtPS.getProductById(productid);
				
		Supplier supplier = technxtSS.getSupplierById(supplierid);
		
		xps.setProduct(product);
		xps.setSupplier(supplier);
		technxtXS.addxps(xps);
		return "redirect:/adminreqdisplayps";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value={"/adminreqtodeleteproduct"})
	public String adminreqtodeleteproduct(@RequestParam("product_id") String product_id)
	{
		System.out.println("adminreqtodeleteproduct()- technxtAdminController");
		technxtPS.deleteProduct(product_id);
		return "redirect:/adminreqdisplayproducts";
	}
	@RequestMapping(value={"/adminreqtodeletesupplier"})
	public String adminreqtodeletesupplier(@RequestParam("supplier_id")String supplier_id)
	{
		System.out.println("adminreqtodeletesupplier()- technxtAdminController");
		technxtSS.deleteSupplier(supplier_id);
		return "redirect:/adminreqdisplaysuppliers";
	}
	
	@RequestMapping(value={"/adminreqtodeletexps"})
	public String adminreqtodeletexps(@RequestParam("xps_id")String xps_id)
	{
		System.out.println("adminreqtodeletexps()- technxtAdminController");
		technxtXS.deleteXPS(xps_id);
		return "redirect:/adminreqdisplayps";
	}
	
	@RequestMapping(value={"/adminreqtoeditproduct"})
	public String adminreqtoeditproduct(@RequestParam("product_id") String product_id,Model m)
	{
		System.out.println("adminreqtoeditproduct()- technxtAdminController");
		Product product=new Product();
		product = technxtPS.getProductById(product_id);
		m.addAttribute("editproduct",product);
		
		return "adminreqtoeditproduct";
	}
	@RequestMapping(value={"/admineditproducttodb"})
	public String admineditproducttodb(@ModelAttribute("editproduct")Product product,@RequestParam("product_id") String product_id)
	{ 
		System.out.println("admineditproducttodb()- technxtAdminController");
        product.setProduct_id(product_id);
        technxtPS.updateProduct(product);
        
		return "redirect:/adminreqdisplayproducts";
		
	}
	
	@RequestMapping(value={"/adminreqtoeditsupplier"})
	public String adminreqtoeditsupplier(@RequestParam("supplier_id") String supplier_id,Model m)
	{
		System.out.println("adminreqtoeditsupplier()- technxtAdminController");
		Supplier supplier= new Supplier();
		supplier = technxtSS.getSupplierById(supplier_id);
		m.addAttribute("editsupplier",supplier);
		
		return "adminreqtoeditsupplier";
	}
	@RequestMapping(value={"/admineditsuppliertodb"})
	public String admineditsuppliertodb(@ModelAttribute("editsupplier")Supplier supplier,@RequestParam("supplier_id") String supplier_id)
	{ 
		System.out.println("admineditsuppliertodb()- technxtAdminController");
        supplier.setSupplier_id(supplier_id);
        technxtSS.updateSupplier(supplier);
        
		return "redirect:/adminreqdisplaysuppliers";
		
	}
	
	@RequestMapping(value={"/adminreqtoeditxps"})
	public String adminreqtoeditxps(@RequestParam("xps_id") String xps_id,Model m)
	{
		System.out.println("adminreqtoeditxps()- technxtAdminController");
		Xmap_ps xps = new Xmap_ps();
		xps = technxtXS.getXPSbyId(xps_id);
		List<Product> productslist = technxtPS.getAllProducts();
		List<Supplier> supplierslist = technxtSS.getAllSuppliers();
		m.addAttribute("productslist", productslist);
		m.addAttribute("supplierslist", supplierslist);
		m.addAttribute("editxps",xps);
			
		return "adminreqtoeditxps";
	}
	@RequestMapping(value={"/adminreqtoeditxpstodb"})
	public String adminreqtoeditxpstodb(@ModelAttribute("editxps")Xmap_ps xps,@RequestParam("xps_id") String xps_id)
	{ 
		System.out.println("adminreqtoeditxpstodb()- technxtAdminController");
        xps.setXps_id(xps_id);
        technxtXS.updateXPS(xps);
        
		return "redirect:/adminreqdisplayps";
		
	}
	
}
