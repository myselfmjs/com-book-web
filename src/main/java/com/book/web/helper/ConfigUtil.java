package com.book.web.helper;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by majunsheng on 2017/4/10.
 */
public class ConfigUtil {
    private static Properties properties = new Properties();

    static {
        String env = ConfigUtil.getProfilesActivie();
        Resource r = new DefaultResourceLoader().getResource("downLoad.properties");
        try {
            properties.load(r.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProfilesActivie() {
        String env = System.getProperty("spring.profiles.active");
        if (env == null) {
            env = System.getenv("spring.profiles.active");
        }
        return env;
    }


    public static String getConfig(String key) {
        return properties.getProperty(key);
    }
}
