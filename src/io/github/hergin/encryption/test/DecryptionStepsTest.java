package io.github.hergin.encryption.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import io.github.hergin.encryption.DecryptionSteps;

import org.junit.Before;
import org.junit.Test;

public class DecryptionStepsTest {

	DecryptionSteps dec = new DecryptionSteps();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStep1() {
		BigInteger k = new BigInteger("5");
		BigInteger d = new BigInteger("48");

		assertEquals("29", dec.step1(k, d).toString());
	}

	@Test
	public void testStep2() {
		BigInteger C = new BigInteger("50000");
		BigInteger l = new BigInteger("29");
		BigInteger N1 = new BigInteger("210");

		assertEquals("20", dec.step2(C, l, N1).toString());
	}

}
