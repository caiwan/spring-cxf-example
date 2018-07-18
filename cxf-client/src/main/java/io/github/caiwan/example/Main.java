package io.github.caiwan.example;


import io.github.caiwan.example.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.springframework.context.annotation.*;
import org.springframework.core.env.MapPropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(value = ApplicationConfig.class)
@PropertySource("classpath:/application.properties")
@Slf4j
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Cli cli = new Cli();
        CommandLine cmd = cli.build(args);

        if (cmd.hasOption(Cli.CLI_HELP)) {
            cli.printHelp();
            return;
        }

        // Get ids and store as env. vars for the Spring context
        Map<String, Object> myMap = new HashMap<>();
        myMap.put(PropertyKeys.REQUEST_NAME_KEY, cmd.getOptionValue(Cli.CLI_HELLO_NAME));
        myMap.put(PropertyKeys.WEBSERVICE_URL_KEY, cmd.getOptionValue(Cli.CLI_WEBSERVICE_URL));

        printBanner();

        // Initialize spring context
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().getPropertySources().addFirst(new MapPropertySource("MY_PROPS", myMap));
        ctx.register(Main.class);

        ctx.refresh();

        Application app = ctx.getBean(Application.class);
        app.execute();
    }

    private static void printBanner() {
        InputStream in = Main.class.getResourceAsStream("/banner.txt");
        try {
            if (in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while (reader.ready()) {
                    log.info(reader.readLine());
                }
            }
        } catch (IOException e) {

        }
    }

    @SuppressWarnings("unused")
    @Bean
    public Application application() {
        return new Application();
    }

}
