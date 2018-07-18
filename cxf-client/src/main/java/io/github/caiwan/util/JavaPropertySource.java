package io.github.caiwan.util;

import org.springframework.core.env.PropertySource;

import java.util.Properties;

public class JavaPropertySource extends PropertySource<Properties> {
    private static final String NAME = "JAVA_PROPERTY_SOURCE";
    private Properties properties;

    public JavaPropertySource(String name, Properties source) {
        super(name, source);
        properties = source;
    }

    public JavaPropertySource(Properties source) {
        super(NAME, source);
        properties = source;
    }

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

}
