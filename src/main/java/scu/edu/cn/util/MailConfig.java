package scu.edu.cn.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 黄伟
 * 邮箱读配置文件
 */

public class MailConfig {
    private static final String PROPERTIES_DEFAULT = "mail.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static String auth;
    public static String protocol;

    public static Properties properties;
    static{
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        properties = new Properties();
        try{
            InputStream inputStream = MailConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
            properties.load(inputStream);
            inputStream.close();
            //properties.setProperty("mailFrom","cuizhixiang@feitu.biz");
            host = properties.getProperty("mailHost");
            port = Integer.parseInt(properties.getProperty("mailPort"));
            userName = properties.getProperty("mailUsername");
            passWord = properties.getProperty("mailPassword");
            emailForm = properties.getProperty("mailFrom");
            timeout = properties.getProperty("mailTimeout");
            auth = properties.getProperty("mail.smtp.auth");
            protocol = properties.getProperty("mail.transport.protocol");
            personal ="新华亿小组";
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}