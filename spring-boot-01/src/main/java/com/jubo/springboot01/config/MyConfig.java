package com.jubo.springboot01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/03/06
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    ProjectConfig projectConfig;

    /**
     * registry.addViewController("/login.html").setViewName("login");
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/null/api-docs",
            "/api-docs").setKeepQueryParams(true);
        registry.addRedirectViewController("/null/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/null/swagger-resources/configuration/security",
            "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/null/swagger-resources", "/swagger-resources");
    }

    /**
     * 会导致spring.resources.static-locations失效
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:" + projectConfig.getUploadPath());
    }

    /**
     * 此处设置LocaleResolver是为了支持多语言
     * 但是swagger的配置似乎和这个有冲突，配置SwaggerConfig后会与之冲突
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new NativeLocaleResolver();
    }

    protected static class NativeLocaleResolver implements LocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String language = request.getParameter("language");
            System.out.println("-----" + language);
            Locale locale = Locale.getDefault();
            if (!StringUtils.isEmpty(language)) {
                String[] split = language.split("_");
                locale = new Locale(split[0], split[1]);
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

        }
    }
}
