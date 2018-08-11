package me.rjdavis.tdd.missinginteger;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public int solution(int[] A) {

		int smallestInteger = 1;

		final Set<Integer> positiveIntegers = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				positiveIntegers.add(A[i]);
			}

			while (positiveIntegers.contains(smallestInteger)) {
				smallestInteger++;
			}
		}

		return smallestInteger;
	}
}
