package cse360assign2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import assign1.SimpleList;

class testingList {

	//Below line is creating new object
		SimpleList list = new SimpleList();
		
	/**
	 * addloop() method adds 1 to 12 digits in the array one at a time. 
	 * 12 is used to show that last elements gets dropped
	 * 
	 * @return String	This returns the final string using toSring 
	 */
		String addloop() {
			for(int i = 0; i < 25; i++) {
				list.add(i);
			}
			return list.toString();
		}

	/**
	 * removeloop() method adds 1 to 15 digits in the array one at a time. 
	 * Then this method removes the element 9 leaving 9 elements in the array
	 *3
	 * @return String	This returns the final string using toSring 
	 */
		String removeloop() {
			for(int i = 0; i < 10; i++) {
				list.add(i);
			}
			list.remove(2);
			return list.toString();
		}
		
	/**
	 * countTest() method adds 1 to 15 digits in the array one at a time. 
	 * This method should return 10 because that is the max number of elements in the array.
	 * This method checks if the count increments are done correctly
	 * 
	 * @return	int		This method returns the number of elements in the list
	 */
		int countTest() {
			for(int i = 0; i < 16; i++) {
				list.add(i);
			}
			return list.count();
		}
		
	/**
	 * searchloop() method adds 1 to 6 digits in the array one at a time. 
	 * Then it returns the index where 3 is located
	 * 
	 * @return	int 	This method returns the index were it found 3
	 */
		int searchloop() {
			for(int i = 0; i < 6; i++) {
				list.add(i);
			}
			return list.search(3);
		}
		
		
		String appendloop() {
			for(int i = 0; i < 15; i++) {
				list.append(i);
			}
			return list.toString();
		}
		
		int firstloop() {
			for(int i = 2; i < 15; i++) {
				list.add(i);
			}
			return list.first();
		}
		
		int lastloop() {
			for(int i = 2; i < 15; i++) {
				list.add(i);
			}
			return list.last();
		}
		
		//add() method uses assert equals to check with expected output 
		@Test
		void add() {
			assertEquals("14 13 12 11 10 9 8 7 6 5",addloop());
		}
		
		//remove() method uses assert equals to check with expected output 
		@Test
		void remove() {
			assertEquals("9 8 7 6 5 4 3 1 0", removeloop());
		}
		
		@Test
		void append() {
			assertEquals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14", appendloop());
		}
		
		@Test
		void first() {
			assertEquals(14, firstloop());
		}
		
		@Test
		void last() {
			assertEquals(2, lastloop());
		}
		
		//count() method uses assert equals to check with expected output 
		@Test
		void count() {
			assertEquals(16, countTest());
		}
		
		//search() method uses assert equals to check with expected output 
		@Test
		void search() {
			assertEquals(2, searchloop());
		}

}
