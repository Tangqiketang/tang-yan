package cn.tang.cloud.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * html
 * @author wm
 *
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
	
	  @RequestMapping("hello")
	    public String hello(Map<String,Object> map) {
	        map.put("msg", "Hello Thymeleaf");
	        return "hello";
	    }
}
