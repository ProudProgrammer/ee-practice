package hu.gaborbalazs.practice.component;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.ejb.PersonEJB;
import hu.gaborbalazs.practice.entity.Person;
import hu.gaborbalazs.practice.model.PersonDto;

@Named
@SessionScoped
public class PersonController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	@Inject
	private PersonDto personDto;
	
	@Inject
	private PersonEJB personEJB;
	
	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	public String createPerson() {
		logger.info(MessageFormat.format(">> createPerson({0})", personDto));

		Person person = new Person();
		person.setId(personDto.getId());
		person.setName(personDto.getName());
        personEJB.createPerson(person);
        
        logger.info(MessageFormat.format("<< createPerson({0})", personDto));
		return "person.xhtml";
	}
}
