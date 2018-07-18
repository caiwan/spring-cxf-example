package io.github.caiwan.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

// This will load the corresponding sub-io.github.caiwan.example.io.github.caiwan.example.config file upon settig a different profile

@Configuration
@ComponentScan(basePackages = { "io.github.caiwan.io.github.caiwan.example.example.mapper", "io.github.caiwan.io.github.caiwan.example.example.io.github.caiwan.example.io.github.caiwan.example.config" })
public class ApplicationConfig {
	
	@Configuration
	@Profile("dev")
	@PropertySource("classpath:/application.dev.properties")
	public class DevConfig {
	}

	@Configuration
	@Profile("live")
	@PropertySource("classpath:/application.live.properties")
	public class LiveConfig {
	}

	@Configuration
	@Profile("demo")
	@PropertySource("classpath:/application.demo.properties")
	public class DemoConfig {

	}

}
