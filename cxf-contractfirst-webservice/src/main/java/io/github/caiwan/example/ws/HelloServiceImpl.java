package io.github.caiwan.example.ws;

import io.github.caiwan.example.dto.HelloRequest;
import io.github.caiwan.example.dto.HelloResponse;
import org.springframework.stereotype.Controller;

import javax.jws.WebService;

@WebService(endpointInterface = "io.github.caiwan.io.github.caiwan.example.example.ws.HelloService")
@Controller
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
