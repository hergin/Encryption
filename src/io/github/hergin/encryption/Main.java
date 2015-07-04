package io.github.hergin.encryption;

import io.github.hergin.encryption.scheme1.Scheme1timed;

public class Main {

	public static void main(String[] args) {

		int[] rs = new int[] { 1, 5, 10, 25  , 50, 100, 250, 500, 1000 };

		// System.out.println("r,time");
		// for (int r : rs) {
		// Scheme1 scheme1 = new Scheme1(r);
		// System.out.println(r + "," + Utils.measure(() -> scheme1.keygen()));
		// }

		System.out.println("Keygen Steps");
		System.out.println("1,2,3,4,5,6");
		for (int r : rs) {
			System.out.print("r=" + r + " ");
			new Scheme1timed(r).keygen();
			System.out.println("");
		}

	}
}
