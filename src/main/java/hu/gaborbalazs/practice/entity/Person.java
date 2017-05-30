package hu.gaborbalazs.practice.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.text.MessageFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author gaborb
 *
 */
@Entity
public class Person {
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
	private int id;
    private String name;
    
    public Person() {}

    public Person(int id, String name) {
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
