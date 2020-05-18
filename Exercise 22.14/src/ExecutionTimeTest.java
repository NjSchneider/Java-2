import java.util.Scanner;
/**
 *  Developer:  Nick Schneider
 *  Program:    Exercise 22.14
 *  Purpose:    Write a program that obtains the execution time for finding
 *              all the prime numbers less than 18,000,000 using algorithms
 *              from figure 22.5 - 22.7
 */
public class ExecutionTimeTest 
{
    
    public static void main(String[] args) 
    {
        long[] executionTime = new long[6];        
        
        System.out.println("\t\t8000\t10000\t12000\t14000\t16000\t18000");
        System.out.println("-----------------------------------------------------------------");
        
        // runs through the method that finds the 
        // all the prime numbers up to int n(8000, 100000, 12000, 14000, 16000)
        // Then prints into the table the run time for the algortihm for each
        // value of n.
        for(int i = 0; i < 6; i++)
        {
            long startTime = System.currentTimeMillis();
            prime1(8000 + i * 2000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }        
        System.out.print("Listing 22.5");
        for(int i = 0; i < 6; i++)
        {            
            System.out.print("\t" + executionTime[i] + " ms");
        }
        System.out.println();
        
        // runs through the method that finds the 
        // all the prime numbers up to int n(8000, 100000, 12000, 14000, 16000)
        // Then prints into the table the run time for the algortihm for each
        // value of n.
        for(int i = 0; i < 6; i++)
        {
            long startTime = System.currentTimeMillis();
            prime2(8000 + i * 2000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }
        System.out.print("Listing 22.6");
        for(int i = 0; i < 6; i++)
        {            
            System.out.print("\t" + executionTime[i] + " ms");
        }
        System.out.println();
        
        // runs through the method that finds the 
        // all the prime numbers up to int n(8000, 100000, 12000, 14000, 16000)
        // Then prints into the table the run time for the algortihm for each
        // value of n.
        for(int i = 0; i < 6; i++)
        {
            long startTime = System.currentTimeMillis();
            prime3(8000 + i * 2000);
            executionTime[i] = System.currentTimeMillis() - startTime;
        }
        System.out.print("Listing 22.7");
        for(int i = 0; i < 6; i++)
        {            
            System.out.print("\t" + executionTime[i] + " ms");
        }
        System.out.println();
    }
    
    public static void prime1(int n)
    {
        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        // Repeatedly find prime numbers
        while (number <= n) 
        {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // ClosestPair if number is prime
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) 
            {
                if (number % divisor == 0) // If true, number is not prime
                { 
                  isPrime = false; // Set isPrime to false          
                  break; // Exit the for loop
                }
            }
            // Check if the next number is prime
            number++;
        }
    }
    
    public static void prime2(int n)
    {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot
    
        // Repeatedly find prime numbers
        while (number <= n) 
        {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) squareRoot++;

            // Test whether number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) 
            {
                if (number % list.get(k) == 0) // If true, not prime
                { 
                    isPrime = false; // Set isPrime to false          
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) 
            {
                count++; // Increase the count
                list.add(number); // Add a new prime to the list
            // Check if the next number is prime
            }
            number++;
        }
    }
    
    public static void prime3(int n)
    {
        boolean[] primes = new boolean[n + 1]; // Prime number sieve
    
        long startTime = System.currentTimeMillis();
        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) 
        {
            primes[i] = true; 
        }

        for (int k = 2; k <= n / k; k++) 
        {
            if (primes[k]) 
            {
                for (int i = k; i <= n / k; i++) 
                {
                primes[k * i] = false; // k * i is not prime
                }
            }
        }
    }
}
