package cn.tang.cloud.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
/*
 * 自定义过滤器,在WebConfig中注册；也可以用@Compoment直接注入
 */ 
public class TimeFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("=======初始化过滤器=========");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
		long start = System.currentTimeMillis();

        filterChain.doFilter(request, response);

        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("=======销毁过滤器=========");
	}

}
