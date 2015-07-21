package io.github.hergin.encryption.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecretKey {

	BigInteger k;

	BigInteger N1;

	public SecretKey() {

	}

	public SecretKey(BigInteger k, BigInteger N1) {
		this.k = k;
		this.N1 = N1;
	}

	public BigInteger getK() {
		return k;
	}

	public BigInteger getN1() {
		return N1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SECRET_KEY( k=" + k.toString() + ", N1=[" + N1.toString()
				+ "]");
		return sb.toString();
	}

	public void setK(BigInteger k) {
		this.k = k;
	}

	public void setN1(BigInteger N1) {
		this.N1 = N1;
	}

}
