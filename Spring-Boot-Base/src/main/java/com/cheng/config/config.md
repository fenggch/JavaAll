## 全局配置文件
在src/main/resources目录下，Spring Boot提供了一个名为application.properties的全局配置文件，可对一些默认配置的配置值进行修改
https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html 可配置所有官方熟悉
自定义属性可以通过 @Value("${属性名}")来加载配置文件
定义配置文件对应的Bean
@ConfigurationProperties(prefix="mrbird.blog")public class ConfigBean { private String name; private String title; // get,set略}通过注解@ConfigurationProperties(prefix="mrbird.blog")指明了属性的通用前缀，通用前缀加属性名和配置文件的属性名一一对应。除此之外还需在Spring Boot入口类加上注解@EnableConfigurationProperties({ConfigBean.class})来启用该配置：@SpringBootApplication@EnableConfigurationProperties({ConfigBean.class})public class Application {	public static void main(String[] args) { SpringApplication.run(Application.class, args); }}
属性间的引用
mrbird.blog.name=mrbird's blogmrbird.blog.title=Spring Bootmrbird.blog.wholeTitle=${mrbird.blog.name}--${mrbird.blog.title}
## 自定义配置文件
除了可以在application.properties里配置属性，我们还可以自定义一个配置文件。在src/main/resources目录下新建一个test.properties:
## 通过命令行设置属性值
java -jar xxx.jar --server.port=8081
## 使用xml配置
虽然Spring Boot并不推荐我们继续使用xml配置，但如果出现不得不使用xml配置的情况，Spring Boot允许我们在入口类里通过注解@ImportResource({"classpath:some-application.xml"})来引入xml配置文件。
## Profile配置
application-{profile}.properties