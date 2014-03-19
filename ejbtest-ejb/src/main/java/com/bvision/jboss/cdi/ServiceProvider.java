package com.bvision.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.bvision.jboss.ejb.EJBServiceA;
import com.bvision.jboss.ejb.EJBServiceA2;
import com.bvision.jboss.ejb.EJBServiceA2Local;
import com.bvision.jboss.ejb.EJBServiceALocal;

/* 
 * Second approach for disambiguating between concrete interface impl and @Produced service instance
 */ 
public @Alternative class ServiceProvider {

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceAImpl!com.bvision.jboss.ejb.EJBServiceALocal")
	private EJBServiceALocal ejbServiceA;

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceA2Impl!com.bvision.jboss.ejb.EJBServiceA2Local")
	private EJBServiceA2Local ejbServiceA2;

	@Produces
	@Default
	public EJBServiceA getEJBServiceA() {
		return ejbServiceA;
	}

	@Produces
	@Default
	public EJBServiceA2 getEJBServiceA2() {
		return ejbServiceA2;
	}
}
