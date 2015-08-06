package com.mvc.controller;

import java.awt.List;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
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
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);

	}

	@RequestMapping("/Address")
	public ModelAndView getAddress(@RequestParam String myAddress,
			@RequestParam String cityZip) {

		RestTemplate myRestTemplate = new RestTemplate();
		String url = "http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz1biibk0l3ij_88dza&address="
				+ myAddress + "&citystatezip=" + cityZip;
		int PRETTY_PRINT_INDENT_FACTOR = 4;

		// Making the REST call
		String zpid = myRestTemplate.getForObject(url, String.class);
		
		HashMap<String,String> values = new HashMap<String,String>();
		
		String jsonPrettyPrintString = null;
		JSONObject xmlJSONObj = null;
		String Latitude = null;
		String Longitude = null;

		// Convert String to JSON
		try {

			xmlJSONObj = XML.toJSONObject(zpid);
			 jsonPrettyPrintString = xmlJSONObj
					.toString(PRETTY_PRINT_INDENT_FACTOR);
			System.out.println(jsonPrettyPrintString);
			
			Latitude = xmlJSONObj.getJSONObject("SearchResults:searchresults").getJSONObject("response").getJSONObject("results").getJSONObject("result").getJSONObject("address").getString("latitude");
			Longitude = xmlJSONObj.getJSONObject("SearchResults:searchresults").getJSONObject("response").getJSONObject("results").getJSONObject("result").getJSONObject("address").getString("longitude");
			//System.out.println(" Zestimate is " + Latitude);
			
			values.put("Latitude", Latitude);
			values.put("Longitude", Longitude);
			
			
		} catch (JSONException je) {

			System.out.println("Json Exceptoin thrown" + je.toString());
		}

		return new ModelAndView("Address", "values", values);
		

	}

}
