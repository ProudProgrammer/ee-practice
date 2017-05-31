package hu.gaborbalazs.practice.component;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

@Named
@RequestScoped
public class DataStore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	private String text = "Type here";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		logger.info(">> setText()");
		this.text = text;
		logger.info("<< setText()");
	}
}
