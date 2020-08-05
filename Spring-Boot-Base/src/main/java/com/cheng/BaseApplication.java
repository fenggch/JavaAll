package com.cheng;

import com.cheng.config.MyselfConfig;
import com.cheng.config.MyselfYmlConfig;
import com.cheng.config.ProjectProperties;
import com.cheng.config.ValueConfig;
import com.cheng.log.Log;
import com.cheng.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-14
 */

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ProjectProperties.class})
@Slf4j
public class BaseApplication {

    @Autowired
    ValueConfig valueConfig;

    @Autowired
    ProjectProperties projectProperties;

    @Autowired
    MyselfConfig myselfConfig;
  //  @Autowired
  //  MyselfYmlConfig myselfYmlConfig;

    @RequestMapping("/")
    @Log
    String index() {
        log.info("index...");
        System.out.println("valueConfig" + valueConfig.getName());
        System.out.println("projectProperties" + projectProperties.getName());
        System.out.println("MyselfConfig" + myselfConfig.getName());
        MyselfYmlConfig bean = SpringContextHolder.getBean(MyselfYmlConfig.class);
        System.out.println("MyselfConfig" + bean.getName());
        return "";
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BaseApplication.class);

     //   app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

       // SpringApplication.run(BaseApplication.class, args);

    }
}
