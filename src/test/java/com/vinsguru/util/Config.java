package com.vinsguru.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Config {
//    LoggerFactory
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void initialize(){
        // load default properties
        properties = loadProperties();
        // check for any override
        for (String key : properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }
        // print
        log.info("Test Properties");
        log.info("------------------------");
        for (String key: properties.stringPropertyNames()){
            log.info("{}={}",key, properties.getProperty(key));
        }
        log.info("------------------------");
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try(InputStream inputStream = ResourceLoader.getResource(DEFAULT_PROPERTIES)){
            properties.load(inputStream);
        }catch (Exception e){
            log.error("unable to read properties from file {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}
