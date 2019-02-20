import static org.junit.Assert.*;

import java.io.*;
import java.util.Arrays;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Aine Deasley
 *  @version HT 2019
 *  
 *   a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *	b. Which algorithm has the biggest difference between the best and worst performance, based
 *	   on the type of input, for the input of size 1000? Why?
 *	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 *	   based on the input size? Please consider only input files with random order for this answer.
 *	d. Did you observe any difference between iterative and recursive implementations of merge
 *      sort?
 *	e. Which algorithm is the fastest for each of the 7 input files? 
 */

@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new SortComparison();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
	}


	// TODO: add more tests here. Each line of code and ech decision in Collinear.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 *
	 */

	@Test
	public void testInsertionSort(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.insertionSort(a);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a);   
	}
	
	@Test
	public void testSelectionSort(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.selectionSort(a);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a);   
	}
	
	@Test
	public void testMergeSortIterative(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.mergeSortIterative(a);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a);   
	}
	
	@Test
	public void testMergeSortRecursive(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.mergeSortRecursive(a);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a);   
	}


	public static void main(String[] args)
	{
		//TODO: implement this method
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("numbers10.txt")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
