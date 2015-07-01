package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HuseyinSteps {

	public static int BIT_LENGTH = 50;

	public List<PrimePair> step1(int r) {
		List<PrimePair> result = new ArrayList<PrimePair>();

		for (int i = 1; i <= r; i++) {
			BigInteger p = Utils.getProbablePrime(BIT_LENGTH);
			BigInteger q;
			do {
				q = Utils.getProbablePrime(BIT_LENGTH);
			} while (p.compareTo(q) == 0);
			result.add(new PrimePair(p, q));
		}

		return result;
	}

	public BigInteger step3(List<BigInteger> fi) {
		BigInteger N1 = BigInteger.ONE;
		N1 = Utils.lcm(fi);
		return N1;
	}

	public BigInteger step5(BigInteger d) {
		BigInteger k = Utils.getProbablePrime(BIT_LENGTH);

		while (k.gcd(d).compareTo(BigInteger.ONE) != 0) {
			k = Utils.getProbablePrime(BIT_LENGTH);
		}

		return k;
	}

}
