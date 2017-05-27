package hu.gaborbalazs.practice.bean;

import hu.gaborbalazs.practice.qualifier.Nice;

@Nice
public class NiceHelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "Hello darling :)";
	}

}
