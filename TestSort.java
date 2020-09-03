
/******************************************************/
/***       Simple test class for Sort class         ***/
/***                                                ***/
/***   Author: Dominykas Mickevicius  30/10/2019    ***/
/******************************************************/


public class TestSort {
  public static void main(String[] args) {

    /* initialise multiple Sort objects for quicker testing (to allow each sort algorithm execute at once) 
       and specify array size based on the number of elements in the text file */
    Sort sortTest = new Sort(1000);
    Sort sortTest2 = new Sort(1000);
    Sort sortTest3 = new Sort(1000);
        
    // number of the text file used for the input (change the value of fileNumber to select different file)
    int fileNumber = 1;
        
    /* Read in test data into array */
    sortTest.readIn("C:\\Users\\Dominykas\\Desktop\\studentFiles\\test" + fileNumber + ".txt");
    sortTest2.readIn("C:\\Users\\Dominykas\\Desktop\\studentFiles\\test" + fileNumber + ".txt");
    ortTest3.readIn("C:\\Users\\Dominykas\\Desktop\\studentFiles\\test" + fileNumber + ".txt");
        
        
    /* Testing of the insertion methods. */
        
    // if test1.txt is used as an input print the unsorted and sorted arrays
    if (fileNumber == 1) {
      // display the unsorted array before insertion sort
      sortTest.display(15, "Unsorted values in the array before insertion sort");
      // insertion sort test
      sortTest.insertion();
      // display the array after the insertion sort
      sortTest.display(15,"\nValues in test1.txt after insertion sort");
      // display number of comparisons for insertion sort
      System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
	         
      System.out.println("\n===========================================================");
	        
      // display the unsorted array before QuickSort
      sortTest2.display(15, "Unsorted values in the array before QuickSort");
      // QuickSort test
      sortTest2.quicksort(0, sortTest2.getUsedSize() - 1);
      // display the array after the QuickSort
      sortTest2.display(15,"\nValues in test1.txt after QuickSort");
      // display number of comparisons for QuickSort
      System.out.println("\n\nQuickSort comparison counter: " + sortTest2.compQS);
	         
      System.out.println("\n===========================================================");
	         
      // display the unsorted array before NewSort
      sortTest3.display(15, "Unsorted values in the array before NewSort");
      // NewSort test
      sortTest3.newsort();
      // display the array after the NewSort
      sortTest3.display(15,"\nValues in test1.txt after NewSort");
      // display number of comparisons for NewSort
      System.out.println("\n\nNewSort comparison counter: " + sortTest3.compNS);
    }
        
    // if the input file is not test1.txt output the number of comparisons
    else {
      // insertion sort test
      sortTest.insertion();
      // display number of comparisons for insertion sort
      System.out.println("Insertion sort comparison counter: " + sortTest.compIS);
      System.out.println("===========================================================");
            
      // QuickSort test
      sortTest2.quicksort(0, sortTest2.getUsedSize() - 1);
      // display number of comparisons for QuickSort
      System.out.println("QuickSort comparison counter: " + sortTest2.compQS);
      System.out.println("===========================================================");
	        
      // NewSort test
      sortTest3.newsort();
      // display number of comparisons for NewSort
      System.out.println("NewSort comparison counter: " + sortTest3.compNS);
    }
  }
} /** End of TestSort class **/
