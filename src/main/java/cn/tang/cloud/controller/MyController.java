package cn.tang.cloud.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.tang.cloud.constants.ActionConstants;
import cn.tang.cloud.resp.RspBean;

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
	public RspBean example(@PathVariable("action")String action,@RequestHeader("UserToken") String userToken,
			@RequestBody String req){
		RspBean rspBean = new RspBean();
		switch(action){
		case ActionConstants.GET_PERSON:
			
			break;
		default:
			throw new RuntimeException();
		}
		return rspBean;
	}
}
