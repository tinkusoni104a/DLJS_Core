package com.jwlry.dljs.constants;


public enum EnumData {

	YES("Y"),
	NO("N"),
	ACTIVE("A"),
	OPENED("O"),
	CLOSED("C"),
	INACTIVE("I"),
	LOCKED("L"),
	DISABLED("D"),
	ENABLED("E"),
	DELETED("D"),
	SENT("S"),
	REJECT("R"),
	FAILED("F"),
	
	NEW("NEW"),
	UPDATE("UPDATE"),
	
//common screens	
	USER("USER"),
	ROLE("ROLE"),
	CUSTOMERPROFILE("CUSTOMERPROFILE"),
	GROUP("GROUP"),
	EMAILTEMPLATE("EMAILTEMPLATE"),
	SMSTEMPLATE("SMSTEMPLATE"),
	NOTIFICATIONCONTROL("NOTIFICATIONCONTROL"),
	
	EMAIL("EMAIL"),
	SMS("SMS"),
	RESETPASSWORD("RESETPASSWORD"),
	CUSTOMER("CUSTOMER"),
	EMAIL_BODY_KEY("{{EMAIL_BODY}}"),
	DEFAULTTEMPLATE("DEFAULTTEMPLATE"),
	
	EMAILRETRYCOUNT("EMAIL_RETRY_COUNT");
	private String status;

	public String getStatus() {
		return status;
	}

	private EnumData(String status) {
		this.status = status;
	}
	
}
