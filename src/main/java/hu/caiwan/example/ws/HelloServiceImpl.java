package hu.caiwan.example.ws;

import javax.jws.WebService;

import hu.caiwan.example.xml.HelloRequest;
import hu.caiwan.example.xml.HelloResponse;

@WebService(endpointInterface = "hu.caiwan.example.ws.HelloService")
public class HelloServiceImpl implements HelloService {

	public HelloResponse sayHello(HelloRequest person) {

		if (person == null)
			throw new RuntimeException("Name is null or empty");
		
		if (person.getName() == null || person.getName().isEmpty())
			throw new RuntimeException("Name is null or empty");

		HelloResponse response = new HelloResponse();
		response.setHelloMessage("Hello " + person.getName());
		return response;
	}
}
