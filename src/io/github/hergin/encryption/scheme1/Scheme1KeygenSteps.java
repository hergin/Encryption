package io.github.hergin.encryption.scheme1;

import io.github.hergin.encryption.utils.Constants;
import io.github.hergin.encryption.utils.PrimePair;
import io.github.hergin.encryption.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Static keygen steps of Scheme 1
 * 
 */
public class Scheme1KeygenSteps {

	/**
	 * Choose 2r prime numbers pi and qi, where 1<=i<=r, such that for each i,
	 * pi and qi are distinct primes.
	 * 
	 * @param r
	 * @return [<p1,q1>,<p2,q2>,...,<pr,qr>]
	 */
	public static List<PrimePair> step1(int r) {
		return Utils.get2RprimeNumbers(r);
	}

	/**
	 * (2) Compute fi = pi * qi, for 1 <= i <= r.
	 * 
	 * @param pq
	 *            pairs
	 * @return fi
	 */
	public static List<BigInteger> step2(List<PrimePair> listOfPairs) {
		List<BigInteger> fi = new ArrayList<BigInteger>();
		for (PrimePair pair : listOfPairs) {
			fi.add(pair.multiply());
		}
		return fi;
	}

	/**
	 * Compute N1 = lcm(f1,...,fr).
	 * 
	 * @param fi
	 * @return N1
	 */
	public static BigInteger step3(List<BigInteger> fi) {
		BigInteger N1 = BigInteger.ONE;
		N1 = Utils.lcm(fi);
		return N1;
	}

	/**
	 * (4) Compute d = EulerPhi(N1) function.
	 * http://professorjava.weebly.com/totient.html works correctly. _______
	 * TODO definitely we should look for an optimized solution other than a
	 * brute force, check @Scheme1KeygenStepsTest unit tests for timing
	 * 
	 * @param N1
	 * @return EulerPhi(N1)
	 */
	public static BigInteger step4(BigInteger N1) {
		BigInteger count = BigInteger.ZERO;
		BigInteger a;
		for (a = new BigInteger("1"); a.compareTo(N1) < 0; a = a
				.add(BigInteger.ONE)) {
			if (N1.gcd(a).equals(BigInteger.ONE)) { // coprime
				count = count.add(BigInteger.ONE);
			}
		}
		return count;
	}

	/**
	 * Pick a secret key k such that gcd(k,d) = 1.
	 * 
	 * @param d
	 * @return k secretkey
	 */
	public static BigInteger step5(BigInteger d) {
		BigInteger k = Utils.getProbablePrime(Constants.BIT_LENGTH);

		while (k.gcd(d).compareTo(BigInteger.ONE) != 0) {
			k = Utils.getProbablePrime(Constants.BIT_LENGTH);
		}

		return k;
	}

	/**
	 * (6) Compute N =k^2 p1q1 p2q2 ... pr qr
	 * 
	 * @param k
	 *            , fi
	 * @return N
	 */
	public static BigInteger step6(BigInteger k, List<BigInteger> fi) {
		BigInteger N = k.multiply(k);
		for (BigInteger item : fi) {
			N = N.multiply(item);
		}

		return N;
	}
}
