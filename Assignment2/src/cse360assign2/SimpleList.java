//Name: Shiv Patel
//Class ID: 419
//Assignment 1
//Description: This class stores 10 element in array using add function. The class is able to remove 
//search, get number of elements

package cse360assign2;

public class SimpleList {
	
	private int list[];
	private int count;
	
//This method is the constructor of the class which initializes the array which stores 10 elements and count at 0
	public SimpleList() 
	{
		this.count = 0;
		list = new int[10];
	}
	
/**
 * Add(int) method takes a user input then adds it to the array of size 10.
 * If there are no elements in array, it would add input to first spot.
 * If the number of elements in array represented by count is between 1 and 9, then element  
 * at index of count will move to index count + 1 for all elements.
 * If count is 10, the last element would be replaced by one before for all elements then first element is set to input.
 * If the count is 10, I have made a temporary list which stores all the information from the old list. Then I increase size
 * of the old list and then move everything back into the old list from temp. 
 * 
 * @param input		element user wants to add.
 */
	public void add(int input) 
	{
	       if (count == 0) 
	       {
	           list[count] = input;
	           count++;
	       } 
	       else if (count < list.length) 
	       {
	           for (int i = count - 1; i >= 0; i--) 
	           {
	               list[i + 1] = list[i];
	           }
	           list[0] = input;
	           count++;
	       } 
	       else 
	       {
	           int temp[] = new int[list.length];
	           for(int i = 0; i < list.length; i++) {
	        	   temp[i] = list[i];
	           }
	            
	           int k = (int) (list.length*(50.0f/100.0f));
	           list = new int[list.length+k];
	           
	           
	           for(int i = 0; i < temp.length; i++) {
	        	   list[i] = temp[i];
	           }
	           
	           for (int i = count - 1; i >= 0; i--) 
	           {
	               list[i + 1] = list[i];
	           }
	           
	           list[0] = input;
	           count++;
	       }
	 }
	
/**
 * remove(int) function will use the search function to find the index of where input is located.
 * If the index is found, the element after that index will be placed where the input is for all elements till last.
 * Then I set the last element to 0 and decrement the counter.
 * I would always check how many empty spots are there and If 25% or more empty spots exist, i RESIZE ARRAY TO 
 * SIZE OF NUMBER OF ELEMENTS THAT ARE IN THE LIST. 
 * 
 * @param input		element user want to remove.
 */
	public void remove(int input) 
	{
	       int index = search(input);
	       if (index != -1) 
	       {
	           for (int i = index; i < count; i++) 
	           {
	               if((i+1) != list.length) {
	            	   list[i] = list[i + 1];
	               }
	           }
	           list[count - 1] = 0;
	           count--;    
	           int emptyspots = list.length - count;
	           int k = (int) (list.length*(25.0f/100.0f));
	           if(emptyspots >= k && count != 1) {
	        	   int temp[] = new int[count];
	        	   for(int i = 0; i < count; i++) {
	        		   temp[i] = list[i];
	        	   }
	        	   list = new int[count];
	        	   for(int i = 0; i < temp.length; i++) {
	        		   list[i] = temp[i];
	        	   }
	           }	           	           
	       } 
	 }
	
/**
 * count() method returns the number of elements in the array.
 * 
 * @return index	returns the number of elements in the list.
 */
	public int count() 
	{
	    return count;
	}
	
	
/**
 * search() method takes a input and traverses though the list and if any matches, it returns the index at that spot. 
 * 
 * @param input
 * @return index	returns the index of where that element is stored.
 */
	public int search(int input) 
	{
	       int index = -1;
	       for (int i = 0; i < count; i++) 
	       {
	           if (list[i] == input) 
	           {
	               index = i;
	           }
	       }
	       return index;
	}
	
/**
 * The append function checks if the length is larger than the count to see how many elements are there. 
 * If the size of array and count is same, I would add the element and just like add function after
 * I increase the size of array by 50%. If count is less than length, then I just add like normal without changing array size.
 * @param input
 */
	public void append(int input) {
		if(list.length > count) {
			list[count] = input;
			count++;
		} else {
		    int temp[] = new int[list.length];
            
		    for(int i = 0; i < list.length; i++) {
        	   temp[i] = list[i];
            }
	            
	        int k = (int) (list.length*(50.0f/100.0f));
	        list = new int[list.length+k];
	              
            for(int i = 0; i < temp.length; i++) {
        	   list[i] = temp[i];
            }
            
        	list[count] = input;
   			count++;
		}
	}
	
/**
 * first() method returns the first element in the list or if it is empty it returns -1
 * @return integer	returns the first element or -1 if list is empty
 */
	public int first() {
		if(count != 0) {
			return list[0];
		} else {
			return -1;
		}
	}

/**
 * last() method returns the last element in the list or if it is empty it returns -1
 * @return integer	returns the last element or -1 if list is empty
 */
	public int last() {
		if(count != 0) {
			return list[count-1];
		} else {
			return -1;
		}
	}
	
/**
 * size() function returns the size of the array list
 * @return int 	returns the size of the array list
 */
	public int size() {
		return list.length;
	}
	
/**
 * The toSting() method in String object gets overwritten with new one.
 * This to string adds each element to the string str and places a comma after adding string one by one.
 * Once at the last element, the if statement does not add comma	
 * 
 * @return String	The final string is returned.
 */
	@Override
	   public String toString() 
	{
	       String str = "";
	       for (int i = 0; i < count; i++) 
	       {
	           str += list[i];
	           if (i != count - 1) 
	           {
	               str += " ";
	           }
	       }
	       return str;
	   }

	}
