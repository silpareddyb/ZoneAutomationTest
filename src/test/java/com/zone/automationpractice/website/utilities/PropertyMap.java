package com.zone.automationpractice.website.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by silpaketireddy on 24/07/2019.
 */
public class PropertyMap {
    private static Properties properties;
    private static boolean loaded =false;
    private static Pattern pattern =  Pattern.compile("(\\$\\{)([a-z.\\-A-Z0-9_]*)(\\})");
    private static final Logger LOG = LoggerFactory.getLogger(PropertyMap.class);

    public static boolean load() throws IOException {
        InputStream stream = PropertyMap.class.getClass().getResourceAsStream("/config.properties");
        properties = new Properties();
        properties.load(stream);
        updateProp();
        return true;
    }

    private static void updateProp(){

        for(String propName : properties.stringPropertyNames()) {
            String propValue =  properties.getProperty(propName);
            Matcher matcher = pattern.matcher(propValue);
            while (matcher.find()) {
                if(!propName.equalsIgnoreCase(matcher.group(2))) {
                    if (properties.getProperty(matcher.group(2)) != null) {
                        propValue = propValue.replace(matcher.group(0), properties.getProperty(matcher.group(2)));
                    }
                    else {
                        propValue = propValue.replace(matcher.group(0), matcher.group(2));
                    }
                    matcher = pattern.matcher(propValue);
                }else{
                    propValue = "";
                }
            }
            properties.setProperty(propName,propValue);
        }
    }

    public static String getProperty(String propertyName){
        if(!loaded){
            try{
                loaded = load();
            }catch(IOException ex){
                LOG.error(ex.getMessage(),ex);
            }
        }
        String property = properties.getProperty(propertyName);

        return property;
    }
}

