package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by majunsheng on 2017/6/30.
 * 管理资源文件的类
 *
 */
public class ConfigManagerr {

    //声明静态变量
    private static ConfigManagerr configManagerr;
    private static Properties properties;

    private ConfigManagerr(){
        //获取文件路径
        String configfile = "jdbc.properties";
        //声明新的properties对象
        properties = new Properties();

        InputStream stream = ConfigManagerr.class.getClassLoader().getResourceAsStream(configfile);

        //使用load方法读取文件
        try {
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建单例对象
    public static ConfigManagerr getintance(){
        if(configManagerr == null){
            configManagerr = new ConfigManagerr();
        }
        return configManagerr;
    }

    public String getValues(String key){
        return  properties.getProperty(key);
    }
}
