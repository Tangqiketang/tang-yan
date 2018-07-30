package cn.tang.cloud.configure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import cn.tang.cloud.filters.TimeFilter;
import cn.tang.cloud.interceptors.TimeInterceptor;
import cn.tang.cloud.listeners.ListenerTest;
import cn.tang.cloud.servlet.ServletTest;
/**
 * 继承WebMvcConfigurerAdapter，
 * @author wm
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Value("${ds.userName}")
	private String userName;
	
	@Autowired
	private Environment environment;
	
	public void show() {
        System.out.println("ds.userName:" + this.userName);//通过value注解获取
        System.out.println("ds.password:" + this.environment.getProperty("ds.password")); //通过注入environment获取
    }
	
	/**
	 * 用于json格式转换到前台
	 * @return
	 */
	 @Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
	    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
	    FastJsonConfig fastJsonConfig = new FastJsonConfig();
	    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
	    HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
	    return new HttpMessageConverters(converter);
	}
	 
	/**
	 *自定义servlet 
	 * @return
	 */
	 @Bean
	 public ServletRegistrationBean servletRegistrationBean() {
	     return new ServletRegistrationBean(new ServletTest(),"/servletTest");
	 }
	 
	 /**
	  * 自定义过滤器注册
	  */
	 @Bean
	 public FilterRegistrationBean timeFilter() {
	     FilterRegistrationBean registrationBean = new FilterRegistrationBean();

	     TimeFilter timeFilter = new TimeFilter(); //设置自定义的过滤器
	     registrationBean.setFilter(timeFilter);

	     List<String> urls = new ArrayList<>();
	     urls.add("/*");                          //设置要过滤的路径
	     registrationBean.setUrlPatterns(urls);

	     return registrationBean;
	 }
	 
	 /**
	  * 注册监听器，将自定义监听器ListenerTest设置进去
	  */
	 @Bean
	 public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
	     return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	 }
	 
	 /**
	  * 注册,拦截器WebConfig继承WebMvcConfigurerAdapter，重写注入自定义拦截器
	  */
	 @Autowired
	 private TimeInterceptor timeInterceptor;
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(timeInterceptor);
	 }
	
}
