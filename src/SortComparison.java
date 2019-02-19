// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
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
	
		/*double lo = a[0];
		double hi = a[a.length-1];
		if(hi<=lo)
			return;
		int lt = (int) lo;
		int gt  = (int) hi;
		Comparable v = a[(int) lo];
		int i = (int) lo;
		while(i<=gt){
			int cmp = a[i].compareTo(v);
		}*/

    }//end quicksort

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

    	
    	
    	
		/*for(int i = 1; i <= (a.length/2) + 1; i*=2){
			for(int j = i; j < a.length; j+= 2 * i){
				
			}
		}*/
    	
    	int current;
		int leftStart;
		int arraySize = a.length;
		for(current = 1; current <= arraySize-1; current = 2*current){
			for(leftStart=0; leftStart < arraySize-1; leftStart += 2*current){
				int mid = leftStart + current - 1;
				int right = getMin(leftStart+2*current-1,arraySize-1);
				a = mergeArray(a,leftStart,mid,right);
			}
		}
		return a;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	
    	int length = a.length;
    	if(length <= 1)
    		return a;
    	double[] x = new double[length/2];
    	double[] y = new double[length - length/2];
    	for(int i = 0; i < x.length; i++)
    		x[i] = a[i];
    	for(int i = 0; i < y.length; i++)
    		y[i] = a[i + length/2];
    	return merge(mergeSortRecursive(x),mergeSortRecursive(y));
    	
	
   }//end mergeSortRecursive
    	
    static double[] mergeArray(double a[], int left, int mid, int right){
    	
    	int leftArraySize = mid-left+1;
    	int rightArraySize = right-mid;
    	double[] leftArray = new double[leftArraySize];
    	double[] rightArray = new double[rightArraySize];
    	
    	for(int i = 0; i<leftArraySize;i++)
    		leftArray[i] = a[left+i];
    	for(int j=0; j<rightArraySize; j++)
    		rightArray[j] = a[mid+1+j];
    	
    	int leftPointer = 0;
    	int rightPointer = 0;
    	int tempPointer = 0;
    	
    	while(leftPointer<leftArraySize && rightPointer<rightArraySize){
    		if(leftArray[leftPointer] <= rightArray[rightPointer]){
    			a[tempPointer] = leftArray[leftPointer];
    			leftPointer++;
    		}
    		else{
    			a[tempPointer] = rightArray[rightPointer];
    			rightPointer++;
    		}
    		tempPointer++;
    	}
    	
    	while(leftPointer<leftArraySize){
    		a[tempPointer++] = leftArray[leftPointer++];
    		leftPointer++;
    		tempPointer++;
    	}
    	
    	while(rightPointer<rightArraySize){
    		a[tempPointer++] = rightArray[rightPointer++];
    		rightPointer++;
    		tempPointer++;
    	}
    	return a;
    }
    
    static int getMin(int left, int right){
    	if(left<=right)
    		return left;
    	else
    		return right;
    }
    
    static double[] merge(double[] a, double[] b){
    	double[] c = new double[a.length + b.length];
    	int i = 0;
    	int j = 0;
    	for(int k = 0; k < c.length; k++){
    		if(i >= a.length)
    			c[k] = b[j++];
    		else if(j >= b.length)
    			c[k] = a[i++];
    		else if(a[i] <= b[j])
    			c[k] = a[i++];
    		else
    			c[k] = b[j++];
    	}
    	return c;
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

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class

