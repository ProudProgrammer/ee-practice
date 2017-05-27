package hu.gaborbalazs.practice.bean;

import javax.enterprise.inject.Alternative;

@Alternative
public class AlternativeHelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "Hello Alternative World";
	}

}
