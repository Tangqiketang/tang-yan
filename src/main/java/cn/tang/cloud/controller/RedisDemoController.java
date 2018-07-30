package cn.tang.cloud.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tang.cloud.resp.RspBean;
import cn.tang.cloud.utils.jedis.JedisPoolUtils;
/**
 * 用户测试jedis是否正确运行
 * @author wm
 *
 */
@Controller
public class RedisDemoController {

	@RequestMapping(value="/aehy/redis/demo", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public @ResponseBody RspBean demo(@RequestBody String req){
		RspBean rsp = new RspBean();
		rsp.setCode(200);
		
		JedisPoolUtils.set("device_","yoyo123");
		
		return rsp;
	}
	
	//test
	public static void main(String[] args) {
		JedisPoolUtils.set("test_timeaa",String.valueOf(System.currentTimeMillis()));
		
		System.out.println(JedisPoolUtils.get("test_timeaa"));
		
		//JedisPoolUtils.del("test_time");
		
	}
	
}
