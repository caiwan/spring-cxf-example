package hu.caiwan.example;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.caiwan.example.ws.HelloServiceImpl;

@Configuration
public class ServiceEndpointConfiguration {

	@Bean
	public Endpoint helloServiceEndpoint() {
		return newEndpoint("/Hello", new HelloServiceImpl());
	}

	@Autowired
	SpringBus springBus;

	private Endpoint newEndpoint(String path, Object endpointObject) {
		EndpointImpl endpoint = new EndpointImpl(springBus, endpointObject);
		endpoint.publish(path);
		return endpoint;
	}

}
