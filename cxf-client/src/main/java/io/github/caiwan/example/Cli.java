package io.github.caiwan.example;

import org.apache.commons.cli.*;

public class Cli {

    public static final String CLI_WEBSERVICE_URL = "url";
    public static final String CLI_HELP = "help";
    public static final String CLI_HELLO_NAME = "name";
    private static final String CLI_UTIL_FORMAT = "java -jar io.github.caiwan.example.client.jar -n <name> -u <webserviceUrl>";

    private Options options = new Options();

    private CommandLine cmd;

    public CommandLine build(String[] args) {

        options.addOption(
            Option.builder("h")
                .longOpt(CLI_HELP)
                .desc("Prints out this message")
                .required(false)
                .hasArg(false)
                .build()
        );


        options.addOption(
            Option.builder("u")
                .longOpt(CLI_WEBSERVICE_URL)
                .desc("Url of the webservice we want to connect" )
                .argName(CLI_WEBSERVICE_URL)
                .required(true).
                hasArg(true)
                .build()
        );

        options.addOption(
            Option.builder("n")
                .longOpt(CLI_HELLO_NAME)
                .desc("Name of the person we'd like to say hello to" )
                .argName(CLI_HELLO_NAME)
                .required(true).
                hasArg(true)
                .build()
        );

        CommandLineParser parser = new DefaultParser();

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            printHelp();
            System.out.println(e.getMessage());

            System.exit(1);
            return null;
        }

        return cmd;
    }


    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CLI_UTIL_FORMAT, options);
    }

}
