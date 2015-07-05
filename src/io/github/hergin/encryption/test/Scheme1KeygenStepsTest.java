package io.github.hergin.encryption.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import io.github.hergin.encryption.scheme1.Scheme1KeygenSteps;
import io.github.hergin.encryption.utils.PrimePair;
import io.github.hergin.encryption.utils.PrimePairList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Test;

public class Scheme1KeygenStepsTest {

	@Test
	public void testStep1() {
		int r = 5;
		PrimePairList pplist = Scheme1KeygenSteps.step1(r);
		pplist.getList().stream().forEach(new Consumer<PrimePair>() {

			@Override
			public void accept(PrimePair t) {
				// System.out.println(t.toString());
				assertNotEquals(t.getP(), t.getQ());
			}

		});
		assertEquals(pplist.getList().size(), r, 0);
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
	public void testStep3_2() {
		List<BigInteger> fi = new ArrayList<>();
		fi.add(new BigInteger("713"));
		fi.add(new BigInteger("323"));
		fi.add(new BigInteger("713"));
		fi.add(new BigInteger("391"));
		fi.add(new BigInteger("551"));
		fi.add(new BigInteger("713"));
		fi.add(new BigInteger("437"));
		fi.add(new BigInteger("667"));
		fi.add(new BigInteger("713"));
		fi.add(new BigInteger("899"));
		assertEquals(new BigInteger("6678671"), Scheme1KeygenSteps.step3(fi));
	}

	@Test
	public void testStep4() {
		Set<BigInteger> set = new HashSet<>();
		set.add(new BigInteger("2"));
		set.add(new BigInteger("3"));
		set.add(new BigInteger("5"));
		set.add(new BigInteger("7"));
		assertEquals(new BigInteger("48"),
				Scheme1KeygenSteps.step4_optimized(set));
	}

	@Test
	public void testStep4_naive() {
		assertEquals(Scheme1KeygenSteps.step4_naive(new BigInteger("500")),
				new BigInteger("200"));
	}

	@Test
	public void testStep4_naive2() {
		assertEquals(Scheme1KeygenSteps.step4_naive(new BigInteger("10000")),
				new BigInteger("4000"));
	}

	@Test
	public void testStep4_naive3() {
		assertEquals(
				Scheme1KeygenSteps.step4_naive(new BigInteger("12421232")),
				new BigInteger("6210608"));
	}

	// The following tests are infeasible with naive approach
	//
	// @Test
	// public void testStep4_naive4() {
	// assertEquals(Scheme1KeygenSteps.step4_naive(new BigInteger("124212321")),
	// new BigInteger("82750464"));
	// }
	//
	// @Test
	// public void testStep4_naive5() {
	// assertEquals(Scheme1KeygenSteps.step4_naive(new
	// BigInteger("394516319693")),
	// new BigInteger("367250526720"));
	// }

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
