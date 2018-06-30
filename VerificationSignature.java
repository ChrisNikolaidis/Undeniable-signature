import java.math.BigInteger;

public class VerificationSignature {
    
    public BigInteger Challenge(BigInteger s, BigInteger b, BigInteger p, int e1, int e2){
        
        BigInteger c = new BigInteger("0");        
        c = s.pow(e1).multiply(b.pow(e2)).mod(p);
        //b = b.pow(e2);
        //c = s.multiply(b).mod(p);
        return c;
        
    }
    
    
    public BigInteger Response(BigInteger c, BigInteger a, BigInteger q, BigInteger p){
                
        BigInteger d = new BigInteger("0");
        d = c.modPow(a.modInverse(q), p);
        return d;
        
    }
    
    
    public boolean Verify(BigInteger m, BigInteger d, BigInteger g, BigInteger p, int e1, int e2) {
        
        if(d.equals(m.pow(e1).multiply(g.pow(e2)).mod(p))){
            return true;
        }else{
            return false;
        }
    
    
    }

    

}
