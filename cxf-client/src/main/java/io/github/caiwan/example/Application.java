package io.github.caiwan.example;

import io.github.caiwan.example.services.SayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Slf4j
public class Application {

    @Autowired
    private Environment env;

    @Autowired
        private SayHelloService service;

    Application() {
    }

    public void execute() {
        log.info("-----------------------------");

        String name = env.getProperty(PropertyKeys.REQUEST_NAME_KEY);

        String helloMessage = service.SayHello(name);

        log.info(helloMessage);

        log.info("-----------------------------");

    }

}
