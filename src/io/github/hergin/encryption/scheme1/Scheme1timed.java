package io.github.hergin.encryption.scheme1;

import io.github.hergin.encryption.utils.Function;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;
import io.github.hergin.encryption.utils.PrimePairList;
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
	BigInteger C;
	BigInteger M;
	BigInteger l;
	int r;

	public Scheme1timed(int r) {
		this.r = r;
		kfiPair = new SecretKey();
	}

	public Scheme1timed keygen() {

		/**
		 * STEP1: Compute <pi,qi> pairs
		 */
		PrimePairList pqlist = new PrimePairList();

		System.out.print(Utils.measure(() -> {
			PrimePairList temp = Scheme1KeygenSteps.step1(r);
			if (pqlist.getList().isEmpty()) {
				pqlist.getList().addAll(temp.getList());
				pqlist.getSet().addAll(temp.getSet());
			}
		}) + ",");

		/**
		 * STEP2: Compute fi
		 */
		List<BigInteger> fi = new ArrayList<BigInteger>();

		System.out.print(Utils.measure(new Function() {
			@Override
			public void doIt() {
				List<BigInteger> list = Scheme1KeygenSteps.step2(pqlist
						.getList());
				if (fi.isEmpty())
					fi.addAll(list);
			}
		}) + ",");

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
		System.out.print(Utils.measure(() -> setD(Scheme1KeygenSteps
				.step4_optimized(pqlist.getSet()))) + ",");

		/**
		 * STEP5: Pick k
		 */
		System.out.print(Utils.measure(() -> kfiPair.setK(Scheme1KeygenSteps
				.step5(d))) + ",");

		/**
		 * STEP6: Compute N
		 */
		System.out.print(Utils.measure(() -> setN(Scheme1KeygenSteps.step6(
				kfiPair.getK(), fi))) + ",");

		// System.out.print("," + N1 + ",");
		if (r < 3 && false)
			System.out.print("PQlist="
					+ Arrays.toString(pqlist.getList().toArray()) + ",N1=" + N1
					+ ",d=" + d + ",");

		// System.out.print(Arrays.toString(pqlist.getList().toArray()));

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
		 * STEP2: Determine if M is element of ZN1
		 */
		if (!Scheme1EncryptionSteps.step2(M, N1)) {
			throw new PlainTextOutOfScopeException(M, N1);
		}

		/**
		 * STEP3: Compute cipher text
		 */
		System.out.print(Utils.measure(() -> setC(Scheme1EncryptionSteps.step3(
				M, getSecretKey().getK(), N1))) + ",");

		/**
		 * STEP4: Cipher text is ready
		 */
		return C;

	}

	public BigInteger decrypt(BigInteger C) {

		/**
		 * STEP1: Compute l
		 */
		System.out.print(Utils.measure(() -> setL(Scheme1DecryptionSteps.step1(
				getSecretKey().getK(), d))) + ",");

		/**
		 * STEP2: Compute M
		 */
		System.out.print(Utils.measure(() -> setM(Scheme1DecryptionSteps.step2(
				C, l, N1))));

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

	public void setC(BigInteger c) {
		C = c;
	}

	public void setM(BigInteger m) {
		M = m;
	}

	public BigInteger getC() {
		return C;
	}

	public BigInteger getM() {
		return M;
	}

	public BigInteger getL() {
		return l;
	}

	public void setL(BigInteger l) {
		this.l = l;
	}

}
