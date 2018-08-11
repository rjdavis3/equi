package me.rjdavis.tdd.equi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class EquilibriumIndexTest {

	@Test
	public void givenEmptyListWhenFindingEquiIndexThenReturnNegativeOne() throws Exception {
		final int[] list = new int[0];
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(-1, actualEquiIndex);
	}

	@Test
	public void givenListWithOneIndexWhenFindingEquiIndexThenReturnZero() throws Exception {
		final int[] list = Arrays.asList(5).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(0, actualEquiIndex);
	}

	@Test
	public void givenListWithTwoIndexesWhenFindingEquiIndexThenReturnNegativeOne() throws Exception {
		final int[] list = Arrays.asList(5, 3).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(-1, actualEquiIndex);
	}

	@Test
	public void givenListWithThreeIndexesAndFirstAndThirdIndexesAreEqualWhenFindingEquiIndexThenReturnOne()
			throws Exception {
		final int[] list = Arrays.asList(3, 5, 3).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(1, actualEquiIndex);
	}

	@Test
	public void givenListWithThreeIndexesAndNoEquiWhenFindingEquiIndexThenReturnNegativeOne() throws Exception {
		final int[] list = Arrays.asList(2, 5, 3).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(-1, actualEquiIndex);
	}

	@Test
	public void givenListWithThreeIndexesAndSecondTwoIndixesCancelEachOtherOutWhenFindingEquiIndexThenReturnZero()
			throws Exception {
		final int[] list = Arrays.asList(2, 5, -5).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(0, actualEquiIndex);
	}

	@Test
	public void givenListWithThreeIndexesAndFirtTwoIndicesCancelEachOtherOutWhenFindingEquiIndexThenReturnTwo()
			throws Exception {
		final int[] list = Arrays.asList(2, -2, 8).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(2, actualEquiIndex);
	}

	@Test
	public void givenListWithEightIndexesAndFirstIndexIsEqualToLastSixIndexesWhenFindingEquiIndexThenReturnOne()
			throws Exception {
		final int[] list = Arrays.asList(-1, 3, -4, 5, 1, -6, 2, 1).stream().mapToInt(Integer::intValue).toArray();
		;
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(1, actualEquiIndex);
	}

	@Test
	public void givenListWithThreeIndexesAndSecondTwoIndixesAreNegativeMaxIntWhenFindingEquiIndexThenReturnNegativeOne()
			throws Exception {
		final int[] list = Arrays.asList(0, Integer.MIN_VALUE, Integer.MIN_VALUE).stream().mapToInt(Integer::intValue)
				.toArray();
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(-1, actualEquiIndex);
	}

	@Test
	public void givenListWithFiveIndexesAndSecondTwoIndixesAreMaxIntAndLastTwoIndixesAreMaxIntWhenFindingEquiIndexThenReturnTwo()
			throws Exception {
		final int[] list = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE, 47, Integer.MAX_VALUE, Integer.MAX_VALUE)
				.stream().mapToInt(Integer::intValue).toArray();
		final int actualEquiIndex = EquilibriumIndex.find(list);
		assertEquals(2, actualEquiIndex);
	}

	@Test
	public void givenListWithOneHundredThousandIndexesAllSetToNegativeOneWhenFindingEquiIndexThenReturnNegativeOneInLessThanFiveSeconds()
			throws Exception {
		final int[] list = IntStream.generate(() -> -1).limit(100000).boxed().collect(Collectors.toList()).stream()
				.mapToInt(Integer::intValue).toArray();

		final long timeBeforeExecution = System.currentTimeMillis();
		final int actualEquiIndex = EquilibriumIndex.find(list);
		final long timeAfterExecution = System.currentTimeMillis();
		final long runtime = timeAfterExecution - timeBeforeExecution;

		assertEquals(-1, actualEquiIndex);
		final int maximumRuntime = 5000;
		assertFalse(String.format("Execution took %d ms. Time limit is %d ms.", runtime, maximumRuntime),
				runtime > maximumRuntime);
	}

}
