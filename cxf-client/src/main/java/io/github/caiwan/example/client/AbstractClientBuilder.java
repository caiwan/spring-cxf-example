package io.github.caiwan.example.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;

public abstract class AbstractClientBuilder {

	protected void buildInterceptors(Object portType) {
		Client client = ClientProxy.getClient(portType);
		Endpoint endpoint = client.getEndpoint();	
		
		// ... 
	}
}
