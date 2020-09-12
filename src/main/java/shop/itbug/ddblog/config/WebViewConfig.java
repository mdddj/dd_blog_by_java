package shop.itbug.ddblog.config;

import cn.hutool.core.lang.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebViewConfig extends WebMvcConfigurationSupport {

    @Value("${os_win.upload-folder}")
    private String uploadFolder;

    @Value("${os_win.server-path}")
    private String staticAccessPath;

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        Console.log("staticAccessPath:{},uploadFolder:{}",staticAccessPath,uploadFolder);
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
    }

}
