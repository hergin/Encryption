package io.github.hergin.encryption;

import io.github.hergin.encryption.scheme1.Scheme1KeygenSteps;
import io.github.hergin.encryption.utils.Utils;

public class Main {

	public static void main(String[] args) {

		int[] rs = new int[] { 1, 5, 10, 25 /* , 50, 100, 250, 500, 1000 */};

		System.out.println("r,time");
		for (int r : rs) {
			System.out.println(r + ","
					+ Utils.measure(() -> Scheme1KeygenSteps.step1(r)));
		}

	}
}
