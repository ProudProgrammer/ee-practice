package hu.gaborbalazs.practice.component;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import hu.gaborbalazs.practice.entity.Person;

@Named("myBean")
public class BackedBean {

    String commandLink;
    String commandLinkLabel;
    Person[] list;
    String password;
    String inputText;
    String inputTextarea;
    boolean selectBooleanCheckbox;
    String[] selectManyCheckbox;

    @PostConstruct
    public void init() {
        list = Arrays.asList(
            new Person(1, "Penny"),
            new Person(2, "Leonard"),
            new Person(3, "Sheldon")).toArray(new Person[0]);
    }

    public String getCommandLink() {
        return commandLink;
    }

    public void setCommandLink(String commandLink) {
        this.commandLink = commandLink;
    }

    public String getCommandLinkLabel() {
        return commandLinkLabel;
    }

    public void setCommandLinkLabel(String commandLinkLabel) {
        this.commandLinkLabel = commandLinkLabel;
    }

    public void setList(Person[] list) {
        this.list = list;
    }

    public Person[] getList() {
        return list;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputTextarea() {
        return inputTextarea;
    }

    public void setInputTextarea(String inputTextarea) {
        this.inputTextarea = inputTextarea;
    }

    public boolean isSelectBooleanCheckbox() {
        return selectBooleanCheckbox;
    }

    public void setSelectBooleanCheckbox(boolean selectBooleanCheckbox) {
        this.selectBooleanCheckbox = selectBooleanCheckbox;
    }

    public String[] getSelectManyCheckbox() {
        return selectManyCheckbox;
    }

    public void setSelectManyCheckbox(String[] selectManyCheckbox) {
        this.selectManyCheckbox = selectManyCheckbox;
    }

}
