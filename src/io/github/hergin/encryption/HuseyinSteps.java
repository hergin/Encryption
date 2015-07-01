package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.List;

public class HuseyinSteps {

	/**
	 * Choose 2r prime numbers pi and qi, where 1<=i<=r, such that for each i,
	 * pi and qi are distinct primes.
	 * 
	 * @param r
	 * @return [<p1,q1>,<p2,q2>,...,<pr,qr>]
	 */
	public List<PrimePair> step1(int r) {
		return Utils.get2RprimeNumbers(r);
	}

	/**
	 * Compute N1 = lcm(f1,...,fr).
	 * 
	 * @param fi
	 * @return N1
	 */
	public BigInteger step3(List<BigInteger> fi) {
		BigInteger N1 = BigInteger.ONE;
		N1 = Utils.lcm(fi);
		return N1;
	}

	/**
	 * Pick a secret key k such that gcd(k,d) = 1.
	 * 
	 * @param d
	 * @return k
	 */
	public BigInteger step5(BigInteger d) {
		BigInteger k = Utils.getProbablePrime(Constants.BIT_LENGTH);

		while (k.gcd(d).compareTo(BigInteger.ONE) != 0) {
			k = Utils.getProbablePrime(Constants.BIT_LENGTH);
		}

		return k;
	}

}
