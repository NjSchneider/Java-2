
/**
 *  Developer:  Nick Schneider
 *  Purpose:    Selection Sort
 */
public class SelectionSort 
{
    protected static long sort(int arr[])
    {
        long startTime = System.currentTimeMillis();
        int n = arr.length;
 
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        return executionTime;
    }
}
