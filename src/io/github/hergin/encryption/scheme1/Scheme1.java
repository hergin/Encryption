package io.github.hergin.encryption.scheme1;

import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;
import io.github.hergin.encryption.utils.PrimePair;
import io.github.hergin.encryption.utils.SecretKey;

import java.math.BigInteger;
import java.util.List;

public class Scheme1 {

	/**
	 * Public Key
	 */
	BigInteger N;

	/**
	 * Secret Key
	 */
	SecretKey kfiPair;

	BigInteger N1;
	BigInteger d;
	int r;

	public Scheme1(int r) {
		this.r = r;
		kfiPair = new SecretKey();
	}

	public Scheme1 keygen() {

		/**
		 * STEP1: Compute <pi,qi> pairs
		 */
		List<PrimePair> piqi = Scheme1KeygenSteps.step1(r);

		/**
		 * STEP2: Compute fi
		 */
		List<BigInteger> fi = Scheme1KeygenSteps.step2(piqi);

		/**
		 * STEP3: Compute N1
		 */
		N1 = Scheme1KeygenSteps.step3(fi);

		/**
		 * STEP4: Compute d
		 */
		d = Scheme1KeygenSteps.step4(N1);

		/**
		 * STEP5: Pick k
		 */
		kfiPair.setK(Scheme1KeygenSteps.step5(d));

		/**
		 * STEP6: Compute N
		 */
		N = Scheme1KeygenSteps.step6(kfiPair.getK(), fi);

		/**
		 * STEP7: Finalize keys (public is already finalized)
		 */
		kfiPair.setFi(fi);

		return this;
	}

	public BigInteger encrypt(BigInteger M) throws PlainTextOutOfScopeException {

		/**
		 * STEP1: M is received as parameter
		 */

		/**
		 * STEP2: Compute N1 (already computed in keygen step3)
		 */

		/**
		 * STEP3: Determine if M is element of ZN1
		 */
		if (!Scheme1EncryptionSteps.step3(M, N1)) {
			throw new PlainTextOutOfScopeException(M, N1);
		}

		/**
		 * STEP4: Compute cipher text
		 */
		BigInteger C = Scheme1EncryptionSteps.step4(M, getSecretKey().getK(),
				N1);

		/**
		 * STEP5: Cipher text is ready
		 */
		return C;

	}

	public BigInteger decrypt(BigInteger C) {

		/**
		 * STEP1: Compute l
		 */
		BigInteger l = Scheme1DecryptionSteps.step1(getSecretKey().getK(), d);

		/**
		 * STEP2: Compute M
		 */
		BigInteger M = Scheme1DecryptionSteps.step2(C, l, N1);

		return M;
	}

	public BigInteger getPublicKey() {
		return N;
	}

	public SecretKey getSecretKey() {
		return kfiPair;
	}

	public BigInteger getN1() {
		return N1;
	}

}
