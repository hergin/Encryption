package io.github.hergin.encryption.utils;

import java.math.BigInteger;

public class PrimePair {

	BigInteger q;
	BigInteger p;

	public PrimePair(BigInteger p, BigInteger q) {
		this.p = p;
		this.q = q;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + p.toString() + ",");
		sb.append(q.toString() + ">");
		return sb.toString();
	}

	public BigInteger getQ() {
		return q;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger multiply() {
		return p.multiply(q);
	}

}
