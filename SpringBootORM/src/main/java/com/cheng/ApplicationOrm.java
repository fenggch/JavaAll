package com.cheng;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-02
 */
@SpringBootApplication

@MapperScan("com.cheng.system.mapper")
public class ApplicationOrm {
    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("bean.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
       SpringApplication.run(ApplicationOrm.class, args);
    }
}
