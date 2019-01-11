package com.earchive.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer status;
	private String msg;
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Long timesStamp;
	public StandardError(Integer statu, String msg, Long timesStamp) {
		super();
		this.status = statu;
		this.msg = msg;
		this.timesStamp = timesStamp;
	}
	public Integer getStatu() {
		return status;
	}
	public void setStatu(Integer statu) {
		this.status = statu;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimesStamp() {
		return timesStamp;
	}
	public void setTimesStamp(Long timesStamp) {
		this.timesStamp = timesStamp;
	}
	
	

}
