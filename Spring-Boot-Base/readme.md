# 创建工程
    mvn archetype:generate -DgroupId=com.cheng -DartifactId=Spring-Boot-Base -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeCatalog=local

# 打包发布
## 
``
mvn clean complite package

跳过单元测试
-DskipTests，不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下。

-Dmaven.test.skip=true，不执行测试用例，也不编译测试用例类。

一 使用maven.test.skip，不但跳过单元测试的运行，也跳过测试代码的编译。

mvn package -Dmaven.test.skip=true 
也可以在pom.xml文件中修改

复制代码
<plugin>  
    <groupId>org.apache.maven.plugin</groupId>  
    <artifactId>maven-compiler-plugin</artifactId>  
    <version>2.1</version>  
    <configuration>  
        <skip>true</skip>  
    </configuration>  
</plugin>  
<plugin>  
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-surefire-plugin</artifactId>  
    <version>2.5</version>  
    <configuration>  
        <skip>true</skip>  
    </configuration>  
</plugin> 
复制代码
二 使用 mvn package -DskipTests 跳过单元测试，但是会继续编译；如果没时间修改单元测试的bug，或者单元测试编译错误。使用上面的，不要用这个

复制代码
<plugin>  
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-surefire-plugin</artifactId>  
    <version>2.5</version>  
    <configuration>  
        <skipTests>true</skipTests>  
    </configuration>  
</plugin> 
复制代码
默认idea的跳过测试采用的是第二种，所以仍然会编译代码，如果想不执行测试用例，也不编译测试用例类，那么必须采用第一种方式在pom中加上skip为true，这样才能跳过编译

``
##