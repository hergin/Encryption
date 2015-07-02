package io.github.hergin.encryption.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import io.github.hergin.encryption.EncryptionSteps;

import org.junit.Before;
import org.junit.Test;

public class EncryptionStepsTest {

	EncryptionSteps enc = new EncryptionSteps();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStep2() {

		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));

		assertEquals("210", enc.step2(fi).toString());

	}

	@Test
	public void testStep4() {

		BigInteger M = new BigInteger("20");
		BigInteger k = new BigInteger("5");
		BigInteger N = new BigInteger("78750");

		assertEquals("50000", enc.step4(M, k, N).toString());

	}

}
