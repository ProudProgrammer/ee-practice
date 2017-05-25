package hu.gaborbalazs.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.gaborbalazs.practice.bean.MyBean2;
import hu.gaborbalazs.practice.ejb.ApplicationScopedEJB;
import hu.gaborbalazs.practice.ejb.RequestScopedEJB;
import hu.gaborbalazs.practice.ejb.SessionScopedEJB;
import hu.gaborbalazs.practice.ejb.TestEJB;
import hu.gaborbalazs.practice.ejb.TestEJB2;

/**
 * 
 * @author gaborb
 *
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	TestEJB testEjb;
	
	@Inject
	TestEJB2 testEjb2;
	
	@Inject
	ApplicationScopedEJB applicationScopedEjb;
	
	@Inject
	SessionScopedEJB sessionScopedEjb;
	
	@Inject
	RequestScopedEJB requestScopedEjb;
	
	@Inject
	MyBean2 myBean2;
	
    public TestServlet2() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	applicationScopedEjb.increaseValue();
    	sessionScopedEjb.increaseValue();
    	requestScopedEjb.increaseValue();
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>TestServlet2</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h2>Hello. I am TestServlet2</h2>");
    	out.println("<div>");
    	out.println("Welcome message: " + testEjb.getWelcome() + "<br />");
    	out.println("Welcome message 2: " + testEjb2.getWelcome() + "<br />");
    	out.println("AtomicInt addAndGetInt(5): " + myBean2.addAndGetInt(5) + "<br />");
    	out.println("Application scoped value: " + applicationScopedEjb.getValue() + "<br />");
    	out.println("Session scoped value: " + sessionScopedEjb.getValue() + "<br />");
    	out.println("Request scoped value: " + requestScopedEjb.getValue() + "<br />");
    	out.println("</div>");
    	out.println("</body>");
    	out.println("</html>");
    	out.close();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
