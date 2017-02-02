package com.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.beans.HotelBeans;
import com.hotel.beans.TarrifBeans;
import com.hotel.services.AdminService;

@Controller
public class HotelController {
	 @RequestMapping("/")
		public ModelAndView Index() {
			ModelAndView mv=new ModelAndView("index");
			return mv;
		}
	 
	 @RequestMapping("/home")
		public ModelAndView home() {
			ModelAndView mv=new ModelAndView("index");
			return mv;
		}
	 @RequestMapping("/book-room")
		public ModelAndView bookRoom() {
			ModelAndView mv=new ModelAndView("bookroom");
		    AdminService dd = new AdminService();
		    ArrayList<String> lst = dd.getCity();
			mv.addObject("list", lst);
			return mv;
		}
	 @RequestMapping("/lowest-priced-hotels")
		public ModelAndView lowestRateHotels() {
			ModelAndView mv=new ModelAndView("lowestratehotels");
			AdminService dd = new AdminService();
		    List lst = dd.getAllHotels();
			mv.addObject("list", lst);
			//mv.addObject("msg", "Hello Spring MVC");
			return mv;
		}
	 
	 @RequestMapping("/city")
		public ModelAndView city(@RequestParam("q") String name) {
			ModelAndView mv=new ModelAndView("bookroom");
			AdminService dd = new AdminService();
		    List hlst = dd.getCityFromHotel();
			mv.addObject("list", hlst);
			//mv.addObject("msg", "Hello Spring MVC");
			return mv;
		}
	
	 
	 @RequestMapping("/insert")
	    public ModelAndView Insert(@ModelAttribute("HotelBeans") HotelBeans hb) {
		  ModelAndView mv=new ModelAndView("bookroom");
		    //HotelBeans hb = new HotelBeans();
	  		AdminService dd = new AdminService();
	  		List lst = dd.getCity();
	  		mv.addObject("list", lst);
			int x = dd.insert(hb);
	 		if(x!=0)
	 		mv.addObject("msg", "Book Room Successfully");
	 		else
	 			mv.addObject("msg", "Not Booked Successfully");
	 	
	 		return mv;
	 	}

	 
	 @RequestMapping("/getHotelInCity")
		public ModelAndView getHotelInCity(@RequestParam("city") String city) {
	 AdminService dd = new AdminService();
			ArrayList<TarrifBeans> hotellist = dd.getHotelFromCity(city);
			String result="";
			for(TarrifBeans tb:hotellist)
		     {
		    	 result=result+"<option>"+tb.getName()+"</option>";
		     }
		return new ModelAndView("ajaxresult","result",result);
		}
}
