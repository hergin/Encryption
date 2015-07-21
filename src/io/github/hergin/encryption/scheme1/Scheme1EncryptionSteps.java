package io.github.hergin.encryption.scheme1;

import io.github.hergin.encryption.utils.Utils;

import java.math.BigInteger;
import java.util.List;

/**
 * 
 * Static encryption steps of Scheme 1
 * 
 */
public class Scheme1EncryptionSteps {

	/**
	 * Determine your plaintext M is an element of ZN1 (basically M should be
	 * less than N1)
	 * 
	 * @param M
	 *            plaintext
	 * @param N1
	 * @return true if M is an element of ZN1
	 */
	public static boolean step2(BigInteger M, BigInteger N1) {
		if (M.compareTo(N1) == -1) {
			return true;
		}
		return false;
	}

	/**
	 * Compute C = M^k (mod N).
	 * 
	 * @param M
	 *            plaintext
	 * @param k
	 *            secretkey
	 * @param N
	 * @return C
	 */
	public static BigInteger step3(BigInteger M, BigInteger k, BigInteger N) {
		BigInteger C = BigInteger.ONE;

		C = M.modPow(k, N);

		return C;
	}

}
