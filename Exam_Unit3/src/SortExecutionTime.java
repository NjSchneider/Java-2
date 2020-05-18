import java.util.Random;
/**
 *  Developer:  Nick Schneider
 *  Program:    Exam3_Hands-On
 *  Purpose:    Write a program that obtains the execution time of selection
 *              sort, radix sort, bubble sort, merge sort, quick sort, and heap
 *              sort for input size 50000, 100,000, 150,000, 200,000, 250,000,
 *              and 300,000.
 */
public class SortExecutionTime 
{
    static Random rand = new Random();    
    static int size = 50000;
    
    static int[] test = new int[size];

    public static void main(String[] args) 
    {
        System.out.println("ArraySize|\tSelection Sort\t   Radix Sort"
                + "\t    Bubble Sort\t    Merge Sort\t    Quick sort\t    Heap Sort");
        System.out.println("------------------------------------------"
                + "---------------------------------------------------------------------------");
        while(size <= 300000)
        {            
            for(int i = 0; i < test.length; i++)
            {
                test[i] = rand.nextInt(55 - 5) +1;        
            }
            int[] test2 = test.clone();
            int[] test3 = test.clone();
            int[] test4 = test.clone();
            int[] test5 = test.clone();
            int[] test6 = test.clone();

            System.out.println(size + "\t |" + "\t\t"+ SelectionSort.sort(test) + "ms\t\t" +
                RadixSort.sort(test2) + "ms\t\t" + BubbleSort.sort(test3) + "ms\t\t" + 
                MergeSort.sort(test4) + "ms\t\t" + QuickSort.sort(test5) + "ms\t\t" +
                HeapSort.sort(test6) + "ms");
            
            size += 50000;
        }
    }
    
}
