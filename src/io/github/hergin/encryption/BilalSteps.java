package io.github.hergin.encryption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BilalSteps {
	/**
	 * (2) Compute fi = pi * qi, for 1 <= i <= r.
	 * 
	 * @param List<PrimePair> listOfPairs
	 * @return fi
	 */
	public List<BigInteger> step2(List<PrimePair> listOfPairs) {
		List<BigInteger> fi = new ArrayList<BigInteger>();
		for(PrimePair pair : listOfPairs){
			fi.add(pair.getP().multiply(pair.getQ()));
		}
		return fi;
	}

	/**
	 * (4) Compute d = EulerPhi(N1) function.
	 * http://professorjava.weebly.com/totient.html  works correctly.
	 * 
	 * @param BigInteger n
	 * @return BigInteger
	 */
	public static BigInteger step4(BigInteger num) {
	    int count=0;
	    BigInteger a;
	    for(a = new BigInteger("1"); a.compareTo(num) < 0; a = a.add(BigInteger.ONE)){
	      if(Utils.GCD(num,a).equals(BigInteger.ONE)){ //coprime
	        count++;
	      }
	    }
	    return(new BigInteger(""+count));
	}
	
	/**
	 * (6) Compute N =k^2 p1q1 p2q2 ... pr qr
	 * 
	 * @param BigInteger k, ArrayList<BigInteger> fi
	 * @return N BigInteger
	 */
	public BigInteger step6(BigInteger k, List<BigInteger> fi) {
		BigInteger N = new BigInteger(""+ k.multiply(k));
		for(BigInteger item : fi){
			N = N.multiply(item);
		}

		return N;
	}


	
	
}
