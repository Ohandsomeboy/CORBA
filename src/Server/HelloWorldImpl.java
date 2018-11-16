package Server;
 
import HelloWorld.HelloPOA;
 
public class HelloWorldImpl extends HelloPOA{
 
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "HelloWorld," + name;
	}
 
}
