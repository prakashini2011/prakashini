package com.niit.Shopping.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingbackendDAO.LoginDAO;
import com.niit.shoppingbackendDAO.ProductDAO;
import com.niit.shoppingbackendDAO.RegisterDAO;
import com.niit.shoppingbackendmodel.Login;
import com.niit.shoppingbackendmodel.Product;
import com.niit.shoppingbackendmodel.Register;

@Controller
public class HomeController {
	@Autowired
	ProductDAO pd;
	@Autowired
	RegisterDAO rs;
	@Autowired
	LoginDAO lg;
	

	@RequestMapping("/")
	public ModelAndView display() {
		ModelAndView m1 = new ModelAndView("home");
		return m1;
	}

	@RequestMapping("login")

	public ModelAndView display1() {
		ModelAndView m2 = new ModelAndView("login");
		return m2;
	}

	@RequestMapping("/register")
	public ModelAndView display2() {
		ModelAndView m3 = new ModelAndView("register");
		return m3;
	}

	@RequestMapping("addpizza")
	public ModelAndView display3() {
		ModelAndView m4 = new ModelAndView("addpizza");
		return m4;
	}

	@ModelAttribute("Product")
	public Product addhouse() {
		return new Product();
	}

	@RequestMapping("/home")
	public String display4() {
		return "home";
	}
		
	@RequestMapping("/storepizza")
	public String addhouse(HttpServletRequest request, @Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		System.out.println("hello niit...........................");
		if (result.hasErrors()) {
			return "addpizza";
		}
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			String path = ((HttpSession) request).getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		pd.saveOrUpdate(product);
		// return "ViewAll";
		return "added";
		

	}

		@ModelAttribute("Register")
	public Register addUser() {
		return new Register();
	}

	@RequestMapping(value = "storeuser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("Login") Login login,@Valid @ModelAttribute("Register") Register register, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			return "register";
		}

		System.out.println("hello storeUser");
		System.out.println(register.getId() + "hello @@@@@@");
		rs.saveOrUpdate(register);
		login.setId(register.getId());
		login.setStatus(register.getStatus());
		login.setName(register.getName());
		
		lg.save(login);
		return "home";
	}

	
	@RequestMapping("/retrive1")
	public ModelAndView retriveRecords()
	{   
		ModelAndView m6=new ModelAndView("retrive1");
		return m6;
	} 
	@RequestMapping("/retrive")
	public ModelAndView retriveRecords1()
	{   
		ModelAndView m7=new ModelAndView("retrive");
		return m7;
	} 
	@RequestMapping("/contactus")
	public ModelAndView display6() {
		ModelAndView m8 = new ModelAndView("contactus");
		return m8;
	}
	@RequestMapping("/about")
	public ModelAndView display7() {
		ModelAndView m9 = new ModelAndView("about");
		return m9;
	}


		
	@RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
    public @ResponseBody String showList(){
    	List list=pd.list();
    	Gson x=new Gson();
    	String json=x.toJson(list);
    	return json;
    }
	@RequestMapping(value="ViewPro",method=RequestMethod.GET)
    public ModelAndView ViewPro(@RequestParam int id, @ModelAttribute Product products){
		Product product=pd.get(id);
    	return new ModelAndView("ViewPro","Product",product);
    	//return new ModelAndView("ViewPro");
    }
	@RequestMapping("/delete")
    public ModelAndView deletehouse(@RequestParam int id)
    {
	 System.out.println("hello welcome to niit");
	    pd.deleteProduct(id);
    	ModelAndView model=new ModelAndView("retrive");
    	return model;
    }
	@RequestMapping(value="EditPro",method=RequestMethod.GET)
    public ModelAndView EditPro(@RequestParam int id){
	 System.out.println("hello niit.........................niit1............");	
	 Product product1=pd.get(id);
	 System.out.println("hello niit.........................niit2............");
	 System.out.println("eeee "+product1.getName());
    	return new ModelAndView("EditPro","Product",product1);
    }

@RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("product")Product product,BindingResult result)
    {
    	
    	String filename=product.getImg().getOriginalFilename();
    	
    	product.setImage(filename);
    	
    	try{
    		byte[] bytes=new byte[product.getImg().getInputStream().available()];
    		product.getImg().getInputStream().read(bytes);
    		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
    		MultipartFile file=product.getImg();
    		String path=((HttpSession) request).getServletContext().getRealPath("/")+"resources/images";
    		File rootPath=new File(path);
    		if(!rootPath.exists())
    			rootPath.mkdirs();
    		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
    		System.out.println("Image path :"+path);
    		OutputStream pd=new FileOutputStream(store);
    		pd.write(bytes);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    		        
    	pd.saveOrUpdate(product);
    	return new ModelAndView("retrive");
    }

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("hi");
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName(); // get logged in username
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);

			// session.invalidate();
			ModelAndView m1 = new ModelAndView("admin");
			return m1;
		}
		else
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String str = auth.getName(); // get logged in username
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);

			ModelAndView m2 = new ModelAndView("retrive1");
			return m2;
			
		}
		
		
		}
		

		
		

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelMap model) {
		System.out.println("hello HONEY...........................................");

		return new ModelAndView("login", "error", true);

	}
	@RequestMapping("logoutsuccess")
	public ModelAndView logoutpage(){
		ModelAndView mv9 = new ModelAndView("logoutsuccess");
		return mv9;
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		HttpSession newsession = request.getSession(false);
		if (newsession != null) 
	    {
	         newsession.invalidate();

	    }
		response.sendRedirect("j_spring_security_logout");	
		}
	
	
}


	



	
	

