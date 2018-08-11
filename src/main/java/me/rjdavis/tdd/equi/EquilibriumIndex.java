package me.rjdavis.tdd.equi;

public class EquilibriumIndex {

	private EquilibriumIndex() {

	}

	public static int find(final int[] list) {
		long prefixSum = 0;
		final int size = list.length;
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				prefixSum += list[i - 1];
			}

			long suffixSum = 0;
			for (int j = i + 1; j < size; j++) {
				suffixSum += list[j];
			}

			if (prefixSum == suffixSum) {
				return i;
			}
		}
		return -1;
	}

}
