package cn.tang.cloud.resp;

public class RspBean {
	public RspBean(){
		
	}
	public RspBean(int code){
		this.code=code;
	}
	private Integer code;
	private Object result;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}

