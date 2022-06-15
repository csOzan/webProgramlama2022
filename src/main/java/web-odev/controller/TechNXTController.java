package technxt.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import technxt.model.Customer;
import technxt.model.CustomerBillingAddress;
import technxt.model.CustomerCart;
import technxt.model.CustomerDetails;
import technxt.model.CustomerShippingAddress;
import technxt.model.Xmap_ps;
import technxt.service.TechNXTCustomerDetailsService;
import technxt.service.TechNXTCustomerService;
import technxt.service.TechNXTXpsService;


@Controller
public class TechNXTController {
	
	@Autowired
	private TechNXTCustomerService technxtCS;
	
	@Autowired
	private TechNXTCustomerDetailsService technxtCDS;
	
	/*@Autowired
	private TechNXTVwXmapPSService vxpss;*/
	
	@Autowired
	private TechNXTXpsService xpss;

	@RequestMapping(value={"/","/technxthomepage"})
	public String displaytechnxtHomePage(){ 
		System.out.println("displaytechnxtHomePage() - Controller ");
		
		return "technxthomepage";
	}
	
	@RequestMapping(value={"/reqlogout"})
	public String displaytechnxthomepage(HttpSession hsession)
	{
		hsession.setAttribute("customername", null);
		hsession.setAttribute("cusloginid", null);
		
		return "redirect:/technxthomepage";	
	}
	
	@RequestMapping("/reqdisplayloginsignpage")
	public String displaytechnxtLoginSignPage(Model m,@RequestParam(value ="responsecode",required=false)String msg)
	{
		System.out.println("\nmsg : " + msg);
		Customer customer = new Customer();
		CustomerDetails customerdetails = new CustomerDetails();
		m.addAttribute("message","0");
		m.addAttribute("message1","1");
		m.addAttribute("message2", "message4");
		if(msg!=null && msg=="1")
			m.addAttribute("errormsg",msg);
		else if(msg!=null)
			m.addAttribute("userid", msg);
		customer.setCustomerdetails(customerdetails);
		
		m.addAttribute("customerobject",customer);
		System.out.println("displaytechnxtLoginSignPage() - technxtController ");
		return "technxtloginsignuppage";
	}
	
	@RequestMapping(value={"/reqdisplayhomepage"})
	public String displaytechnxtHomePagereq(){
		System.out.println("displaytechnxtHomePagereq() - technxtController ");
		return "redirect:/technxthomepage";
	}
	
	@RequestMapping(value={"/reqdisplayaboutuspage"})
	public String displaytechnxtAboutUsPage()
	{
		System.out.println("displaytechnxtAboutUsPage()- technxtController");
		return "technxtaboutuspage";
	}
	
	
	@RequestMapping(value={"/reqdisplaycontactuspage"})
	public String displaytechnxtContactUsPage()
	{
		System.out.println("displaytechnxtContactUsPage()- technxtController");
		return "technxtcontactuspage";
	}
	
	@RequestMapping(value={"/reqdisplayproductspage"})
	public String reqdisplayproductspage(Model m)
	{
		
		System.out.println("reqdisplayproductspage() - Controller ");
		List<Xmap_ps> vxpslist = xpss.getBestxmapPS();
	
		m.addAttribute("vxpslist",vxpslist);
		System.out.println("reqdisplayproductspage()- technxtController");
		return "technxtproductspage";
	}
	
	@RequestMapping("/reqdisplayproductdetails")
	public String displayproductdetails(@RequestParam("xps_id")String xps_id,@RequestParam("pid")String pid,Model m)
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
		
		return "technxt-productdetails";
	}
	
	@RequestMapping(value={"/reqdisplayblogpage"})
	public String reqdisplayblogpage()
	{
		System.out.println("reqdisplayblogpage()- technxtController");
		return "technxtblogpage";
	}
	
	@RequestMapping("/reqloginvalidate") // to check which user loged in
	public String customerloginvalidation(Principal principal,HttpSession hsession,Model m)
	{
		System.out.print("technxtController - customerloginvalidation()");		
		System.out.println("\nName : " + principal.getName());		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		String userrole = authentication.getAuthorities().toString().substring(1, 10);
		System.out.println("\nRole : " + userrole); 		
		
		CustomerDetails cd = (CustomerDetails)technxtCDS.getCustomerDetailsById(principal.getName());
		
		if(userrole.equals("ROLE_ADMI"))
		{	
			m.addAttribute("cusloginid", cd.getCus_loginid());
			
			hsession.setAttribute("cusloginid",cd.getCus_loginid());
			
			return "redirect:/adminreqhomepage";	
		}
		else if(userrole.equals("ROLE_USER")){			
			Customer customer = technxtCS.getCustomerByUserId(cd.getCus_loginid());
			m.addAttribute("customername",customer.getCus_name());
			m.addAttribute("cusloginid", cd.getCus_loginid());
			m.addAttribute("cartsize",customer.getCustomercart().getCustomercartitems().size());
			 
			hsession.setAttribute("customername", customer.getCus_name());
			hsession.setAttribute("cusloginid", cd.getCus_loginid());
			hsession.setAttribute("cartsize", customer.getCustomercart().getCustomercartitems().size());
				return "redirect:/customerreqhomepage";
		}
		else {
			//m.addAttribute("message","0");
			return "redirect:/reqdisplayloginsignpage?responsecode=1";
		}
			
	}
	
	@RequestMapping(value={"/addcustomerregistertodb"})
	public String addcustomerregistertodb(@ModelAttribute("customerobject")Customer customer,Model m,RedirectAttributes ra)
	{
		System.out.println("addcustomerregistertodb()- technxtController");
		customer.setCustomerbillingaddress(new CustomerBillingAddress());
		customer.setCustomershippingaddress(new CustomerShippingAddress());
		customer.setCustomercart(new CustomerCart());
		String customerloginid = technxtCS.addCustomer(customer);
		/*m.addAttribute("message", "Signup is successfull. Your login id : " + customerloginid);*/
		ra.addFlashAttribute("Signup is successfull. Your login id : " + customerloginid, "message4");
		return "redirect:/reqdisplayloginsignpage?responsecode="+customerloginid;
	}
	
	
}
