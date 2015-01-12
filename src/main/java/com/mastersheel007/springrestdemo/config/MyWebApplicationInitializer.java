package com.mastersheel007.springrestdemo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author mastersheel007
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        
        AnnotationConfigWebApplicationContext annotationContext = new AnnotationConfigWebApplicationContext();
        annotationContext.register(ApplicationConfig.class, WebApplicationConfig.class);
        
        javax.servlet.ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(annotationContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
       
        javax.servlet.FilterRegistration.Dynamic corsFilter = sc.addFilter("corsfilter", CORSFilter.class);
        corsFilter.addMappingForUrlPatterns(null, true, "/*");
        
        sc.addListener(new ContextLoaderListener(annotationContext));
    }

}