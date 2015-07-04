package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import io.github.hergin.encryption.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLCM() {
		List<BigInteger> numbers = new ArrayList<>();
		numbers.add(new BigInteger("6"));
		numbers.add(new BigInteger("15"));
		numbers.add(new BigInteger("35"));
		assertEquals("210", Utils.lcm(numbers).toString());
	}

	@Test
	public void testLCM2() {
		List<BigInteger> numbers = new ArrayList<>();
		numbers.add(new BigInteger("330"));
		numbers.add(new BigInteger("65"));
		numbers.add(new BigInteger("15"));
		assertEquals("4290", Utils.lcm(numbers).toString());
	}

	@Test
	public void testLCM3() {
		List<BigInteger> numbers = new ArrayList<>();
		numbers.add(new BigInteger("330"));
		numbers.add(new BigInteger("65"));
		numbers.add(new BigInteger("15"));
		numbers.add(new BigInteger("1000"));
		assertEquals("429000", Utils.lcm(numbers).toString());
	}

}
