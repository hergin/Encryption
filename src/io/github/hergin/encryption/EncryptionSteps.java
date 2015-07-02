package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.List;

public class EncryptionSteps {

	/**
	 * Compute N1 = lcm(f1,...,fr).
	 * 
	 * @param fi
	 * @return N1
	 */
	public BigInteger step2(List<BigInteger> fi) {
		BigInteger N1 = BigInteger.ONE;

		N1 = Utils.lcm(fi);

		return N1;
	}

	/**
	 * Determine your plaintext M is an element of ZN1
	 * 
	 * @param M
	 *            plaintext
	 * @param N1
	 * @return true if M is an element of ZN1
	 */
	public boolean step3(BigInteger M, BigInteger N1) {
		return true;
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
	public BigInteger step4(BigInteger M, BigInteger k, BigInteger N) {
		BigInteger C = BigInteger.ONE;

		C = M.modPow(k, N);

		return C;
	}

}
