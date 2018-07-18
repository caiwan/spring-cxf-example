package io.github.caiwan.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

// This will load the corresponding sub-io.github.caiwan.example.config file upon settig a different profile

@Configuration
@ComponentScan(basePackages = {"io.github.caiwan.example.config"})
public class ApplicationConfig {

    @Configuration
    @Profile("live")
    public class LiveConfig {
    }

    // --------------------------------------------------------

    // Config for in-dev
    @Configuration
    @Profile("dev")
    @PropertySource("classpath:/application.dev.properties")
    public class DevConfig {

    }

    // io.github.caiwan.example.config intenral demo / live test
    @Configuration
    @Profile("demo")
    @PropertySource("classpath:/application.demo.properties")
    public class DemoConfig {

    }

}
