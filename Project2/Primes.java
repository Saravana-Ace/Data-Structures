import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 *
 * @author Charles Hoot
 * @version 4.0
 */


public class Primes {

    public static void main(String args[]) {

        int max;

        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");

        ListInterface<Integer> candidates = new AList<Integer>(max);
        ListInterface<Integer> primes = new AList<Integer>(max);
        ListInterface<Integer> composites = new AList<Integer>(max);
        int prime = 0;

        for(int i = 2; i <= max; i++)
            candidates.add(i);

        System.out.print("These are the candidates: ");
        System.out.println(candidates);

        prime = candidates.remove(1);
        System.out.println("Prime discovered: " + prime);
        primes.add(prime);

        getComposites(candidates, composites, prime);

        System.out.print("These are the candidates: ");
        System.out.println(candidates);

        System.out.print("These are the prime numbers: ");
        System.out.println(primes);

        System.out.print("These are the composite numbers: ");
        System.out.println(composites);

//        for(int i = 1; i <= candidates.getLength(); i++) {
//            System.out.print(candidates.getEntry(i) + " ");
//        }
//        System.out.println();
//
//        for(int i = 2; i < max; i++) {
//            for(int j = 2; j < 9; j++) {
//                if(i % j == 0 && (j != i)) {
//                    counter++;
//                }
//            }
//
//            if(counter == 0) {
////                prime = candidates.getEntry(i);
////                candidates.remove(i);
////                System.out.println("Prime discovered: " + prime);
//                primes.add(i);
//            }
//
//            counter = 0;
//        }

    }


    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime) {
        for(int i = 1; i <= candidates.getLength(); i++) {
            if(candidates.getEntry(i) % prime == 0 && i != prime) {
                composites.add(candidates.remove(i));
            }
        }
    }




    /**
     * Get an integer value.
     *
     * @return     An integer.
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;

    }

}
