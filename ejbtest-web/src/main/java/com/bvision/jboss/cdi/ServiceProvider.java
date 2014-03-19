package com.bvision.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.bvision.jboss.ejb.EJBServiceB;
import com.bvision.jboss.ejb.EJBServiceB2;

public class ServiceProvider {

	@EJB(lookup="java:global/ejbtest2/ejbtest-ejb2-1.0-SNAPSHOT/EJBServiceBImpl!com.bvision.jboss.ejb.EJBServiceBRemote")
	private EJBServiceB ejbServiceB;

	@EJB(lookup="java:global/ejbtest2/ejbtest-ejb2-1.0-SNAPSHOT/EJBServiceB2Impl!com.bvision.jboss.ejb.EJBServiceB2Remote")
	private EJBServiceB2 ejbServiceB2;

	@Produces
	@Default
	public EJBServiceB getEJBServiceB() {
		return ejbServiceB;
	}

	@Produces
	@Default
	public EJBServiceB2 getEJBServiceB2() {
		return ejbServiceB2;
	}
}
