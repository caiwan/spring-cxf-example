package io.github.caiwan.example.services;

import io.github.caiwan.example.client.HelloWebserviceClient;
import io.github.caiwan.example.ws.HelloRequest;
import io.github.caiwan.example.ws.HelloResponse;
import io.github.caiwan.example.ws.HelloService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SayHelloService {
    @Autowired
    private HelloWebserviceClient client;

    public String SayHello(@NonNull String name){
        HelloService port = client.getPort();
        HelloRequest request = new HelloRequest();
        request.setName(name);
        HelloResponse response = port.sayHello(request);
        if (response == null)
            return null;
        return response.getHelloMessage();
    }

}
