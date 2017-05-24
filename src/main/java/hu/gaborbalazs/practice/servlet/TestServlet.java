package hu.gaborbalazs.practice.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.gaborbalazs.practice.ejb.TestService;

/**
 * 
 * @author gaborb
 *
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	TestService testService;

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(", Hello");
		testService.saveNewEntity();
		response.getWriter().append(", List size: " + testService.getAllEntities().size());
		response.getWriter().append(", Native query list size: " + testService.nativeQueryTest());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
