
/**
 *  Developer:  Nick Schneider
 *  Purpose:    Radix Sort
 */
public class RadixSort 
{
    protected static long sort( int[] a)
    {
        long startTime = System.currentTimeMillis();
        int i, m = a[0], exp = 1;
        int[] b = new int[a.length];
        for (i = 1; i < a.length; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < a.length; i++)
            {
                bucket[(a[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++)
            {
                bucket[i] += bucket[i - 1];
            }
            for (i = a.length - 1; i >= 0; i--)
            {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (i = 0; i < a.length; i++)
            {
                a[i] = b[i];
            }
            exp *= 10;        
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        return executionTime;
    }
}
