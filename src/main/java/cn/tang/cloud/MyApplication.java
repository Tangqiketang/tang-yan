package cn.tang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import cn.tang.cloud.configure.WebConfig;

@SpringBootApplication
public class MyApplication{
	
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyApplication.class);
	}*/
	
	public static void main(String[] args) {
		/*ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
		context.getBean(WebConfig.class).show();*/
		
		SpringApplication.run(MyApplication.class, args);
		//读取配置形式
		/*ConfigurableApplicationContext context = new SpringApplicationBuilder(MyApplication.class)
				.properties("spring.config.location=classpath:/config/my-config.properties").
				run(args);
		// 输出变量
		System.out.println(context.getEnvironment().getProperty("user"));*/
		
		
	}
}
