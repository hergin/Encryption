package io.github.hergin.encryption.scheme2;

import java.math.BigInteger;

/**
 * 
 * Static decryption steps of Scheme 2
 * 
 */
public class Scheme2DecryptionSteps {

	/**
	 * Compute inverse l of k according to mod N1.
	 * 
	 * @param k
	 *            secretkey
	 * @param N1
	 * @return l
	 */
	public static BigInteger step1(BigInteger k, BigInteger N1) {
		BigInteger l = BigInteger.ONE;

		l = k.modInverse(N1);

		return l;
	}

	/**
	 * Compute C*l = M*(kl) = M (mod N1).
	 * 
	 * @param C
	 *            cipheredtext
	 * @param l
	 * @param N1
	 * @return M plaintext
	 */
	public static BigInteger step2(BigInteger C, BigInteger l, BigInteger N1) {
		BigInteger M = BigInteger.ONE;

		M = C.multiply(l).mod(N1);

		return M;
	}

}
