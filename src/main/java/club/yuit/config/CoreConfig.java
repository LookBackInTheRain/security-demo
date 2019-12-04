package club.yuit.config;

import club.yuit.filter.BootFilter;
import club.yuit.filter.TestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author yuit
 * @date 2019/4/17 9:28
 */
@Configuration
public class CoreConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired(required = false)
    public void tConfig(ServletContext context) {
        TestFilter filter = new TestFilter();
        FilterRegistration.Dynamic registration = context.addFilter("testFilter", filter);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.FORWARD,DispatcherType.REQUEST,DispatcherType.ASYNC);
        registration.addMappingForUrlPatterns(dispatcherTypes,false,"/*");
    }


    @Autowired
    public void bootFilter(ServletContext context){
        BootFilter filter = new BootFilter();
        FilterRegistration.Dynamic registration = context.addFilter("bootFilter", filter);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.FORWARD,DispatcherType.REQUEST,DispatcherType.ASYNC);
        registration.addMappingForUrlPatterns(dispatcherTypes,false,"/*");
    }



}
