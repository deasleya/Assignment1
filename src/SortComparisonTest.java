      import java.io.*;
import java.io.File;
import java.util.Arrays;

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
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *  
 *  	Order of input impacts insertionsort and selectionsort. They both appear to sort faster when the input is ordered in some way.
 *  
 *  
 *	b. Which algorithm has the biggest difference between the best and worst performance, based
 *	   on the type of input, for the input of size 1000? Why?
 *
 *		Insertion sort has the biggest difference. Its best is 0ms, with its worst being 5ms when the numbers input are random. 
 *
 *
 *	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 *	   based on the input size? Please consider only input files with random order for this answer.
 *
 *		Best scalability - 
 *		Worst scalability -
 *
 *
 *	d. Did you observe any difference between iterative and recursive implementations of merge
 *      sort?
 *      
 *      Merge recursive runs quicker than merge iterative in most cases.
 *      
 *      
 *	e. Which algorithm is the fastest for each of the 7 input files? 
 *
 *		Quicksort is fastest
 *
 * ALL TIMES IN MILLISECONDS
 *							Insert		Quick		Merge Recursive		Merge Iterative		Selection
 *	10 random				1			0			0					0					0
 *	100 random				0			0			0					0					1
 *	1000 random				5			0			0					1					5
 *	1000 few unique			1			0			0					1					2
 *	1000 nearly ordered		0			0			0					0					1
 *	1000 reverse order		0			0			0					0					2
 *	1000 sorted				0			0			0					1					0
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
		double[] a = {};
		double[] expected = new double[] {};
		
		SortComparison.insertionSort(a);
		Arrays.equals(expected, a);
		
		SortComparison.quickSort(a);
		Arrays.equals(expected, a);
		
		SortComparison.selectionSort(a);
		Arrays.equals(expected, a);
		
		SortComparison.mergeSortIterative(a);
		Arrays.equals(expected, a);
		
		SortComparison.mergeSortRecursive(a);
		Arrays.equals(expected, a);
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
	public void testQuickSort(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.quickSort(a);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a);   
	}
	
	@Test
	public void testRecursiveQuick(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.recursiveQuick(a,0,a.length-1);
		double[] expected = new double[] {3.0,5.0,7.0,9.0};
		Arrays.equals(expected, a); 
		
		//double[] b = {};
		//SortComparison.recursiveQuick(b,3,1);
		//expected = new double[] {};
		//Arrays.equals(expected, b);  
	}
	
	@Test
	public void testPartition(){
		double[] a = {9.0,5.0,3,0,7.0};
		SortComparison.partition(a,0,a.length-1);
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
		/*try {
			BufferedReader br = new BufferedReader(new FileReader(new File("numbers10.txt")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*double a[] = new double[] {};
		int i =0;
		Scanner scan;
	    File file = new File("U:\2nd Year Programming\numbers10");
	    try {
	        scan = new Scanner(file);

	        while(scan.hasNextDouble())
	        {
	            a[i]= scan.nextDouble();
	            i++;
	        }

	    } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	    }
		
	    double[] copy = a;
	   
	    long startTime = System.currentTimeMillis();
	    SortComparison.insertionSort(a);
	    long endtime = System.currentTimeMillis();
	    long duration = endtime-startTime;
	    System.out.println(duration);
	    
	    a = copy;
	    startTime = System.currentTimeMillis();
	    SortComparison.quickSort(a);
	    endtime = System.currentTimeMillis();
	    duration = endtime-startTime;
	    System.out.println("Quicksort took " + duration);

		
		//SortComparison.quickSort(a);
		
		//SortComparison.selectionSort(a);
		
		//SortComparison.mergeSortIterative(a);
		
		//SortComparison.mergeSortRecursive(a);

	    */
	}

}
