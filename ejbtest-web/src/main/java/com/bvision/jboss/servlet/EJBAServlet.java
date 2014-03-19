package com.bvision.jboss.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvision.jboss.ejb.EJBServiceB;
import com.bvision.jboss.ejb.EJBServiceB2;

public class EJBAServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6662070586337657515L;

	@Inject
	private EJBServiceB ejbServiceB;

	@Inject
	private EJBServiceB2 ejbServiceB2;

	public EJBAServlet() {
	}

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("[servlet] response from remote ejb B: " + ejbServiceB.greeting().getGreeting());
			System.out.println("[servlet] response from remote ejb B2: " + ejbServiceB2.greeting().getGreeting());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
