package com.laowei.test;

import com.laowei.util.PropertiesUtil;
import org.junit.Test;

import java.util.Map;
import java.util.Properties;

public class PropertiesUtilTest {

    private final String filePath = "/Users/wj/Desktop/systemParam.properties";

    @Test
    public void testGetValue(){
        String name = PropertiesUtil.getValue(filePath, "username");
        System.out.println(name);
    }

    @Test
    public void testGetProperties(){
        Properties properties = PropertiesUtil.getProperties(filePath);
        String name = properties.getProperty("username");
        System.out.println(name);
    }

    @Test
    public void testWrite(){
        PropertiesUtil.writeProperties(filePath, "age", "12");
        PropertiesUtil.getValue(filePath, "age");
    }

    @Test
    public void testGetPropertiesToMap(){
        Map<String, String> map = PropertiesUtil.getPropertiesFileToMap(filePath);

        for (String key: map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }



}
