package hu.gaborbalazs.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.bean.DependentBean;
import hu.gaborbalazs.practice.bean.IHelloGeneratorBean;
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
@WebServlet("/ScopeTestServlet1")
public class ScopeTestServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Inject
	private Logger logger;
	
	@Inject
	private TestEJB testEjb;
	
	@Inject
	private TestEJB2 testEjb2;
	
	@Inject
	private ApplicationScopedEJB applicationScopedEjb;
	
	@Inject
	private SessionScopedEJB sessionScopedEjb;
	
	@Inject
	private RequestScopedEJB requestScopedEjb;
	
	@Inject
	private DependentBean dependentBean;
	
	@Inject
	private MyBean2 myBean2;
	
	@Inject
	private IHelloGeneratorBean helloGeneratorBean;
	
	@Inject
	private String message;
	
    public ScopeTestServlet1() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info(">> processRequest(request, response)");
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	applicationScopedEjb.increaseValue();
    	sessionScopedEjb.increaseValue();
    	requestScopedEjb.increaseValue();
    	dependentBean.increaseValue();
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>TestServlet2</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h2>Hello. I am TestServlet2</h2>");
    	out.println("<div>");
    	out.println("Welcome message: " + testEjb.getWelcome() + "<br />");
    	out.println("Welcome message 2: " + testEjb2.getWelcome() + "<br />");
    	out.println("Injected welcome message: " + message + "<br />");
    	out.println("AtomicInt addAndGetInt(5): " + myBean2.addAndGetInt(5) + "<br />");
    	out.println("Application scoped value: " + applicationScopedEjb.getValue() + "<br />");
    	out.println("Session scoped value: " + sessionScopedEjb.getValue() + "<br />");
    	out.println("Request scoped value: " + requestScopedEjb.getValue() + "<br />");
    	out.println("Dependent scoped value: " + dependentBean.getValue() + "<br />");
    	out.println("HelloGenerator message: " + helloGeneratorBean.getHello());
    	out.println("</div>");
    	out.println("</body>");
    	out.println("</html>");
    	out.close();
    	
    	logger.info("<< processRequest(request, response)");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
