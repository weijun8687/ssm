package com.laowei.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 属性文件操作工具
 */
public class PropertiesUtil {

    /**
     * 根据 key 获取 value
     * @param filePath 文件路径
     * @param key
     * @return
     */
    public static String getValue(String filePath, String key){
        Properties prop = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            prop.load(inputStream);
            String value = prop.getProperty(key);
            System.out.println(key + " = " + value);
            return value;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定文件的所有内容
     * @param filepath
     * @return
     */
    public static Properties getProperties(String filepath){
        Properties properties = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
            properties.load(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 往文件中写入 properties 内容
     * @param filepath
     * @param parameterKey
     * @param parameterValue
     */
    public static void writeProperties(String filepath, String parameterKey, String parameterValue){
        Properties properties = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
            properties.load(inputStream);
            properties.setProperty(parameterKey, parameterValue);
            OutputStream outputStream = new FileOutputStream(filepath);
            properties.store(outputStream, "update '" + parameterKey + "' value");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Visit "+filepath+" for updating "+parameterKey+" value error");
        }
    }

    /**
     * 将文件中的内容转换成 map
     * @param filePath
     * @return
     */
    public static Map<String, String> getPropertiesFileToMap(String filePath){
        Properties properties = new Properties();
        Map<String, String> propMap = new HashMap<String, String>();
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(inputStream);
            Set<Object> keyset = properties.keySet();

            for (Object obj: keyset) {
                propMap.put(obj.toString(), properties.getProperty(obj.toString()).toString());
            }
            return propMap;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
