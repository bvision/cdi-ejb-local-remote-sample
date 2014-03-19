package com.bvision.jboss.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * This EJB is exposed remotely and locally.
 * 
 * It is remotely looked up from ejbtest-web2 ServiceProvider to be available for @Injection in ejbtest-web2 web servlet.
 * 
 * @author matias.blasi@bvision.com
 */
@Stateless
@Remote(EJBServiceARemote.class)
@Local(EJBServiceALocal.class)
public class EJBServiceAImpl implements EJBServiceARemote, EJBServiceALocal {

	@Inject
	private EJBServiceA2 ejbServiceA2;

	@Override
	public EJBResponse greeting() {
		System.out.println("[nested response] from EJBServiceA.@Injected-A2: " + ejbServiceA2.greeting().getGreeting());
		return new EJBResponse("[main response] from EJB A");
	}

}
