package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class Utils {

	public static BigInteger lcm(BigInteger a, BigInteger b) {
		return a.multiply(b.divide(a.gcd(b)));
	}

	public static BigInteger lcm(List<BigInteger> nums) {
		BigInteger result = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			result = lcm(result, nums.get(i));
		}
		return result;
	}

	public static BigInteger getProbablePrime(int bitLength) {
		return BigInteger.probablePrime(bitLength,
				new Random(System.nanoTime()));
	}

}
