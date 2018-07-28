package cn.tang.cloud.utils.jedis;

import java.util.ResourceBundle;
/**
 * 配置工具类
 * @author wm
 */
public class ConfigUtil {
private static ResourceBundle res = ResourceBundle.getBundle("config/config");

	
	//redis配置信息
	public static final String jedisHost = res.getString("jedisHost");
	public static final Integer jedisPort = Integer.valueOf(res.getString("jedisPort"));
	public static final String jedisAuth = res.getString("jedisAuth");
	public static final Integer database = Integer.parseInt(res.getString("jedisDatabase"));  //redis中哪个数据库
	public static final Integer timeout = Integer.parseInt(res.getString("jedisTimeout"));
	public static final String password = res.getString("jedisPassword");
	
	

}
