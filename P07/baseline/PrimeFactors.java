import java.math.BigInteger; // Big Integers have unlimited precision

import java.util.ArrayList;

// PrimeFactors' constructor factors an arbitrarily large BigInteger 
//     into its prime number factors
class PrimeFactors {
    public PrimeFactors(BigInteger number) {
        this.number = number;
        factors = new ArrayList<>();
        
        for(BigInteger i = new BigInteger("2"); !i.equals(number); i = i.add(BigInteger.ONE)) {
            while(number.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                number = number.divide(i);
            }
            if(number.equals(BigInteger.ONE)) break;
        }
        if(!number.equals(BigInteger.ONE)) factors.add(number);
    }
    // toString prints the equation of prime factors yeilding field "number"
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for(BigInteger bi : factors) {
            sb.append(sep + bi);
            sep = " * ";
        }
        sb.append(" = " + number);
        return sb.toString();
    }
    private BigInteger number;             // The factored number
    private ArrayList<BigInteger> factors; // Prime numbers that comprise number
}

