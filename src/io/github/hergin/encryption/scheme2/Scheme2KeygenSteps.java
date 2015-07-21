package io.github.hergin.encryption.scheme2;

import io.github.hergin.encryption.scheme1.Scheme1KeygenSteps;
import io.github.hergin.encryption.utils.Constants;
import io.github.hergin.encryption.utils.PrimePair;
import io.github.hergin.encryption.utils.PrimePairList;
import io.github.hergin.encryption.utils.Utils;

import java.math.BigInteger;
import java.util.List;

/**
 * 
 * Static keygen steps of Scheme 2
 * 
 */
public class Scheme2KeygenSteps {

	/**
	 * Choose 2r prime numbers pi and qi, where 1<=i<=r, such that for each i,
	 * pi and qi are distinct primes.
	 * 
	 * @param r
	 * @return [<p1,q1>,<p2,q2>,...,<pr,qr>] + set of distinct pqs
	 */
	public static PrimePairList step1(int r) {
		return Scheme1KeygenSteps.step1(r);
	}

	/**
	 * Compute fi = pi * qi, for 1 <= i <= r.
	 * 
	 * @param pq
	 *            pairs
	 * @return fi
	 */
	public static List<BigInteger> step2(List<PrimePair> listOfPairs) {
		return Scheme1KeygenSteps.step2(listOfPairs);
	}

	/**
	 * Compute N1 = lcm(f1,...,fr).
	 * 
	 * @param fi
	 * @return N1
	 */
	public static BigInteger step3(List<BigInteger> fi) {
		return Scheme1KeygenSteps.step3(fi);
	}

	/**
	 * Pick a secret key k such that gcd(k,N1) = 1.
	 * 
	 * @param N1
	 * @return k secretkey
	 */
	public static BigInteger step4(BigInteger N1) {
		BigInteger k = Utils.getProbablePrime(Constants.BIT_LENGTH);

		while (k.gcd(N1).compareTo(BigInteger.ONE) != 0) {
			k = Utils.getProbablePrime(Constants.BIT_LENGTH);
		}

		return k;
	}

	/**
	 * Compute N =k * f1 * f2 * ... * fr
	 * 
	 * @param k
	 *            , fi
	 * @return N
	 */
	public static BigInteger step5(BigInteger k, List<BigInteger> fi) {
		BigInteger N = k;
		for (BigInteger item : fi) {
			N = N.multiply(item);
		}

		return N;
	}

}
