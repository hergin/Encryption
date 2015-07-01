package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import io.github.hergin.encryption.HuseyinSteps;
import io.github.hergin.encryption.PrimePair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

public class HuseyinStepsTest {

	HuseyinSteps scheme1 = new HuseyinSteps();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStep1() {
		int r = 5;
		List<PrimePair> result = scheme1.step1(r);
		result.stream().forEach(new Consumer<PrimePair>() {

			@Override
			public void accept(PrimePair t) {
				// System.out.println(t.toString());
				assertNotEquals(t.getP().toString(), t.getQ().toString());
			}

		});
		assertEquals(result.size(), r, 0);
	}

	@Test
	public void testStep3() {
		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));
		assertEquals("210", scheme1.step3(fi).toString());
	}

	@Test
	public void testStep5() {
		assertEquals("1",
				scheme1.step5(new BigInteger("48")).gcd(new BigInteger("48"))
						.toString());
	}

}
