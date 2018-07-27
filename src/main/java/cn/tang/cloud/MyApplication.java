package cn.tang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {
	
	public static void main(String[] args) {
		//SpringApplication.run(MyApplication.class, args);
		//读取配置形式
		ConfigurableApplicationContext context = new SpringApplicationBuilder(MyApplication.class)
				.properties("spring.config.location=classpath:/config/my-config.properties").
				run(args);
		// 输出变量
		System.out.println(context.getEnvironment().getProperty("user"));
		
		/*ConfigurableApplicationContext context = new SpringApplicationBuilder(
				MyApplication.class)
				.properties(
				"spring.config.location=classpath:/my-profiles.yml")
				.properties("spring.profiles.active=oracle").run(args);
		System.out.println(context.getEnvironment().getProperty("jdbc.driver"));*/
	}
}
