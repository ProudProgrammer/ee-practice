package hu.gaborbalazs.practice.bean;

public class RudeHelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "You are not welcome :(";
	}

}
