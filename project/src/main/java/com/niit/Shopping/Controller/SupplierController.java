package com.niit.Shopping.Controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.niit.shoppingbackendDAO.SupplierDAO;
import com.niit.shoppingbackendmodel.Supplier;
@Controller
public class SupplierController
{
@Autowired
SupplierDAO sd;
@RequestMapping("addsupplier")
public ModelAndView display7()
{
	ModelAndView s=new ModelAndView("addsupplier");
	return s;
		
}
@ModelAttribute("Supplier")
public Supplier addsupplier(){
	return new Supplier();
}
@RequestMapping("storesupplier")
public String addsupplier(HttpServletRequest request,@Valid @ModelAttribute("Supplier")Supplier supplier,BindingResult result)
       {
 System.out.println("values are successfully inserted");
     	if(result.hasErrors())
    	{
    		return "addsupplier";
    	}
     sd.saveOrUpdate(supplier);
    	return "displaysupplier";
}
@RequestMapping("/displaysupplier")
public ModelAndView displaysupplier()
{  
	ModelAndView s1=new ModelAndView("displaysupplier");
	return s1;
} 

@RequestMapping("/editsupplier")
public ModelAndView edit2()
{  
	ModelAndView s2=new ModelAndView("editsupplier");
	return s2;
} 
@RequestMapping(value="/list2",method=RequestMethod.GET,produces="application/json")
public @ResponseBody String showList2(){
	List<Supplier> list=sd.list();
	Gson s=new Gson();
	String json=s.toJson(list);
	return json;
}
@RequestMapping(value="viewsupplier",method=RequestMethod.GET)
public ModelAndView viewsupplier(@RequestParam int id, @ModelAttribute Supplier suppliers){
	Supplier supplier=sd.get(id);
	return new ModelAndView("viewsupplier","Supplier",supplier);
}
@RequestMapping("/deletesupplier")
public ModelAndView deleteSupplier(@RequestParam int id)
{
 System.out.println("hello welcome to niit");
    sd.delete(id);
	ModelAndView s4=new ModelAndView("displaysupplier");
	return s4;
}
@RequestMapping(value="/updatesupplier",method=RequestMethod.POST)
public ModelAndView updateCategory(HttpServletRequest request,@Valid @ModelAttribute("Supplier")Supplier supplier,BindingResult result)
{
	sd.saveOrUpdate(supplier);
	return new ModelAndView("displaysupplier");
}
@RequestMapping(value="editsupplier", method=RequestMethod.GET)
public ModelAndView editsupplier( @RequestParam int id){
 System.out.println("hello .....................................");	
 Supplier sc=sd.get(id);
 System.out.println("hiii............");
 System.out.println("editsupplier"+sc.getName());
	return new ModelAndView("editsupplier","Supplier",sc);
}
}

