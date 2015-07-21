package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import io.github.hergin.encryption.scheme1.Scheme1EncryptionSteps;

import java.math.BigInteger;

import org.junit.Test;

public class Scheme1EncryptionStepsTest {

	@Test
	public void testStep2() {
		assertFalse(Scheme1EncryptionSteps.step2(new BigInteger("100"),
				new BigInteger("90")));
	}

	@Test
	public void testStep3() {

		BigInteger M = new BigInteger("20");
		BigInteger k = new BigInteger("5");
		BigInteger N = new BigInteger("78750");

		assertEquals(new BigInteger("50000"),
				Scheme1EncryptionSteps.step3(M, k, N));

	}

}
