package com.jwlry.dljs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwlry.dljs.dto.AuditLogDTO;

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
	private String userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ISO_CODE")
	private int isoCode;

	@Column(name = "MOBILE_NO")
	private long mobileNo;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "USER_STATUS")
	private String userStatus;
	
//	@Autowired
//	private AuditLogDTO auditLogDTO;
	
	@Column(name = "RECORD_STAT")
	private String recordStat;

	@Column(name = "AUTH_STAT")
	private char authStat;

	@Column(name = "MOD_NO")
	private int modNo;

	@Column(name = "MAKER_ID")
	private String makerId;

	@Column(name = "MAKER_DT_STAMP")
	private Date makerDtStamp;

	@Column(name = "CHECKER_ID")
	private String checkerId;

	@Column(name = "CHECKER_DT_STAMP")
	private Date checkerDtStamp;

	@Column(name = "ONCE_AUTH")
	private char onceAuth;


}
