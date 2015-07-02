package io.github.hergin.encryption;

import java.math.BigInteger;

public class DecryptionSteps {

	/**
	 * Compute inverse l of k according to mod d.
	 * 
	 * @param k
	 *            secretkey
	 * @param d
	 * @return l
	 */
	public BigInteger step1(BigInteger k, BigInteger d) {
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
	public BigInteger step2(BigInteger C, BigInteger l, BigInteger N1) {
		BigInteger M = BigInteger.ONE;

		M = C.modPow(l, N1);

		return M;
	}
}
