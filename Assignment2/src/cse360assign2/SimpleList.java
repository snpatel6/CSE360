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
		list = new int[11];
	}
	
/**
 * Add(int) method takes a user input then adds it to the array of size 10.
 * If there are no elements in array, it would add input to first spot.
 * If the number of elements in array represented by count is between 1 and 9, then element  
 * at index of count will move to index count + 1 for all elements.
 * If count is 10, the last element would be replaced by one before for all elements then first element is set to input.
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
	       else if (count < 10) 
	       {
	           for (int i = count; i >= 0; i--) 
	           {
	               list[i + 1] = list[i];
	           }
	           list[0] = input;
	           count++;
	       } 
	       else 
	       {
	           for (int i = count; i > 0; i--) 
	           {
	               list[i] = list[i - 1];
	           }
	           list[0] = input;
	       }
	 }
	
/**
 * remove(int) function will use the search function to find the index of where input is located.
 * If the index is found, the element after that index will be placed where the input is for all elements till last.
 * Then I set the last element to 0 and decrement the counter.
 * 
 * @param input		element user want to remove.
 */
	public void remove(int input) 
	{
	       int index = search(input);
	       if (index != -1) 
	       {
	           for (int i = index; i < count - 1; i++) 
	           {
	               list[i] = list[i + 1];
	           }
	           list[count] = 0;
	           count--;           
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
