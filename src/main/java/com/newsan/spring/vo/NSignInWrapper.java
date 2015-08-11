package com.newsan.spring.vo;

import java.io.Serializable;

public class NSignInWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cUser;
	private String cPassword;
	private Boolean lStatus;
	private String cMessage;
	
	public NSignInWrapper() {
		super();
		this.cUser = "";
		this.cPassword = "";
		this.lStatus = false;
		this.cMessage = "";
	}

	public NSignInWrapper(String cUser, String cPassword) {
		super();
		this.cUser = cUser;
		this.cPassword = cPassword;
		this.lStatus = false;
		this.cMessage = "";
	}

	public String getcUser() {
		return cUser;
	}

	public void setcUser(String cUser) {
		this.cUser = cUser;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public Boolean getlStatus() {
		return lStatus;
	}

	public void setlStatus(Boolean lStatus) {
		this.lStatus = lStatus;
	}

	public String getcMessage() {
		return cMessage;
	}

	public void setcMessage(String cMessage) {
		this.cMessage = cMessage;
	}
	
	
}
