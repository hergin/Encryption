package io.github.hergin.encryption.scheme1;

import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;
import io.github.hergin.encryption.utils.PrimePair;
import io.github.hergin.encryption.utils.SecretKey;
import io.github.hergin.encryption.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scheme1timed {

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

	public Scheme1timed(int r) {
		this.r = r;
		kfiPair = new SecretKey();
	}

	public Scheme1timed keygen() {

		/**
		 * STEP1: Compute <pi,qi> pairs
		 */
		List<PrimePair> piqi = new ArrayList<PrimePair>();

		System.out.print(Utils.measure(() -> piqi.addAll(Scheme1KeygenSteps
				.step1(r))) + ",");

		/**
		 * STEP2: Compute fi
		 */
		List<BigInteger> fi = new ArrayList<BigInteger>();

		System.out.print(Utils.measure(() -> fi.addAll(Scheme1KeygenSteps
				.step2(piqi))) + ",");

		// System.out.print("(fi=" + Arrays.toString(fi.toArray()) + ")");

		/**
		 * STEP3: Compute N1
		 */
		System.out
				.print(Utils.measure(() -> setN1(Scheme1KeygenSteps.step3(fi)))
						+ ",");

		/**
		 * STEP4: Compute d
		 */
		System.out
				.print(Utils.measure(() -> setD(Scheme1KeygenSteps.step4(N1)))
						+ ",");

		/**
		 * STEP5: Pick k
		 */
		System.out.print(Utils.measure(() -> kfiPair.setK(Scheme1KeygenSteps
				.step5(d))) + ",");

		/**
		 * STEP6: Compute N
		 */
		System.out.print(Utils.measure(() -> setN(Scheme1KeygenSteps.step6(
				kfiPair.getK(), fi))));

		System.out.print("," + N1+",");
		
		System.out.print(Arrays.toString(piqi.toArray()));

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

	public BigInteger getN() {
		return N;
	}

	public void setN(BigInteger n) {
		N = n;
	}

	public SecretKey getKfiPair() {
		return kfiPair;
	}

	public void setKfiPair(SecretKey kfiPair) {
		this.kfiPair = kfiPair;
	}

	public BigInteger getN1() {
		return N1;
	}

	public void setN1(BigInteger n1) {
		N1 = n1;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
