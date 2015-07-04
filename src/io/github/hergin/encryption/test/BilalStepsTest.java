package io.github.hergin.encryption.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import io.github.hergin.encryption.BilalSteps;

import org.junit.Before;
import org.junit.Test;

public class BilalStepsTest {
	BilalSteps scheme1 = new BilalSteps();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStep2() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testStep4() {
		assertEquals(scheme1.step4(new BigInteger("210")), new BigInteger("48"));
	}

	@Test
	public void testStep6() {
		BigInteger k = new BigInteger("5");
		List<BigInteger> fi = new ArrayList<BigInteger>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));
		assertEquals(scheme1.step6(k, fi), new BigInteger("78750"));
	}

}
