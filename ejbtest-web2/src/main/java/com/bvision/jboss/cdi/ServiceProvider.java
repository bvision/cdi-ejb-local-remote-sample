package com.bvision.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.bvision.jboss.ejb.EJBServiceA;
import com.bvision.jboss.ejb.EJBServiceA2;

public class ServiceProvider {

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceAImpl!com.bvision.jboss.ejb.EJBServiceARemote")
	private EJBServiceA ejbServiceA;

	@EJB(lookup="java:global/ejbtest/ejbtest-ejb-1.0-SNAPSHOT/EJBServiceA2Impl!com.bvision.jboss.ejb.EJBServiceA2Remote")
	private EJBServiceA2 ejbServiceA2;

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
