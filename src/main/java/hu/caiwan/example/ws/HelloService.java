package hu.caiwan.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import hu.caiwan.example.xml.HelloResponse;
import hu.caiwan.example.xml.HelloRequest;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloService {

    @WebMethod HelloResponse sayHello(HelloRequest person);
}
