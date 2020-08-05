package com.cheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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
        SpringApplication.run(ApplicationOrm.class, args);
    }
}
