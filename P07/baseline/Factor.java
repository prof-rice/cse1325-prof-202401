import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.math.BigInteger; // Big Integers have unlimited precision

/* 
Candidate BigInteger values that may factor with reasonable runtimes.
Times in first column are seconds on my workstation Antares.

  ===> Your times WILL vary!

Select from 10 to as many BigInteger values as needed 
(duplicates ARE permitted) so that all factors 
take 30 to 60 seconds to complete on YOUR machine!

This will require some experimentation.

 0.2  409691109030485036291142
 0.4      12341983591308976832
 0.4      12341983591308976837
 0.5  204889445540633809438884
 0.6    2633022111220424607114
 0.6       3810102159721699814
 0.7  149003965211066359426480
 0.8     478713804955782741640
 0.8     140136045666459146415
 0.9  409691109030485036291143
 1.3      12341983591308976836
 2.0  103667773739245279036781
 2.1   38792691073186584079541
 2.2   23335073960029527159947
 2.6  115342773083375138441712
 2.6   89615432828121443469269
 2.7     140136045666459146416
 3.3    8726382779747718874005
 4.2  409691109030485036291146
 4.2   38792691073186584079549
 4.4     140136045666459146419
 5.2   33114517270146193529599
 5.7     478713804955782741648
 6.2   63344881422295125590326
 9.1   20775267678000292221185
10.0       3810102159721699813
10.2   38792691073186584079546
10.4    8726382779747718874000
11.4    8726382779747718874009
13.5       3810102159721699810
20.5   27994469914805964713410
*/

public class Factor {
    public static List<PrimeFactors> solutions = new ArrayList<>();
    public static String[] bigints = null; // From main's args
    public static int numThreads = 1; 
    
    public static void main(String[] args) {
        // Validate program arguments
        if(args.length < 2 || args[0].equals("-h")) usage();

        // Parse number of threads and the big integers array
        try {
            numThreads = Integer.parseInt(args[0]);
            bigints = Arrays.copyOfRange(args, 1, args.length);
        } catch(NumberFormatException e) {
            numThreads = 1;
            bigints = args;
        }

        // Factor all of the big integers
        solve(0, 0, bigints.length); 

        // Print all solutions
        for(PrimeFactors solution : solutions)
            System.out.println(solution);
    }

    // Solve bigints[firstIndex] to bigints[lastIndex-1]
    // Add PrimeFactors solution objects to the solutions ArrayList
    // threadNumber will just identify threads with a loop counter, 0 to numThreads-1
    public static void solve(int threadNumber, int firstIndex, int lastIndexPlusOne) {
        System.out.println("Thread " + threadNumber + " solving " 
                         + firstIndex + "-" + (lastIndexPlusOne-1));
        for(int i=firstIndex; i<lastIndexPlusOne; ++i) {
            try {
                PrimeFactors pf = new PrimeFactors(new BigInteger(bigints[i]));
                solutions.add(pf);
            } catch (Exception e) {
                System.err.println("Failed to solve " + bigints[i] + ": " + e);
            }
        }
    }

    // Show program usage and exit
    public static void usage() {
        System.err.println("usage: java Factor [#threads] bigint [bigint...]");
        System.err.println("       See Factor.java for some suggested bigint values");
        System.exit(-1);
    }
}
