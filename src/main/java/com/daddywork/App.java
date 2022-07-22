package com.daddywork;

import com.daddywork.config.FlyingsaucerpdfConfig;
import com.daddywork.config.FreemarkerConfig;
import com.daddywork.data.CSV;
import com.daddywork.data.DataParser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("csv/country.csv");

        DataParser csvLoader = new CSV();
        List<Map<String, String>> mapList = csvLoader.convertToList(inputStream);
        System.out.println(mapList);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("list", mapList);
        FreemarkerConfig freemarkerConfig = new FreemarkerConfig();
        String result = freemarkerConfig.resolveTemplate("table.ftl", dataMap);
        System.out.println(result);

        FlyingsaucerpdfConfig flyingsaucerpdfConfig = new FlyingsaucerpdfConfig();
        ByteArrayOutputStream byteArrayOutputStream = flyingsaucerpdfConfig.convertHTMLtoPDF(result);
        Files.write(Paths.get("/apps/result.pdf"), byteArrayOutputStream.toByteArray());
    }
}
