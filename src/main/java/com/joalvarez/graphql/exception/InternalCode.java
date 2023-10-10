package com.joalvarez.graphql.exception;

import com.joalvarez.baseframework.data.type.BaseResponseEnum;

public enum InternalCode implements BaseResponseEnum {

	OK(0, "Success operation"),
	BAD_REQUEST(2000, "Some fields contains errors. Please see the details section to detect the mistake."),
	ENTITY_NOT_FOUND(2200, "Entity not found."),
	ENTITY_ALREADY_EXISTS(2201, "Entity already exists.");

	final private int code;
	final private String message;

	InternalCode(final int code, final String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int code() {
		return this.code;
	}

	@Override
	public String message() {
		return this.message;
	}
}