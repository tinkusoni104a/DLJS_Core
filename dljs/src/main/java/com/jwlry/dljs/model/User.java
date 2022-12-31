package com.jwlry.dljs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Data
@Entity
@Table(name = "SCTB_USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	String userId;

	@Column(name = "USER_NAME")
	String userName;
	
	@Column(name = "EMAIL")
	String email;
	
	@Column(name = "ISO_CODE")
	int isoCode;
	
	@Column(name = "MOBILE_NO")
	int mobileNo;
	
	@Column(name = "PASSWORD")
	String password;
	
	@Column(name = "ROLE")
	String role;
	
	@Column(name = "RECORD_STAT")
	char recordStat;
	
	@Column(name = "AUTH_STAT")
	char authStat;
	
	@Column(name = "MOD_NO")
	int modNo;
	

	@Column(name = "MAKER_ID")
	String makerId;
	

	@Column(name = "MAKER_DT_STAMP")
	Date makerDtStamp;
	

	@Column(name = "CHECKER_ID")
	String checkerId;
	

	@Column(name = "CHECKER_DT_STAMP")
	Date checkerDtStamp;
	
	@Column(name = "ONCE_AUTH")
	char onceAuth;
	
	
}
