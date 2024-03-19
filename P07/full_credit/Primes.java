import java.util.Random;
import java.util.ArrayList;

import java.math.BigInteger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Primes {
    public static void main(String[] args) {
        int index = 0;
        boolean verbose = false;
        int numPrimes = 1;
        int numFactors = 2;
        
        try (BufferedReader br = new BufferedReader(new FileReader("primes.txt"))) {
            String line = null;
            while((line = br.readLine()) != null) primeNumbers.add(Integer.parseInt(line));
        } catch(IOException e) {
            System.err.println("Error reading primes.txt");
            e.printStackTrace();
            System.exit(-1);
        }
        
        if(args.length == 0 || args[index].equals("-h")) {
            System.out.println("usage: java Primes [-h] [-v] [#factors [#primes]]");
            System.exit(0);
        }
        if(args[index].equals("-v")) {
            verbose = true;
            index++;
        }
        if(index < args.length){
            numFactors = Integer.parseInt(args[index++]);
            if(numFactors < 2) {
                System.err.println("#factors must be 2 or more!");
                System.exit(-2);
            }
        }
        if(index < args.length){
            numPrimes = Integer.parseInt(args[index++]);
            if(numPrimes < 1) {
                System.err.println("#primes must be 1 or more!");
                System.exit(-1);
            }
        }
        for(int primes=0; primes<numPrimes; ++primes) {
            try {
                BigInteger number = new BigInteger("1");
                String sep = "";
                for(int factors=0; factors<numFactors; ++factors) {
                    long factor = primeNumbers.get(random.nextInt(primeNumbers.size()));
                    if(verbose) {
                        System.out.print(sep + factor);
                        sep = " * ";
                    }
                    //number = Math.multiplyExact(number, factor);
                    number = number.multiply(new BigInteger(Long.toString(factor)));
                }
                System.out.println((verbose ? " = " : "") + number);
            } catch(ArithmeticException e) {
                System.err.println("Integer too big: " + e);
            }
        }
    }
    private static Random random = new Random();
    private static ArrayList<Integer> primeNumbers = new ArrayList<>();
}
