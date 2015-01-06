package com.mastersheel007.springrestdemo.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author mastersheel007
 */

@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse htttpResponse = (HttpServletResponse) response;
        htttpResponse.setHeader("Access-Control-Allow-Origin", "*");
        htttpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
        //htttpResponse.setHeader("Access-Control-Max-Age", "3600");
        htttpResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Content-Type");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
    
}
