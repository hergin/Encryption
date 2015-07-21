package io.github.hergin.encryption.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import io.github.hergin.encryption.scheme2.Scheme2;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;

import org.junit.Before;
import org.junit.Test;

public class Scheme2Test {

	Scheme2 scheme2;

	@Before
	public void setUp() throws Exception {
		scheme2 = new Scheme2(10).keygen();
	}

	@Test
	public void testSanity() throws PlainTextOutOfScopeException {
		assertEquals(new BigInteger("123456"),
				scheme2.decrypt(scheme2.encrypt(new BigInteger("123456"))));
		assertEquals(new BigInteger("12223456"),
				scheme2.decrypt(scheme2.encrypt(new BigInteger("12223456"))));
		assertEquals(new BigInteger("3"),
				scheme2.decrypt(scheme2.encrypt(new BigInteger("3"))));
	}

}
