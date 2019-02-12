import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
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


	public static void main(String[] args)
	{
		//TODO: implement this method
	}

}
