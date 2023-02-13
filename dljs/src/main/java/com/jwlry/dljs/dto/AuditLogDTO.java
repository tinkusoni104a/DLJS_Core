package com.jwlry.dljs.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditLogDTO {

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
