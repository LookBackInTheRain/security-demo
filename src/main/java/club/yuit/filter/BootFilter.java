package club.yuit.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/12/4 14:21
 **/
@Slf4j
public class BootFilter implements Filter {

    private WebApplicationContext webApplicationContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("BootFilter init()");
      this.webApplicationContext = findWebApplicationContext(filterConfig.getServletContext());

      for ( String item:this.webApplicationContext.getBeanDefinitionNames()){
          System.out.println(item);
      }

    }



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("BootFilter doFilter()");
        chain.doFilter(request,response);
    }


    protected WebApplicationContext findWebApplicationContext(ServletContext context) {
        if (this.webApplicationContext != null) {
            // The user has injected a context at construction time -> use it...
            if (this.webApplicationContext instanceof ConfigurableApplicationContext) {
                ConfigurableApplicationContext cac = (ConfigurableApplicationContext) this.webApplicationContext;
                if (!cac.isActive()) {
                    // The context has not yet been refreshed -> do so before returning it...
                    cac.refresh();
                }
            }
            return this.webApplicationContext;
        }

        return WebApplicationContextUtils.findWebApplicationContext(context);
    }

}
