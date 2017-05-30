package hu.gaborbalazs.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.bean.ApplicationScopedBean;
import hu.gaborbalazs.practice.bean.DependentBean;
import hu.gaborbalazs.practice.bean.IHelloGeneratorBean;
import hu.gaborbalazs.practice.bean.RequestScopedBean;
import hu.gaborbalazs.practice.bean.SessionScopedBean;
import hu.gaborbalazs.practice.ejb.DBServiceEJB;
import hu.gaborbalazs.practice.ejb.StatefulApplicationScopedEJB;
import hu.gaborbalazs.practice.ejb.StatefulRequestScopedEJB;
import hu.gaborbalazs.practice.ejb.StatefulSessionScopedEJB;
import hu.gaborbalazs.practice.ejb.StatelessEJB;
import hu.gaborbalazs.practice.qualifier.Nice;
import hu.gaborbalazs.practice.qualifier.Rude;

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
	private DBServiceEJB dBServiceEJB;
	
	@Inject
	private StatefulApplicationScopedEJB statefulApplicationScopedEjb;
	
	@Inject
	private StatefulSessionScopedEJB statefulSessionScopedEjb;
	
	@Inject
	private StatefulRequestScopedEJB statefulRequestScopedEjb;
	
	@Inject
	private StatelessEJB statelessEJB;
	
	@Inject
	private ApplicationScopedBean applicationScopedBean;
	
	@Inject
	private SessionScopedBean sessionScopedBean;
	
	@Inject
	private RequestScopedBean requestScopedBean;
	
	@Inject
	private DependentBean dependentBean;
	
	@Inject
	private IHelloGeneratorBean helloGeneratorBean;
	
	@Inject @Rude
	private IHelloGeneratorBean rudeHelloGeneratorBean;
	
	@Inject @Nice
	private IHelloGeneratorBean niceHelloGeneratorBean;
	
	@Inject
	private String producedMessage;
	
	@Inject
	private double producedRandomNumber;
	
    public ScopeTestServlet1() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	logger.info(">> processRequest(request, response)");
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	dBServiceEJB.saveNewEntity();
    	
    	statefulApplicationScopedEjb.increaseValue();
    	statefulSessionScopedEjb.increaseValue();
    	statefulRequestScopedEjb.increaseValue();
    	statelessEJB.increaseValue();
    	
    	applicationScopedBean.increaseValue();
    	sessionScopedBean.increaseValue();
    	requestScopedBean.increaseValue();
    	dependentBean.increaseValue();
    	
    	out.println("<html>");
    	out.println("<head>");
    	out.println(MessageFormat.format("<title>{0}</title>", getClass().getSimpleName()));
    	out.println("</head>");
    	out.println("<body>");
    	out.println(MessageFormat.format("<h2>Hello. I am {0}</h2>", getClass().getSimpleName()));
    	out.println("<div>");
    	
    	out.println("DBService getAllEntities().size(): " + dBServiceEJB.getAllEntities().size() + "<br /></br />");
    	
    	out.println("Stateful Application scoped EJB value: " + statefulApplicationScopedEjb.getValue() + "<br />");
    	out.println("Stateful Session scoped EJB value: " + statefulSessionScopedEjb.getValue() + "<br />");
    	out.println("Stateful Request scoped EJB value: " + statefulRequestScopedEjb.getValue() + "<br />");
    	out.println("Stateless EJB value: " + statelessEJB.getValue() + "<br /><br />");
    	
    	out.println("Application scoped Bean value: " + applicationScopedBean.getValue() + "<br />");
    	out.println("Session scoped Bean value: " + sessionScopedBean.getValue() + "<br />");
    	out.println("Request scoped Bean value: " + requestScopedBean.getValue() + "<br />");
    	out.println("Dependent scoped Bean value: " + dependentBean.getValue() + "<br /></br />");
    	
    	out.println("HelloGenerator message: " + helloGeneratorBean.getHello() + "<br />");
    	out.println("RudeHelloGenerator message: " + rudeHelloGeneratorBean.getHello() + "<br />");
    	out.println("NiceHelloGenerator message: " + niceHelloGeneratorBean.getHello() + "<br /><br />");
    	
    	out.println("Injected message: " + producedMessage + "<br />");
    	out.println("Injected random number (1-1000): " + producedRandomNumber + "<br />");
    	
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
