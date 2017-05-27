package hu.gaborbalazs.practice.bean;

public class HelloGeneratorBean implements IHelloGeneratorBean {

	@Override
	public String getHello() {
		return "Hello World";
	}

}
