package io.github.hergin.encryption;

import java.math.BigInteger;

import io.github.hergin.encryption.scheme1.Scheme1timed;
import io.github.hergin.encryption.scheme2.Scheme2timed;
import io.github.hergin.encryption.utils.PlainTextOutOfScopeException;

public class Main {

	public static void main(String[] args) {

		int testScheme = 1;

		if (args.length > 0) {
			testScheme = Integer.parseInt(args[0]);
		}

		BigInteger M = null, C = null, newM = null;

		System.out.println("Testing Scheme " + testScheme);
		System.out.println("----------------");

		switch (testScheme) {
		case 1:
			System.out
					.println(",Keygen Steps,,,,,,Encrypt Steps,Decrypt Steps,,Result");
			System.out.println("r,1,2,3,4,5,6,3,1,2");
			break;

		case 2:
			System.out
					.println(",Keygen Steps,,,,,Encrypt Steps,Decrypt Steps,,Result");
			System.out.println("r,1,2,3,4,5,3,1,2");
			break;

		default:
			break;
		}

		for (int i = 0; i < 20; i++) {
			int r = (int) Math.pow(2, i);
			System.out.print(r + ",");

			switch (testScheme) {
			case 1:
				Scheme1timed scheme1 = new Scheme1timed(r).keygen();

				M = new BigInteger("10000000000000000");
				try {
					C = scheme1.encrypt(M);
				} catch (PlainTextOutOfScopeException e) {
					System.err.print("EXP");
				}
				newM = scheme1.decrypt(C);
				if (M.equals(newM))
					System.out.print(",OK");
				System.out.println("");
				break;

			case 2:
				Scheme2timed scheme2 = new Scheme2timed(r).keygen();

				M = new BigInteger("10000000000000000");
				try {
					C = scheme2.encrypt(M);
				} catch (PlainTextOutOfScopeException e) {
					System.err.print("EXP");
				}
				newM = scheme2.decrypt(C);
				if (M.equals(newM))
					System.out.print(",OK");
				System.out.println("");
				break;

			default:
				break;
			}

		}

	}
}
