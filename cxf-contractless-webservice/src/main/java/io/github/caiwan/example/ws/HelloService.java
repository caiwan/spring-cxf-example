package io.github.caiwan.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import io.github.caiwan.example.dto.HelloRequest;
import io.github.caiwan.example.dto.HelloResponse;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloService {

    @WebMethod HelloResponse sayHello(HelloRequest person);
}
