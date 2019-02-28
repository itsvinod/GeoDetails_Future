package com.geodetails.application.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseModel {
	Integer resCode;
	String resMsg ;
	String errMsg ;
	public Integer getResCode() {
		return resCode;
	}
	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
}
