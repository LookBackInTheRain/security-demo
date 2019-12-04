package club.yuit.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/12/4 11:01
 **/
@Slf4j
public class TestFilter extends GenericFilterBean {

    private Filter delegate;

    @Override
    protected void initFilterBean() throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("TestFilter-->doFilter()");
        chain.doFilter(request,response);
    }

}
