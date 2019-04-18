package club.yuit.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/4/18 11:33
 */
public class BootAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}


class BootDelaGatingFilterProxy extends GenericFilterBean {

    private Filter delegate;
    private String filterName = "springSecurityFilterChain";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }


}