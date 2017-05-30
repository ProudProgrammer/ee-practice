package hu.gaborbalazs.practice.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

@Interceptor
@Authenticated
public class AuthenticationInterceptor {

	@Inject
	private Logger logger;
	
	@Inject
	private HttpServletRequest request;
	
	private final String USER_ID = "bob";
	
	@AroundInvoke
	private Object checkUser(InvocationContext ic) throws Exception {
		String userId = request.getHeader("userId");
		if(USER_ID.equals(userId)) {
			logger.info("User Id checked");
		} else {
			String msg = "Wrong User Id";
			logger.info(msg);
			throw new Exception(msg);
		}
		return ic.proceed();
	}
}
