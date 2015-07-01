package io.github.hergin.encryption.test;

import static org.junit.Assert.*;
import io.github.hergin.encryption.PrimePair;
import io.github.hergin.encryption.HuseyinSteps;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

public class HuseyinStepsTest {

	HuseyinSteps step1 = new HuseyinSteps();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStep1() {
		int r = 5;
		List<PrimePair> result = step1.step1(r);
		result.stream().forEach(new Consumer<PrimePair>() {

			@Override
			public void accept(PrimePair t) {
				System.out.println(t.toString());
			}
			
		});
		assertEquals(result.size(), r, 0);
	}

}
