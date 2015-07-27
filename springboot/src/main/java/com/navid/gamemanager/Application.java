package com.navid.gamemanager;

import com.navid.gamemanager.controller.DomainMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Bean
    DomainMapper createDomainMapper() {
        return DomainMapper.INSTANCE;
    }


    /*

    <beans:bean id="templateResolver" class="org.thymeleaf.templateresolver.ServletContextTemplateResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".html" />
        <beans:property name="templateMode" value="HTML5" />
        <beans:property name="cacheable" value="false" /> <!-- Development only -->
    </beans:bean>
     */
}