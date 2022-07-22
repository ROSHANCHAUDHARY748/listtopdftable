package com.daddywork.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerConfig {

    private final Configuration configuration;

    public FreemarkerConfig() {
        BeanConfig beanConfig = new BeanConfig();
        this.configuration = beanConfig.freeMarkerConfig();
    }

    public String resolveTemplate(String templatePath, Map<String, Object> dataMap) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter(1024);
        this.configuration.getTemplate(templatePath).process(dataMap, stringWriter);
        return stringWriter.toString();
    }
}
