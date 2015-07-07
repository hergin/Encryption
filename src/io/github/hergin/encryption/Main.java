package io.github.hergin.encryption;

import java.math.BigInteger;

import io.github.hergin.encryption.scheme1.Scheme1timed;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;

public class Main {

	public static void main(String[] args) {

		System.out
				.println(",Keygen Steps,,,,,,Encrypt Steps,Decrypt Steps,,Result");
		System.out.println("r,1,2,3,4,5,6,4,1,2");
		for (int i = 0; i < 20; i++) {
			int r = (int) Math.pow(2, i);
			System.out.print(r + ",");
			Scheme1timed scheme1 = new Scheme1timed(r).keygen();

			BigInteger M = new BigInteger("10000000000000000");
			BigInteger C = null;
			try {
				C = scheme1.encrypt(M);
			} catch (PlainTextOutOfScopeException e) {
				System.err.print("EXP");
			}
			BigInteger newM = scheme1.decrypt(C);
			if (M.equals(newM))
				System.out.print(",OK");
			System.out.println("");
		}

	}
}
