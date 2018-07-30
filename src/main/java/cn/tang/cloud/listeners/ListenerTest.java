package cn.tang.cloud.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 监听器
 * @author wm
 *
 */
public class ListenerTest implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 System.out.println("监听器销毁...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 System.out.println("监听器初始化...");
	}

}
