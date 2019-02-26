      import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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
 *  
 *  I'm not sure about the times below, but I've had the code checked by demonstrators in the lab, 
 *  who've said it all looks good, so if the times aren't correct it may be due to the ICT Lab computers! 
 *  I've answered the questions below based on these times.
 *  
 *  
 *  a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *  
 *  	Order of input impacts insertion sort and selection sort mainly. They both appear to sort faster when the input is ordered in some way.
 *  	This is because both insertion sort and selection sort are relatively simple algorithms which work through the array one element at a time.
 *  	They are similar in ways, and are much less efficient than the other sorting algorithms tested when used on large data sets.
 *  	Order of input had a slight impact on merge iterative.
 *  
 *  
 *	b. Which algorithm has the biggest difference between the best and worst performance, based
 *	   on the type of input, for the input of size 1000? Why?
 *
 *		Once again insertion sort and selection sort have the biggest difference. Their best is 0ms, when the list is already sorted,
 *		with their worst being 5ms when the numbers input are random. This is for the same reasons as above. These sorting algorithms work best
 *		on small data sets, or those which are already, or very nearly ordered. In my tests, insertion sort performed better than selection sort
 *		for inputs of size 1000.
 *
 *
 *	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 *	   based on the input size? Please consider only input files with random order for this answer.
 *
 *		Best scalability - Quicksort/Mergesort recursive from the tests, however I believe quicksort to be the most scalable. 
 *		Worst scalability - Selection Sort/Insertion sort, again proving that they cope better with smaller input sizes.
 *
 *
 *	d. Did you observe any difference between iterative and recursive implementations of merge
 *      sort?
 *      
 *      For my tests, merge recursive runs quicker than merge iterative in most cases, but with a max 1ms difference it is hardly noteworthy.
 *      These results may once again vary if tested on a different machine.
 *      
 *      
 *	e. Which algorithm is the fastest for each of the 7 input files? 
 *
 *		From my tests, quicksort and mergesort recursive are both equally fast, but again I beliueve these times are an inaccurate representation.
 *
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
		System.out.println("10 Doubles");
		double a[] = new double[10];
		int i =0;
		Scanner scan;
		
		File file10 = new File("src\\numbers10.txt");
		try {
			scan = new Scanner(file10);

			while(scan.hasNextDouble())
			{
				double r = scan.nextDouble();
				a[i] = r;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		double[] copy = a;

		double startTime = System.currentTimeMillis();
		SortComparison.insertionSort(a);
		double endtime = System.currentTimeMillis();
		double duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(a);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(a);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		System.out.println(startTime);
		SortComparison.mergeSortIterative(a);
		endtime = System.currentTimeMillis();
		System.out.println(endtime);
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(a);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");

		
		
		
		System.out.println("\n100 Doubles");
		
		double b[] = new double[100];
		i =0;
		
		File file100 = new File("src\\numbers100.txt");
		try {
			scan = new Scanner(file100);

			while(scan.hasNextDouble())
			{
				double r = scan.nextDouble();
				b[i] = r;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = b;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");


		
		
		System.out.println("\n1000 Doubles");
		
		double c[] = new double[1000];
		i =0;
		
		File file1000 = new File("src\\numbers1000.txt");
		try {
			scan = new Scanner(file1000);

			while(scan.hasNextDouble())
			{
				double s = scan.nextDouble();
				c[i] = s;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = c;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");


		
		
		System.out.println("\n1000 Duplicated Doubles");
		
		double d[] = new double[1000];
		i =0;
		
		File file1000dup = new File("src\\numbers1000Duplicates.txt");
		try {
			scan = new Scanner(file1000dup);

			while(scan.hasNextDouble())
			{
				double t = scan.nextDouble();
				d[i] = t;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = d;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");

		
		
		
		System.out.println("\n1000 Nearly Ordered Doubles");
		
		double e[] = new double[1000];
		i =0;
		File file1000nearlyOrdered = new File("src\\numbersNearlyOrdered1000.txt");
		try {
			scan = new Scanner(file1000nearlyOrdered);

			while(scan.hasNextDouble())
			{
				double u = scan.nextDouble();
				e[i] = u;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = e;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");



		
		System.out.println("\n1000 Doubles Reversed");
		
		double f[] = new double[1000];
		i =0;
		
		File file1000reverse = new File("src\\numbersReverse1000.txt");
		try {
			scan = new Scanner(file1000reverse);

			while(scan.hasNextDouble())
			{
				double v = scan.nextDouble();
				d[i] = v;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = f;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");



		
		System.out.println("\n1000 Doubles Sorted");
		
		double g[] = new double[1000];
		i =0;
		File file1000sorted = new File("src\\numbersSorted1000.txt");
		try {
			scan = new Scanner(file1000sorted);

			while(scan.hasNextDouble())
			{
				double w = scan.nextDouble();
				d[i] = w;
				i++;
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		copy = g;

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");

	}
}
