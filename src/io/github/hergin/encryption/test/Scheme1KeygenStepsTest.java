package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import io.github.hergin.encryption.scheme1.Scheme1KeygenSteps;
import io.github.hergin.encryption.utils.PrimePair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class Scheme1KeygenStepsTest {

	@Test
	public void testStep1() {
		int r = 5;
		List<PrimePair> result = Scheme1KeygenSteps.step1(r);
		result.stream().forEach(new Consumer<PrimePair>() {

			@Override
			public void accept(PrimePair t) {
				// System.out.println(t.toString());
				assertNotEquals(t.getP(), t.getQ());
			}

		});
		assertEquals(result.size(), r, 0);
	}

	@Test
	public void testStep2() {
		List<PrimePair> piqi = new ArrayList<>();
		piqi.add(new PrimePair(new BigInteger("2"), new BigInteger("3")));
		piqi.add(new PrimePair(new BigInteger("3"), new BigInteger("5")));
		piqi.add(new PrimePair(new BigInteger("5"), new BigInteger("7")));

		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));

		assertEquals(fi, Scheme1KeygenSteps.step2(piqi));
	}

	@Test
	public void testStep3() {
		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));
		assertEquals(new BigInteger("210"), Scheme1KeygenSteps.step3(fi));
	}

	@Test
	public void testStep4() {
		assertEquals(Scheme1KeygenSteps.step4(new BigInteger("210")),
				new BigInteger("48"));
	}
	
	@Test
	public void testStep4_2() {
		assertEquals(Scheme1KeygenSteps.step4(new BigInteger("500")),
				new BigInteger("200"));
	}
	
	@Test
	public void testStep4_3() {
		assertEquals(Scheme1KeygenSteps.step4(new BigInteger("10000")),
				new BigInteger("4000"));
	}
	
	/**
	 * This lasts at least 3 secs
	 */
	@Test
	public void testStep4_4() {
		assertEquals(Scheme1KeygenSteps.step4(new BigInteger("12421232")),
				new BigInteger("6210608"));
	}
	
	/**
	 * This lasts way longer 38 seconds
	 */
	@Test
	public void testStep4_5() {
		assertEquals(Scheme1KeygenSteps.step4(new BigInteger("124212321")),
				new BigInteger("82750464"));
	}

	@Test
	public void testStep5() {
		assertEquals(
				new BigInteger("1"),
				Scheme1KeygenSteps.step5(new BigInteger("48")).gcd(
						new BigInteger("48")));
	}

	@Test
	public void testStep6() {
		BigInteger k = new BigInteger("5");
		List<BigInteger> fi = new ArrayList<BigInteger>();
		fi.add(new BigInteger("6"));
		fi.add(new BigInteger("15"));
		fi.add(new BigInteger("35"));
		assertEquals(Scheme1KeygenSteps.step6(k, fi), new BigInteger("78750"));
	}

}
