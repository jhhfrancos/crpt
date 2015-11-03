/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jhh
 */
public class PollardRho {
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();
    private ArrayList<Double> factors;
    
    public PollardRho(BigInteger N){
        factors = new ArrayList<Double>();
        factor(N);
    }
    public BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
        } while((divisor.compareTo(ONE)) == 0);

        return divisor;
    }
    public ArrayList<Double> getFactors(){
        return factors;
    }
    public void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(20)) { 
            factors.add(new Double(N.toString())); 
            return; 
        }
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

 
    public static void main(String[] args) {
        String numero = "21944496275174754733023745004748837080297570543729328280448007953824789527038691788660702798145451174453138901351488446979832735450978591612896414872982681198457994802840025058142360791167736098566050165049439180766375815715632675961171034001565824849041810386302038359368560295224574744242597208206082048";
        BigInteger N = new BigInteger(numero);
        PollardRho pollardRho = new PollardRho(N);
        System.out.println(Arrays.toString(pollardRho.getFactors().toArray()));
    }
}