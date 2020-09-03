/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 30/10/19   ***/
/***     Extended by: Dominykas Mickevicius        ***/
/*****************************************************/
	
import java.io.*;
import java.text.*;
import java.util.*;
	
public class Sort {
	
  /** Size of array **/
  private int size;
	
  /** Number of used elements in array **/
  private int usedSize;
	
  /** Array of integers **/
  private int[] A;
	
  /** Global variables for counting sort comparisons **/
  public int compIS; /** Global comparison count for Insertion Sort **/
  public int compQS; /** Global comparison count for Quicksort **/
  public int compNS; /** Global comparison count for newsort **/
	
  /*****************/
  /** Constructor **/
  /*****************/
  Sort(int max)
  {
    /** Initialise global sort count variables **/
    compIS = 0;
    compQS = 0;
    compNS = 0;
	    
    /** Initialise size variables **/
    usedSize = 0;
    size = max;
	    
    /** Create Array of Integers **/
    A = new int[size];
  }
	
  // Getter methods for the array and used size
	
  public int[] getArray() {
    return A;
  }
	
  public int getUsedSize() {
    return usedSize;
  }
	
  /*********************************************/
  /*** Read a file of integers into an array ***/
  /*********************************************/
  public void readIn(String file)
  {
    try
    {
      /** Initialise loop variable **/
      usedSize = 0;
	       
      /** Set up file for reading **/
      FileReader reader = new FileReader(file);
      Scanner in = new Scanner(reader);
	       
      /** Loop round reading in data while array not full **/
      while(in.hasNextInt() && (usedSize < size))
      {
        A[usedSize] = in.nextInt();
        usedSize++;
      }
	       
    }
    catch (IOException e)
    {
      System.out.println("Error processing file " + file);
    }
	   
  }
	
  /**********************/
  /*** Display array  ***/
  /**********************/
  public void display(int line, String header)
  {
    /*** Integer Formatter - three digits ***/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);
	
    /** Print header string **/
    System.out.print("\n"+header);
	
    /** Display array data **/
    for (int i=0;i<usedSize;i++)
    {
      /** Check if new line is needed **/
      if (i%line == 0) 
      { 
        System.out.println(); 
      }
	        
      /** Display an array element **/
      System.out.print(FI.format(A[i])+" ");
    }
  }
	  
  // Insertion Sort method
  public void insertion() {
		
    // Initialise key, i and j for looping
    int i, key, j;
		
    for (i = 1; i < usedSize; i++) {
      key = A[i];
      j = i;
      while (j > 0 && key < A[j-1]) {
        // Increase comparisons
        compIS++;
        A[j] = A[j-1];
        j--;
      }
      /* if we assume that both boolean expressions are checked before entering the while loop (even if j > 0 is false,
      key < A[j-1] is still checked), then increase number of comparisons
      */
      compIS++;
      A[j] = key;
    }
  }
	
  // Quick Sort method
  public void quicksort(int L, int R) {
    // Initialise pivot
    int p;
    // stop if one value left
    if (R > L) {
      p = partition(L, R);
      quicksort(L, p-1);
      quicksort(p+1, R);
    }
  }
	
  private int partition(int left, int right) {
	
    // initialise the value of the pivot, left and right scanning pointers
    int v = A[right];
    int pL = left;
    int pR = right;
		
    while (pL < pR) {
      while (A[pL] < v) {
        // increase comparisons
        compQS++; 
        pL++;
      }
      // if A[pL] < v returns false the while loop is not executed, but the comparison is still made, so increase number of comparisons
      compQS++;
      while (A[pR] >= v && pR > left) {
        // increase comparisons
        compQS++;
        pR--;
      }
      // if A[pR] >= v returns false the while loop is not executed, but the comparison is still made, so increase number of comparisons
      compQS++;
			
      // swap elements in the array
      if (pL < pR) {
        int temp = A[pL];
        A[pL] = A[pR];
        A[pR] = temp;
      }
    }
		
    // put pivot in correct position
    int temp = A[pL];
    A[pL] = A[right];
    A[right] = temp;
		
    // return the position of the pivot
    return pL;
  }
	
  // New Sort method
  void newsort() {
    // initialise min value, position and i for looping
    int pos = 0;
    int min;
    int i;
		
    while (pos < usedSize) {
      // find min value
      min = findMinFrom(pos);
      for (i = pos; i < usedSize; i++) {
        // swap elements
        if (A[i] == min) {
          int temp = A[i];
          A[i] = A[pos];
          A[pos] = temp;
          pos++;
        }
        // increase comparisons
        compNS++;
      }
    }
  }
	
  // findMinFrom method
  private int findMinFrom(int pos) {
    int min = A[pos];
    for (int i = pos+1; i < usedSize; i++) {
      // find min value
      if (A[i] < min) {
        min = A[i];
      }
      // increase number of comparisons
      compNS++;
    }
    return min;
  }
}  /** End of Sort Class **/