package com.bvision.jboss.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvision.jboss.ejb.EJBServiceA;
import com.bvision.jboss.ejb.EJBServiceA2;

public class EJBBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6662070586337657515L;

	@Inject
	private EJBServiceA ejbServiceA;

	@Inject
	private EJBServiceA2 ejbServiceA2;

	public EJBBServlet() {
	}

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("[servlet] response from remote ejb A: " + ejbServiceA.greeting().getGreeting());
			System.out.println("[servlet] response from remote ejb A2: " + ejbServiceA2.greeting().getGreeting());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
