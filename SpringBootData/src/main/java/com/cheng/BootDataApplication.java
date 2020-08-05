package com.cheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-22
 */
@SpringBootApplication
@EnableCaching

public class BootDataApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                new SpringApplication(BootDataApplication.class).run(args);

    }
}
