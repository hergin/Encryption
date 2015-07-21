package io.github.hergin.encryption.scheme2;

import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;
import io.github.hergin.encryption.utils.PrimePairList;
import io.github.hergin.encryption.utils.SecretKey;

import java.math.BigInteger;
import java.util.List;

public class Scheme2 {

	/**
	 * Public Key
	 */
	BigInteger N;

	/**
	 * Secret Key
	 */
	SecretKey kfiPair;

	BigInteger N1;
	int r;

	public Scheme2(int r) {
		this.r = r;
		kfiPair = new SecretKey();
	}

	public Scheme2 keygen() {

		/**
		 * STEP1: Compute <pi,qi> pairs + set
		 */
		PrimePairList pqlist = Scheme2KeygenSteps.step1(r);

		/**
		 * STEP2: Compute fi
		 */
		List<BigInteger> fi = Scheme2KeygenSteps.step2(pqlist.getList());

		/**
		 * STEP3: Compute N1
		 */
		N1 = Scheme2KeygenSteps.step3(fi);

		/**
		 * STEP4: Pick k
		 */
		kfiPair.setK(Scheme2KeygenSteps.step4(N1));

		/**
		 * STEP5: Compute N
		 */
		N = Scheme2KeygenSteps.step5(kfiPair.getK(), fi);

		/**
		 * STEP6: Finalize keys (public is already finalized)
		 */
		kfiPair.setN1(N1);

		return this;
	}

	public BigInteger encrypt(BigInteger M) throws PlainTextOutOfScopeException {
		/**
		 * STEP1: M is received as parameter
		 */

		/**
		 * STEP2: Determine if M is element of ZN1
		 */
		if (!Scheme2EncryptionSteps.step2(M, N1)) {
			throw new PlainTextOutOfScopeException(M, N1);
		}

		/**
		 * STEP3: Compute cipher text
		 */
		BigInteger C = Scheme2EncryptionSteps.step3(M, getSecretKey().getK(),
				N1);

		/**
		 * STEP4: Cipher text is ready
		 */
		return C;
	}

	public BigInteger decrypt(BigInteger C) {
		/**
		 * STEP1: Compute l
		 */
		BigInteger l = Scheme2DecryptionSteps.step1(getSecretKey().getK(), N1);

		/**
		 * STEP2: Compute M
		 */
		BigInteger M = Scheme2DecryptionSteps.step2(C, l, N1);

		return M;
	}

	public SecretKey getSecretKey() {
		return kfiPair;
	}

}
