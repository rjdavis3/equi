package me.rjdavis.equi;

import java.util.List;

public class EquilibriumIndex {

	private EquilibriumIndex() {

	}

	public static int find(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			long prefixSum = list.subList(0, i).stream().mapToLong(Long::valueOf).sum();
			long suffixSum = (i == list.size() - 1) ? 0
					: list.subList(i + 1, list.size()).stream().mapToLong(Long::valueOf).sum();
			if (prefixSum == suffixSum) {
				return i;
			}
		}
		return -1;
	}

}
