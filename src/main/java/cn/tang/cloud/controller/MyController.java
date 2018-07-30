package cn.tang.cloud.controller;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.tang.cloud.constants.ActionConstants;
import cn.tang.cloud.resp.RspBean;
import cn.tang.cloud.utils.jedis.JedisPoolUtils;

@RestController
public class MyController {
	
	/**
	 * 实例
	 * @param action
	 * @param userToken
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/person/{action}",method=RequestMethod.POST,produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RspBean example(@PathVariable("action")String action,@RequestHeader("UserToken") String userToken,
			@RequestBody String req){
		RspBean rspBean = new RspBean();
		switch(action){
		case ActionConstants.GET_PERSON:
			break;
		default:
			throw new RuntimeException();
		}
		rspBean.setCode(200);
		return rspBean;
	}
	
	@RequestMapping(value="/person/{action}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public String example2(@PathVariable("action")String action){
		RspBean rspBean = new RspBean();
		switch(action){
		case ActionConstants.GET_PERSON:
			break;
		case ActionConstants.SET_PERSON:
			//JedisPoolUtils.set("name2", "wmwm99");
			break;
		default:
			throw new RuntimeException();
		}
		rspBean.setCode(200);
		return rspBean.toString();
	}
	
	@RequestMapping(value="/home/{action}",method=RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView home(@PathVariable("action")String action){
		ModelAndView modelAndView = new ModelAndView();
		switch(action){
		case ActionConstants.INDEX:
			modelAndView.setViewName("index.jsp");
			break;
		default:
			throw new RuntimeException();
		}
		return modelAndView;
	}
	
}
