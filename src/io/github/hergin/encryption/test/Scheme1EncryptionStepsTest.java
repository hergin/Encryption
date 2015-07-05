package io.github.hergin.encryption.test;

import static org.junit.Assert.*;
import io.github.hergin.encryption.scheme1.Scheme1EncryptionSteps;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Scheme1EncryptionStepsTest {

	@Test
	public void testStep2() {

		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));

		assertEquals(new BigInteger("210"), Scheme1EncryptionSteps.step2(fi));

	}

	@Test
	public void testStep3() {
		assertFalse(Scheme1EncryptionSteps.step3(new BigInteger("100"),
				new BigInteger("90")));
	}

	@Test
	public void testStep4() {

		BigInteger M = new BigInteger("20");
		BigInteger k = new BigInteger("5");
		BigInteger N = new BigInteger("78750");

		assertEquals(new BigInteger("50000"),
				Scheme1EncryptionSteps.step4(M, k, N));

	}

}
