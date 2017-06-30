package jdbc;

import com.sun.webpane.platform.ConfigManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by majunsheng on 2017/6/30.
 * 管理资源文件的类
 *
 */
public class ConfigManager {

    //声明静态变量
    private static com.sun.webpane.platform.ConfigManager configManager;
    private static Properties properties;

    private ConfigManager(){
        //获取文件路径
        String configfile = "jdbc.properties";
        //声明新的properties对象
        properties = new Properties();

        InputStream stream = com.sun.webpane.platform.ConfigManager.class.getClassLoader().getResourceAsStream(configfile);

        //使用load方法读取文件
        try {
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建单例对象
    private static com.sun.webpane.platform.ConfigManager getintance(){
        if(configManager == null){
            configManager = new com.sun.webpane.platform.ConfigManager();
        }
        return configManager;
    }

    public String getValues(String key){
        return  properties.getProperty(key);
    }
}
