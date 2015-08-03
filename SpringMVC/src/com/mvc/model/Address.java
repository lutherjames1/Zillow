package com.mvc.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "zpid")
@XmlAccessorType(XmlAccessType.FIELD)
public  class Address {
	@XmlElement(name = "zpid")
	String zpid;
	/*@XmlElement(name = "response")
	String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}*/

	public String getZpid() {
		return zpid;
	}

	public void setZpid(String mizpId) {
		this.zpid = mizpId;
	}
	

}
