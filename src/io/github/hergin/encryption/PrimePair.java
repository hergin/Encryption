package io.github.hergin.encryption;

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
		sb.append("P= " + p.toString() + "\n");
		sb.append("Q= " + q.toString());
		return sb.toString();
	}

}
