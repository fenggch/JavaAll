package com.cheng;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-22
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootDataApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RedisTest {
}
