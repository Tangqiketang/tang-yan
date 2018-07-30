package cn.tang.cloud.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ftl
 * @author wm
 *
 */
@Controller
@RequestMapping("freemarker")
public class FreeMarkerController {
	
	@RequestMapping("index")
	public String hello(Map<String,Object> map){
		map.put("msg", "hello freemarker");
		return "index";
	}
}
