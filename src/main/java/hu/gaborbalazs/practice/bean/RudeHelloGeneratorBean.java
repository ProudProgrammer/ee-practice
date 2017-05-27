package hu.gaborbalazs.practice.bean;

import hu.gaborbalazs.practice.qualifier.Rude;

@Rude
public class RudeHelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "You are not welcome :(";
	}

}
