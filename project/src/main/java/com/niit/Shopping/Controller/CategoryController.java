package com.niit.Shopping.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingbackendDAO.CategoryDAO;
import com.niit.shoppingbackendmodel.Category;


@Controller


public class CategoryController {
	@Autowired
	CategoryDAO cd;
	@RequestMapping("addcategory")
	public ModelAndView display7()
	{
		ModelAndView c=new ModelAndView("addcategory");
		return c;
			
	}
	@ModelAttribute("Category")
	public Category addcategory(){
		return new Category();
	}
	@RequestMapping("storecategory")
	public String addcategory(HttpServletRequest request,@Valid @ModelAttribute("Category")Category category,BindingResult result)
	       {
	 System.out.println("values are successfully inserted");
	     	if(result.hasErrors())
	    	{
	    		return "addcategory";
	    	}
	     cd.saveOrUpdate(category);
	    	return "displaycategory";
	}
	@RequestMapping("/displaycategory")
	public ModelAndView displaysupplier()
	{  
		ModelAndView c1=new ModelAndView("displaycategory");
		return c1;
	} 
	
	@RequestMapping("/editcategory")
	public ModelAndView edit3()
	{  
		ModelAndView c2=new ModelAndView("editcategory");
		return c2;
	} 
	
	@RequestMapping(value="/list3",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String showList3(){
		List<Category> list=cd.list();
		Gson s=new Gson();
		String json=s.toJson(list);
		return json;
	}
	@RequestMapping(value="viewcategory",method=RequestMethod.GET)
	public ModelAndView viewcategory(@RequestParam int id, @ModelAttribute Category category){
		Category category1=cd.get(id);
		return new ModelAndView("viewcategory","Category",category1);
	}
	@RequestMapping("/deletecategory")
	public ModelAndView deleteSupplier(@RequestParam int id)
	{
	 System.out.println("hello welcome to niit");
	    cd.delete(id);
		ModelAndView c3=new ModelAndView("displaycategory");
		return c3;
	}
	@RequestMapping(value="/updatecategory",method=RequestMethod.POST)
	public ModelAndView updateCategory(HttpServletRequest request,@Valid @ModelAttribute("Category")Category category,BindingResult result)
	{
		cd.saveOrUpdate(category);
		return new ModelAndView("displaycategory");
	}
	@RequestMapping(value="editcategory", method=RequestMethod.GET)
	public ModelAndView editcategory( @RequestParam int id){
	 System.out.println("hello .....................................");	
	 Category cs=cd.get(id);
	 System.out.println("hiii............");
	 System.out.println("editcategory"+cs.getName());
		return new ModelAndView("editcategory","Category",cs);
	}
	}





