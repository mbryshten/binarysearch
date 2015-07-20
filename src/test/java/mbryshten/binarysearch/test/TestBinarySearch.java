package mbryshten.binarysearch.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import mbryshten.binarysearch.BinarySearch;
import mbryshten.binarysearch.NoIfBinarySearch;
import mbryshten.binarysearch.StandardBinarySearch;

import org.junit.Test;

public class TestBinarySearch {

	private static int MAX_ARRAY_SIZE = 1000;
	private static int MAX_NUMBER_SIZE = 1000;
	
	@Test
	public void testBinarySearch() {
		
		BinarySearch standardBinarySearch = new StandardBinarySearch();
		BinarySearch noIfBinarySearch = new NoIfBinarySearch();
				
		testBinarySearch(standardBinarySearch);
		testBinarySearch(noIfBinarySearch);		
	}
	
	private void testBinarySearch(BinarySearch binarySearch) {
		
		Random random = new Random();
		
		int lengh = random.nextInt(MAX_ARRAY_SIZE);
		
		int[] array = new int[lengh];
		
		int number = 0;
		
		for (int i = 0; i < lengh; i++) {
			
			number = random.nextInt(MAX_NUMBER_SIZE);
			array[i] = number;		
		}
		
		Arrays.sort(array);
		
		int randomNumber = array[random.nextInt(lengh -1)];
		
		int position = binarySearch.binSearch(array, randomNumber);
		
		assertTrue(array[position] == randomNumber);
		
		// Special case - first element
		randomNumber = array[0];
		
		position = binarySearch.binSearch(array, randomNumber);
		
		assertTrue(array[position] == randomNumber);
		
		// Special case - last element
		randomNumber = array[lengh - 1];
		
		position = binarySearch.binSearch(array, randomNumber);
		
		assertTrue(array[position] == randomNumber);
		
		// Test null
		position = binarySearch.binSearch(null, randomNumber);
		assertTrue(position == BinarySearch.NOT_FOUND);

		// Test array of size 0
		position = binarySearch.binSearch(new int[]{}, 1);
		assertTrue(position == BinarySearch.NOT_FOUND);
		
		// Test array of size 1
		position = binarySearch.binSearch(new int[]{1}, 1);
		assertTrue(position == 0);
		
	}

}
