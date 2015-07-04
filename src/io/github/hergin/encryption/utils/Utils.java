package io.github.hergin.encryption.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utils class
 */
public class Utils {

	/**
	 * Execute function f, Constants.RUN_COUNT times and measure average
	 * performance in milliseconds
	 * 
	 * @param f
	 *            function to be executed
	 * @return average running time in milliseconds
	 */
	public static double measure(Function f) {

		Timer timer = new Timer();

		long totalTime = 0;
		for (int i = 0; i < Constants.RUN_COUNT; i++) {
			timer.start();
			f.doIt();
			timer.end();
			totalTime += timer.getTotalTime();
		}

		return totalTime / (Constants.RUN_COUNT * 1.0);

	}

	/**
	 * Compute LCM of a and b by LCM(a,b)=a*(b/gcd(a,b))
	 * 
	 * @param a
	 * @param b
	 * @return LCM(a,b)
	 */
	public static BigInteger lcm(BigInteger a, BigInteger b) {
		return a.multiply(b.divide(a.gcd(b)));
	}

	/**
	 * Compute LCM of a list of BigIntegers by computing LCM of two numbers at a
	 * time until the end
	 * 
	 * @param nums
	 *            list of BigIntegers
	 * @return LCM(nums1,nums2,num3,...)
	 */
	public static BigInteger lcm(List<BigInteger> nums) {
		BigInteger result = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			result = lcm(result, nums.get(i));
		}
		return result;
	}

	/**
	 * Returns a probably prime BigInteger having bitLength
	 * 
	 * @param bitLength
	 * @return prime number
	 */
	public static BigInteger getProbablePrime(int bitLength) {
		return BigInteger.probablePrime(bitLength,
				new Random(System.nanoTime()));
	}

	/**
	 * Compute and return 2R prime numbers in form of pi and qi where pi and qi
	 * are distinct primes
	 * 
	 * @param r
	 * @return a list of <pi,qi> size r
	 */
	public static List<PrimePair> get2RprimeNumbers(int r) {
		List<PrimePair> result = new ArrayList<PrimePair>();

		for (int i = 1; i <= r; i++) {
			BigInteger p = Utils.getProbablePrime(Constants.BIT_LENGTH);
			BigInteger q;
			do {
				q = Utils.getProbablePrime(Constants.BIT_LENGTH);
			} while (p.compareTo(q) == 0);
			result.add(new PrimePair(p, q));
		}

		return result;
	}

}
