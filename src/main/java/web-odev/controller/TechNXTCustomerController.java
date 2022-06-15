package technxt.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import technxt.model.Customer;
import technxt.model.CustomerCart;
import technxt.model.CustomerCartItems;
import technxt.model.Xmap_ps;
import technxt.service.TechNXTCustomerCartItemsService;
import technxt.service.TechNXTCustomerCartService;
import technxt.service.TechNXTCustomerService;
import technxt.service.TechNXTXpsService;

@Controller
public class TechNXTCustomerController {
	
	/*@Autowired
	private TechNXTVwXmapPSService vxpss;*/
	
	@Autowired
	private TechNXTCustomerService cuss;
	
	@Autowired
	private TechNXTXpsService xpss;
	
	@Autowired
	private TechNXTCustomerCartService ccss;
	
	@Autowired
	private TechNXTCustomerCartItemsService ccis;
		
	@RequestMapping(value={"/customerreqhomepage"})
	public String customerreqdisplayhomepage(Model m,HttpSession hsession)
	{
		System.out.println("customerreqdisplayhomepage() - Controller ");
		List<Xmap_ps> vxpslist = xpss.getBestxmapPS();
		
		
		m.addAttribute("vxpslist",vxpslist);
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customerhomepage";
	}
	
	@RequestMapping(value={"/customerreqproductspage"})
	public String customerreqproductspage(Model m,HttpSession hsession)
	{
		System.out.println("customerreqproductspage() - Controller ");
		List<Xmap_ps> vxpslist = xpss.getBestxmapPS();
		
		
		m.addAttribute("vxpslist",vxpslist);
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customerproductspage";
	}
	
	@RequestMapping(value={"/customerreqaboutuspage"})
	public String customerreqaboutuspage(Model m,HttpSession hsession)
	{
		System.out.println("customerreqaboutuspage() - Controller ");
		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customeraboutuspage";
	}
	
	@RequestMapping(value={"/customerreqcontactuspage"})
	public String customerreqcontactuspage(Model m,HttpSession hsession)
	{
		System.out.println("customerreqcontactuspage() - Controller ");
		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customercontactuspage";
	}
	
	@RequestMapping(value={"/customerreqblogpage"})
	public String customerreqblogpage(Model m,HttpSession hsession)
	{
		System.out.println("customerreqblogpage() - Controller ");
		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customerblogpage";
	}
	
	@RequestMapping("/customerreqdisplayproductdetails")
	public String displayproductdetails(@RequestParam("xps_id")String xps_id,@RequestParam("pid")String pid,Model m,HttpSession hsession)
	{

		List<Xmap_ps> vwxpsidlist = xpss.getProductbyXpsId(xps_id);
		List<Xmap_ps> vwpidlist = xpss.getProductbyProductId(pid);
		List<Xmap_ps> vwxpslist = xpss.getBestxmapPS();
		m.addAttribute("vwxpslist" ,vwxpslist);
		m.addAttribute("vwpidlist" ,vwpidlist);
		m.addAttribute("xps_price",vwxpsidlist.get(0).getXps_price());
		m.addAttribute("xps_id",vwxpsidlist.get(0).getXps_id());
		m.addAttribute("product_id",vwxpsidlist.get(0).getProduct().getProduct_id());
		m.addAttribute("product_name",vwxpsidlist.get(0).getProduct().getProduct_name());
		m.addAttribute("product_desc",vwxpsidlist.get(0).getProduct().getProduct_desc());

		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		return "customer-productdetails";
	}
	
	@RequestMapping("/customerreqAddItemToCart/{xps_id}")
	public String addItemToCart(@PathVariable("xps_id")String xps_id,@RequestParam("qty")int qty,Principal principal,HttpSession hsession,Model m){
	
		
		System.out.println("xps_id : "+xps_id + "  qty : " + qty);
		
		String customerid=principal.getName();
		System.out.println(customerid);
		Customer customer = cuss.getCustomerByUserId(customerid);
		CustomerCart customercart = customer.getCustomercart();
		Xmap_ps xmap_ps = xpss.getXPSbyId(xps_id);
		CustomerCartItems cartitem = new CustomerCartItems();
		
		cartitem.setCustomercart(customercart);
		cartitem.setXmap_ps(xmap_ps);
		cartitem.setCus_cartquantity(qty);	
		cartitem.setCus_cartitemwisetotal(xmap_ps.getXps_price()*qty);
		/*cartitem.setProduct_id(xmap_ps.getProduct_id());
		cartitem.setSupplier_id(xmap_ps.getSupplier_id());*/
		
		ccis.addCartItem(cartitem);
		
		Customer customer1=cuss.getCustomerByUserId(customerid);
		CustomerCart cart1=customer1.getCustomercart();
		
		int cartsize = ccss.getCartSize(cart1);
		
		List<CustomerCartItems> cartitems = cart1.getCustomercartitems();
		int sum=0;
		for(CustomerCartItems critem :cartitems){
			sum+= critem.getCus_cartitemwisetotal();
		}
		
		cart1.setCus_cartgrandtotal(sum);
		ccss.updateCart(cart1);			
		
		List<Xmap_ps> xpsdata = xpss.getBestxmapPS();
		
		m.addAttribute("xpsdata", xpsdata);
		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		m.addAttribute("cartmessage","Item added to cart successfully");
		
		hsession.setAttribute("cartsize", cartsize);
		
		System.out.println("cart size :" + cartsize);		
		
		return "redirect:/customerreqhomepage";
		

	}
	
	
	
	@RequestMapping("/customerreqdisplaycart")
	public String displayCart(HttpSession hsession,Model m){
		
		Customer cust = cuss.getCustomerByUserId(hsession.getAttribute("cusloginid").toString());
		CustomerCart cart = cust.getCustomercart();
		
		
		int cartsize = ccss.getCartSize(cart);	
		hsession.setAttribute("cartsize", cartsize);
		
		List<CustomerCartItems> cartitems = cart.getCustomercartitems();
		int sum=0;
		for(CustomerCartItems critem :cartitems){
			sum+= critem.getCus_cartitemwisetotal();
		}
		
		cart.setCus_cartgrandtotal(sum);
		ccss.updateCart(cart);	
		
		
		m.addAttribute("customername",hsession.getAttribute("customername"));
		m.addAttribute("cusloginid",hsession.getAttribute("cusloginid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		
		
		m.addAttribute("grandtotal",cart.getCus_cartgrandtotal());
		m.addAttribute("cartitems", cartitems);
		m.addAttribute("customerid",cust.getCus_id());
		
		return "customercartpage";
	}
	/*
	@RequestMapping("/customerreqdeletecartitem/{cus_cartitemid}")
	public String deleteCartItem(@PathVariable("cus_cartitemid")String cus_cartitemid,Principal principal ){
		ccis.removeCartItem(cus_cartitemid);		
		return "redirect:/customerreqdisplaycart";
	}
	
	
	@RequestMapping("/customerreqdeleteallcartitems/{customerid}")
	public String deleteAllCartItems(@PathVariable("customerid")String customerid,HttpSession hsession){
		ccis.removeAllCartItems(customerid);		
		hsession.setAttribute("cartsize", 0);
		return "redirect:/customerreqproductspage";
	}*/
	
	


}