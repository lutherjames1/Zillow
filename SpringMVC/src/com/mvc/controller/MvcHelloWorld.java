package com.mvc.controller;


import java.awt.List;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.Address;


@Controller
public class MvcHelloWorld {

	/**
	 * @param args
	 */
	
	@RequestMapping("/welcome")
   public ModelAndView helloWorld() {
		
		System.out.println("control inside controller");
		String message =  "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome" , "message" , message);
		
		
	}
	
	
	@RequestMapping("/Address")
	public ModelAndView getAddress(@RequestParam String myAddress , @RequestParam String cityZip){
		
		System.out.println("Insode Zillow COntroller");
		
		/*myAddress.replace(" ", "+");
		cityZip.replace(" ", "+");*/
		
		RestTemplate myRestTemplate = new RestTemplate();
		String url = "http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz1biibk0l3ij_88dza&address=" + myAddress + "&citystatezip=" +cityZip ;
		
		System.out.println(" URL is " + url);
		
		String zpid = myRestTemplate.getForObject(url, String.class);
		System.out.println("zip is" + zpid);
		
		return new ModelAndView("Address" , "zpid" , zpid);
		
		
	}
	
	
	
	

}
