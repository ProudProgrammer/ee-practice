package hu.gaborbalazs.practice.model;

import java.io.Serializable;
import java.text.MessageFormat;

public class PersonDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String name;
    
    public PersonDto() {}

    public PersonDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
    	return MessageFormat.format("[Person:[id={0}, name={1}]]", id, name);
    }
}
