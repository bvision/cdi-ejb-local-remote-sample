package com.bvision.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.bvision.jboss.ejb.EJBLocalBean;
import com.bvision.jboss.ejb.EJBServiceB;
import com.bvision.jboss.ejb.EJBServiceB2;

/* @Alternative
 * Second approach for disambiguating between concrete interface impl and @Produced service instance
 */ 
public class ServiceProvider {

	@EJB(lookup="java:global/ejbtest2/ejbtest-ejb2-1.0-SNAPSHOT/EJBServiceBImpl!com.bvision.jboss.ejb.EJBServiceBLocal")
	private EJBServiceB ejbServiceB;

	@EJB(lookup="java:global/ejbtest2/ejbtest-ejb2-1.0-SNAPSHOT/EJBServiceB2Impl!com.bvision.jboss.ejb.EJBServiceB2Local")
	private EJBServiceB2 ejbServiceB2;

	@Produces
	//First approach for disambiguating between concrete interface impl, and @Produced service instance
	@EJBLocalBean
	@Default
	public EJBServiceB getEJBServiceB() {
		return ejbServiceB;
	}

	@Produces
	//First approach for disambiguating between concrete interface impl, and @Produced service instance
	@EJBLocalBean
	@Default
	public EJBServiceB2 getEJBServiceB2() {
		return ejbServiceB2;
	}
}
