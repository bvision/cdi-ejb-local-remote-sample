package com.bvision.jboss.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * This EJB is exposed remotely and locally.
 * 
 * It is remotely looked up from ejbtest-web ServiceProvider to be available for @Injection in ejbtest-web web servlet.
 * 
 * @author matias.blasi@bvision.com
 */
@Stateless
@Remote(EJBServiceBRemote.class)
@Local(EJBServiceBLocal.class)
public class EJBServiceBImpl implements EJBServiceBRemote, EJBServiceBLocal {

	@Inject
	private EJBServiceB2 ejbServiceB2;

	@Override
	public EJBResponse greeting() {
		System.out.println("[nested response] from EJBServiceB.@Injected-B2: " + ejbServiceB2.greeting().getGreeting());
		return new EJBResponse("[main response] from EJB B");
	}

}
