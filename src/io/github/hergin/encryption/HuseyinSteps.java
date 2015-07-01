package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HuseyinSteps {

	public static int BIT_LENGTH = 50;

	public List<PrimePair> step1(int r) {
		List<PrimePair> result = new ArrayList<PrimePair>();

		for (int i = 1; i <= r; i++) {
			BigInteger p = BigInteger.probablePrime(BIT_LENGTH, new Random(
					System.nanoTime()));
			BigInteger q;
			do {
				q = BigInteger.probablePrime(BIT_LENGTH,
						new Random(System.nanoTime()));
			} while (p.compareTo(q) == 0);
			result.add(new PrimePair(p, q));
		}

		return result;
	}
	
}
