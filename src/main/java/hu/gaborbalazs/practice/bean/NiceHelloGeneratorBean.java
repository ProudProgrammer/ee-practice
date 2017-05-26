package hu.gaborbalazs.practice.bean;

import javax.enterprise.inject.Alternative;

@Alternative
public class NiceHelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "Hello darling :)";
	}

}
