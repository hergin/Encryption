package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import io.github.hergin.encryption.scheme1.Scheme1DecryptionSteps;

import java.math.BigInteger;

import org.junit.Test;

public class Scheme1DecryptionStepsTest {

	@Test
	public void testStep1() {
		BigInteger k = new BigInteger("5");
		BigInteger d = new BigInteger("48");

		assertEquals(new BigInteger("29"), Scheme1DecryptionSteps.step1(k, d));
	}

	@Test
	public void testStep2() {
		BigInteger C = new BigInteger("50000");
		BigInteger l = new BigInteger("29");
		BigInteger N1 = new BigInteger("210");

		assertEquals(new BigInteger("20"),
				Scheme1DecryptionSteps.step2(C, l, N1));
	}

}
