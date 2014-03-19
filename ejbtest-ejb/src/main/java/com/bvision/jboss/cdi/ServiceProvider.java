package com.bvision.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.bvision.jboss.ejb.EJBLocalBean;
import com.bvision.jboss.ejb.EJBServiceA;
import com.bvision.jboss.ejb.EJBServiceA2;

/* @Alternative
 * Second approach for disambiguating between concrete interface impl and @Produced service instance
 */ 
public class ServiceProvider {

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceAImpl!com.bvision.jboss.ejb.EJBServiceALocal")
	private EJBServiceA ejbServiceA;

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceA2Impl!com.bvision.jboss.ejb.EJBServiceA2Local")
	private EJBServiceA2 ejbServiceA2;

	@Produces
	//First approach for disambiguating between concrete interface impl, and @Produced service instance
	@EJBLocalBean
	@Default
	public EJBServiceA getEJBServiceA() {
		return ejbServiceA;
	}

	@Produces
	//First approach for disambiguating between concrete interface impl, and @Produced service instance
	@EJBLocalBean
	@Default
	public EJBServiceA2 getEJBServiceA2() {
		return ejbServiceA2;
	}
}
