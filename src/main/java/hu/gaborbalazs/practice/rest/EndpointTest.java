package hu.gaborbalazs.practice.rest;

import java.util.Collections;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.entity.Person;
import hu.gaborbalazs.practice.interceptor.Authenticated;

@Path("/endpointtest")
@Authenticated
public class EndpointTest {

	@Inject
	private Logger logger;

	@Inject
	private HttpServletRequest request;

	@GET
	@Produces("text/plain")
	public Response endpointTest() {
		logger.info(">> endpointTest()");
		Collections.list(request.getHeaderNames()).forEach(e -> logger.info(e));
		logger.info("<< endpointTest()");
		return Response.ok("This is a simple REST endpoint test message").build();
	}

	@GET
	@Path("person")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
		logger.info(">> getPerson()");
		Person person = new Person(1, "Bob");
		logger.info("<< getPerson()");
		return person;
	}
}
