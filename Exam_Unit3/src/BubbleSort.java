
/**
 *  Developer:  Nick Schneider
 *  Purpose:    Bubble Sort
 */
public class BubbleSort 
{
    protected static long sort(int[] list) 
    {
        long startTime = System.currentTimeMillis();
        boolean needNextPass = true;
    
        for (int k = 1; k < list.length && needNextPass; k++) 
        {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) 
            {
                if (list[i] > list[i + 1]) 
                {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;          
                    needNextPass = true;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        return executionTime;
    }
}
