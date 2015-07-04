package io.github.hergin.encryption.scheme1;

import java.math.BigInteger;

/**
 * 
 * Static decryption steps of Scheme 1
 * 
 */
public class Scheme1DecryptionSteps {

	/**
	 * Compute inverse l of k according to mod d.
	 * 
	 * @param k
	 *            secretkey
	 * @param d
	 * @return l
	 */
	public static BigInteger step1(BigInteger k, BigInteger d) {
		BigInteger l = BigInteger.ONE;

		l = k.modInverse(d);

		return l;
	}

	/**
	 * Compute C^l = M^(kl) = M (mod N1).
	 * 
	 * @param C
	 *            cipheredtext
	 * @param l
	 * @param N1
	 * @return M plaintext
	 */
	public static BigInteger step2(BigInteger C, BigInteger l, BigInteger N1) {
		BigInteger M = BigInteger.ONE;

		M = C.modPow(l, N1);

		return M;
	}
}
