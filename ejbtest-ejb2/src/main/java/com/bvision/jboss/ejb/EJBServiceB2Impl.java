package com.bvision.jboss.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * This EJB is exposed remotely and locally.
 * 
 * It is remotely looked up from ejbtest-web ServiceProvider to be available for @Injection in ejbtest-web web servlet.
 * 
 * Also, it is locally @Injected in EJBServiceBImpl. This @Injection could be resolved in two ways:
 * 1 - Using pure CDI
 *   In this case I had experienced a issue when the same service is @Injected with pure CDI, 
 *   and also lookedup and used through its @Remote interface
 * 2 - Using CDI + EJB lookup
 *   This second approach ensures we @Inject the looked up @Local EJB, but we need to desambiguate the instance that CDI
 *   has to @Inject (between the @Produced instance, and the available interface impl - both are considered @Default), 
 *   using 2 different mechanisms:
 *     - Marking the ServiceProvider class as @Alternative, and specifying it in beans.xml
 *     - Using a @Mark both in the @Producer method and in the @Injected field
 *
 * @author matias.blasi@bvision.com
 */
@Stateless
@Remote(EJBServiceB2Remote.class)
@Local(EJBServiceB2Local.class)
public class EJBServiceB2Impl implements EJBServiceB2Remote, EJBServiceB2Local {

	@Override
	public EJBResponse greeting() {
		return new EJBResponse("[main response] from EJB B2");
	}

}
