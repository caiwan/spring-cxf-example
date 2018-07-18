package io.github.caiwan.example.client;


import io.github.caiwan.example.PropertyKeys;
import io.github.caiwan.example.ws.HelloService;
import io.github.caiwan.example.ws.HelloServiceImplService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Slf4j
@Component
public class HelloWebserviceClientImpl extends BaseClient implements HelloWebserviceClient {

    @Autowired
    private Environment env;

    private URL wsurl;

    @Getter
    private HelloService port;

    @SuppressWarnings("unused")
    @PostConstruct
    public void postConstruct() throws IOException {
        wsurl = new URL(env.getProperty(PropertyKeys.WEBSERVICE_URL_KEY));

        HelloServiceImplService service = new HelloServiceImplService(wsurl);

        port = service.getHelloServiceImplPort();
        buildPort(port);
    }

}
