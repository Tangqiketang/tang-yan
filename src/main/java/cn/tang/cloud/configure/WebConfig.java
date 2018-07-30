package cn.tang.cloud.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import cn.tang.cloud.servlet.ServletTest;

@Configuration
public class WebConfig {
	
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
	
}
