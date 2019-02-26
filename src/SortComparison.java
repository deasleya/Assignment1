import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Aine Deasley
 *  @version HT 2019
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double [] insertionSort (double a[]){

		double temp;
		int previousIndex;

		for(int index=1; index<a.length; index++){
			temp=a[index];
			previousIndex=index;

			while(previousIndex>0 && a[previousIndex-1]>temp){
				a[previousIndex] = a[previousIndex-1];
				previousIndex--;
			}
			a[previousIndex]=temp;
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */

	static double [] quickSort (double a[]){
		if(a.length!=0){
			recursiveQuick(a, 0, a.length-1);
		}
		return a;

	}
	//end quicksort

	static double[] recursiveQuick(double[] a, int lo, int hi) {
		if(hi >= lo) {
			return a;
		}
		int pivotPos = partition(a, lo, hi);
		recursiveQuick(a, lo, pivotPos-1);
		recursiveQuick(a, pivotPos+1, hi);
		return a;
	}

	static int partition(double[] a, int lo, int hi) {
		int i = lo-1;
		double pivot = a[hi];

		for(int j=lo; j<=hi; j++){
			if(a[j] <= pivot){
				i++;
				double temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		double temp = a[i+1];
		a[i+1] = a[hi];
		a[hi] = temp;

		return i;
	}

	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static double[] mergeSortIterative (double a[]) {
		
		for(int current=1; current<a.length; current=2*current) {
			for(int start=0; start<a.length-current; start+=2*current) {
				int mid = start + current - 1;
				int end =Math.min(start+(2*current)-1, a.length-1);
				merge(a,start,mid,end);
			}
		}
		return a;
	}



	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	static double[] mergeSortRecursive(double a[]) {
		int end = a.length-1;
		split(a, 0, end);
		return a;
	}
	
	
	static void split(double a[],int start,int end) {
		if(start<end) {    
			int mid = start + (end-start)/2;
			split(a, start, mid);
			split(a, mid+1, end);
			if(a[mid]<=a[mid+1]) {
				return;
			}
			merge(a, start, mid, end);
		}
	}
	

	static void merge(double a[],int start,int middle,int end) {
		int firstHalf = middle-start+1;
		int secondHalf = end-middle;

		double[] left = new double[firstHalf];
		double[] right = new double[secondHalf];

		for(int i=0; i<firstHalf; i++) {
			left[i] = a[start+i];
		}
		 
		for(int j=0; j<secondHalf; j++) {
			right[j] = a[middle+1+j];
		}

		int startPointer=0;
		int endPointer=0;
		int tempPointer=0;

		while(startPointer<firstHalf && endPointer<secondHalf) {
			if(left[startPointer]<=right[endPointer]) {
				a[tempPointer]=left[startPointer];
				startPointer++;
			}else {
				a[tempPointer]=right[endPointer];
				endPointer++;
			}
			tempPointer++;
		}

		while(startPointer<firstHalf) {
			a[tempPointer]=left[startPointer];
			startPointer++;
			tempPointer++;
		}
		while(endPointer<secondHalf) {
			a[tempPointer]=right[endPointer];
			endPointer++;
			tempPointer++;
		}	
	}

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double [] selectionSort (double a[]){

		int smallest = 0;
		double temp;

		for(int i = 0; i < a.length -1;i++){
			smallest = i;
			for(int j =1; j<a.length-1;j++){
				if(a[j]<a[smallest])
					smallest = j;
			}
			temp = a[smallest];
			a[smallest] = a[i];
			a[i] = temp;
		}
		return a;
	}



/*
	public static void main(String[] args) {

		//todo: do experiments as per assignment instructions

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
		insertionSort(a);
		double endtime = System.currentTimeMillis();
		double duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		quickSort(a);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(a);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		System.out.println(startTime);
		mergeSortIterative(a);
		endtime = System.currentTimeMillis();
		System.out.println(endtime);
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		a = copy;
		startTime = System.currentTimeMillis();
		selectionSort(a);
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
		insertionSort(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		quickSort(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(b);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		b = copy;
		startTime = System.currentTimeMillis();
		selectionSort(b);
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
		insertionSort(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		quickSort(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(c);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		c = copy;
		startTime = System.currentTimeMillis();
		selectionSort(c);
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
		insertionSort(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		quickSort(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(d);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		d = copy;
		startTime = System.currentTimeMillis();
		selectionSort(d);
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
		insertionSort(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		quickSort(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(e);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		e = copy;
		startTime = System.currentTimeMillis();
		selectionSort(e);
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
		insertionSort(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		quickSort(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(f);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		f = copy;
		startTime = System.currentTimeMillis();
		selectionSort(f);
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
		insertionSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Insertionsort took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		quickSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Quicksort took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		mergeSortRecursive(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Recursive took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		mergeSortIterative(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Mergesort Iterative took " + duration + " milliseconds");

		g = copy;
		startTime = System.currentTimeMillis();
		selectionSort(g);
		endtime = System.currentTimeMillis();
		duration = endtime-startTime;
		System.out.println("Selectionsort took " + duration + " milliseconds");

	}*/

}//end class

