package io.github.hergin.encryption.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecretKey {

	BigInteger k;

	List<BigInteger> fi;

	public SecretKey() {
		fi = new ArrayList<BigInteger>();
	}

	public SecretKey(BigInteger k, List<BigInteger> fi) {
		this.k = k;
		this.fi = fi;
	}

	public BigInteger getK() {
		return k;
	}

	public List<BigInteger> getFi() {
		return fi;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SECRET_KEY( k=" + k.toString() + ", fi=[");
		for (Iterator<BigInteger> iterator = fi.iterator(); iterator.hasNext();) {
			BigInteger f = (BigInteger) iterator.next();
			sb.append(f.toString());
			if (iterator.hasNext())
				sb.append(",");
		}
		sb.append("] )");
		return sb.toString();
	}

	public void setK(BigInteger k) {
		this.k = k;
	}

	public void setFi(List<BigInteger> fi) {
		this.fi = fi;
	}

}
