package fr.ptc.devoir.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.ptc.devoir.exception.PartitionErrorCode;
import fr.ptc.devoir.exception.PartitionException;

public class PartitionControllerTest {

	PartitionController partitionController;

	@Before
	public void setUp() {
		partitionController = new PartitionController();
	}

	@Test
	public void test_partitionning_with_listOfInteger() {
		// Given
		List<Integer> elements = new ArrayList<Integer>();
		elements = Arrays.asList(1, 2, 3, 4);
		List<List<Integer>> expectedSubLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4));
		// When
		List<List<Integer>> subLists = partitionController.getPartitionBySize(elements, 3);
		// Then
		Assert.assertEquals(subLists, expectedSubLists);
	}

	@Test
	public void test_partitionning_with_listOfString() {
		// Given
		List<String> elements = new ArrayList<String>();
		List<List<String>> expectedSubLists = new ArrayList<List<String>>();
		elements = Arrays.asList("a", "2", "g", "4", null, "*");
		expectedSubLists = Arrays.asList(Arrays.asList("a", "2", "g"), Arrays.asList("4", null, "*"));
		// When
		List<List<String>> subLists = partitionController.getPartitionBySize(elements, 3);
		// Then
		Assert.assertEquals(subLists, expectedSubLists);
	}

	@Test
	public void test_partitionning_with_listOfString() {
		// Given
		List<List<String>> elements = new ArrayList<List<String>>();
		elements = Arrays.asList(Arrays.asList("a", "2", "g"), Arrays.asList("4", "E", "*"));
		List<List<List<String>>> expectedSubLists = Arrays.asList(Arrays.asList(Arrays.asList("a", "2", "g"), Arrays.asList("4", "E", "*")));
		// When
		List<List<List<String>>> subLists = partitionController.getPartitionBySize(elements, 3);
		// Then
		Assert.assertEquals(subLists, expectedSubLists);
	}

	@Test
	public void test_partitionning_with_emptyList() {
		// Given
		List<String> elements = Collections.emptyList();
		// When
		try {
			partitionController.getPartitionBySize(elements, 3);
			// Then
		} catch (Exception exception) {
			Assert.assertNotNull(exception);
			Assert.assertTrue(exception.getMessage().contains(PartitionErrorCode.EMPTY_ELEMENT.message()));
		}
	}

	@Test(expected = PartitionException.class)
	public void test_partitionning_with_SizeEqualZero() {
		// Given

		List<String> elements = new ArrayList<String>();
		elements = Arrays.asList("a", "2", "g", "4");

		// When
		partitionController.getPartitionBySize(elements, 0);

	}

	@Test
	public void test_partitionning_with_listSizeEqualSublistsSize() {

		// Given
		List<String> elements = new ArrayList<String>();
		elements = Arrays.asList("a", "2", "g", "4");
		List<List<String>> expectedSubLists = Arrays.asList(Arrays.asList("a", "2", "g", "4"));

		// When
		List<List<String>> subLists = partitionController.getPartitionBySize(elements, 4);

		// Then
		Assert.assertEquals(subLists, expectedSubLists);

	}

}
