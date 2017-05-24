package hu.gaborbalazs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/endpointtest")
public class EndpointTest {

	Logger logger = Logger.getLogger(EndpointTest.class);
	
	@GET
	@Produces("text/plain")
	public Response endpointTest() {
		logger.trace(">> endpointTest()");
		logger.trace("<< endpointTest()");
		return Response.ok("This is a simple REST endpoint test message").build();
	}
}
