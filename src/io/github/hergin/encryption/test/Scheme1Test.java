package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.github.hergin.encryption.scheme1.Scheme1;
import io.github.hergin.encryption.utils.Constants;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class Scheme1Test {

	Scheme1 scheme1;

	@Before
	public void setUp() throws Exception {
		scheme1 = new Scheme1(100).keygen();
	}

	@Test
	public void testKeygen() {
		assertNotNull(scheme1.getPublicKey());
		assertNotNull(scheme1.getSecretKey().getFi());
		assertNotNull(scheme1.getSecretKey().getK());
	}

	@Test
	public void testEncryption() throws PlainTextOutOfScopeException {
		assertEquals(new BigInteger("1223620"),
				scheme1.encrypt(new BigInteger("20")));
	}

	@Test
	public void testDecryption() {
		assertEquals(new BigInteger("20"),
				scheme1.decrypt((new BigInteger("1223620"))));
	}

	@Test
	public void testSanity() throws PlainTextOutOfScopeException {
		assertEquals(new BigInteger("50"),
				scheme1.decrypt(scheme1.encrypt(new BigInteger("50"))));
	}

	@Test(expected = PlainTextOutOfScopeException.class)
	public void testInvalidPlainText() throws PlainTextOutOfScopeException {
		assertEquals("For this test, bitlength should be 5.", 5,
				Constants.BIT_LENGTH);
		Scheme1 newScheme1 = new Scheme1(100).keygen();
		newScheme1.encrypt(new BigInteger("6678672"));
	}

}
