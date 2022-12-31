package com.jwlry.dljs.constants;

import lombok.Getter;

public enum ResponseStatusCode {
	SUCCESS(1), FAILED(0);

	@Getter
	private int status;

	ResponseStatusCode(int status) {
		this.status = status;
	}

}
