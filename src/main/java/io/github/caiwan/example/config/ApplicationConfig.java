package io.github.caiwan.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

// This will load the corresponding sub-config file upon settig a different profile

@Configuration
@ComponentScan(basePackages = { "io.github.caiwan.example.mapper", "io.github.caiwan.example.config" })
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
