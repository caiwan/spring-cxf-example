package hu.caiwan.example;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import hu.caiwan.example.xml.ServiceFault;

public class MySOAPFaultResolver extends SoapFaultMappingExceptionResolver {

	private static final QName CODE = new QName("code");
	private static final QName DESCRIPTION = new QName("description");

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		//logger.warn("Exception processed ", ex);
		if (ex instanceof RuntimeException) {
			ServiceFault serviceFault = new ServiceFault();
			serviceFault.setCode(ex.getClass().getName());
			serviceFault.setDescription(ex.getMessage());

			SoapFaultDetail detail = fault.addFaultDetail();
			
			detail.addFaultDetailElement(CODE).addText(serviceFault.getCode());
			detail.addFaultDetailElement(DESCRIPTION).addText(serviceFault.getDescription());
		}
	}

}
