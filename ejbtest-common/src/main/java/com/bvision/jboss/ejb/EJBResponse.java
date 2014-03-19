package com.bvision.jboss.ejb;

import java.io.Serializable;

public class EJBResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3143320424701045777L;

	private transient String greeting;

	public EJBResponse(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}
}
