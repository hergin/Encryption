package io.github.hergin.encryption.utils;

import java.math.BigInteger;

public class PlainTextOutOfScopeException extends Exception {

	private static final long serialVersionUID = 1L;

	BigInteger M, N1;

	public PlainTextOutOfScopeException(BigInteger M, BigInteger N1) {
		this.M = M;
		this.N1 = N1;
	}

	@Override
	public String getMessage() {
		return "Plain text " + M + " is not an element of Z(" + N1 + ")";
	}

}
