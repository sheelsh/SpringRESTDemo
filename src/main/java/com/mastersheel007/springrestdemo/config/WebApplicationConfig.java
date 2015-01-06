package com.mastersheel007.springrestdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author mastersheel007
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mastersheel007.springrestdemo.controller")
public class WebApplicationConfig {
    
    @Bean
    public UrlBasedViewResolver setUpViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setPrefix("/");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }
}
