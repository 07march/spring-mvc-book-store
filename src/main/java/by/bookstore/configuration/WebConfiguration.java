package by.bookstore.configuration;

import by.bookstore.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "by.bookstore")
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CabinetInterceptor()).addPathPatterns("/cabinet");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin");
        registry.addInterceptor(new AddressInterceptor()).addPathPatterns("/address", "/address/*");
        registry.addInterceptor(new AuthorInterceptor()).addPathPatterns("/author/*", "/author");
        registry.addInterceptor(new BookInterceptor()).addPathPatterns("/book", "/book/*").excludePathPatterns("/book/findById", "/book/findAll");
        registry.addInterceptor(new CityInterceptor()).addPathPatterns("/city", "/city/*");
        registry.addInterceptor(new StoreInterceptor()).addPathPatterns("/store", "/store/*");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/*").excludePathPatterns("/user/auth", "/user/reg", "/user/findById", "/user/findByEmail");
        registry.addInterceptor(new BasketInterceptor()).addPathPatterns("/basket", "/basket/*");
        registry.addInterceptor(new OrderInterceptor()).addPathPatterns("/order", "/order/*");
}}

