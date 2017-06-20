import java.math.BigInteger;
import java.util.Scanner;

public class KeyGeneration {
    
    public BigInteger p; // prime number
    public BigInteger q; // prime number
    public BigInteger g; // generator of q
    public BigInteger a; // random number private key
    public BigInteger b; // b = g^a mod p
    
        
   public KeyGeneration(BigInteger p, BigInteger q, BigInteger g, BigInteger a, BigInteger b) {
        super();
        this.p = p;
        this.q = q;
        this.g = g;
        this.a = a;
        this.b = b;
    }


   public BigInteger getP() {
        return p;
    }


   public void setP(BigInteger p) {
        this.p = p;
    }


   public BigInteger getQ() {
        return q;
    }


   public void setQ(BigInteger q) {
        this.q = q;
    }


   public BigInteger getG() {
        return g;
    }


   public void setG(BigInteger g) {
        this.g = g;
    }


   public BigInteger getA() {
        return a;
    }


   public void setA(BigInteger a) {
        this.a = a;
    }


   public BigInteger getB() {
        return b;
    }


   public void setB(BigInteger b) {
        this.b = b;
    }


    public boolean isPrime(int n) {
        int i;
        for (i=2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public BigInteger getGenerator(BigInteger p, BigInteger q){
        BigInteger generator = BigInteger.ZERO;
        BigInteger exp = p.subtract(BigInteger.ONE).divide(q);
        for(int i=2;i<p.intValue()-1;i++) {
            generator = BigInteger.valueOf(i);
            generator = generator.modPow(exp, p);
            if(!generator.equals(BigInteger.ONE)) return generator;
        }
        
        return generator; 
    }    
    
    public void KeyGeneration() {

        int primeNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Undiniable Signatures");
        System.out.print("\tGive the first prime number p: ");        
        primeNumber= sc.nextInt();
                
        while (!isPrime(primeNumber)) {
            System.out.println("Invalid prime number, please try again");
            System.out.print("\tEnter prime P : ");
            primeNumber = sc.nextInt();    
        }         
        
        p = BigInteger.valueOf(primeNumber); // set first prime number 
        setP(p);
        System.out.println("Prime p is:" + p);        
        Integer qInt = (primeNumber - 1)/2;  // set second prime number
        BigInteger q = BigInteger.valueOf(qInt.intValue()); 
        setQ(q);
        g = getGenerator(p,q); //randomNumber
        setG(g);
        System.out.println("Prime q is:" + q);
        System.out.print("\tEnter private key a (belongs to Z*q) :");
                
        //choose private key 
        int privateKey = sc.nextInt();  
              
        while(privateKey <= 0 || privateKey >= q.intValue() ) {
            System.out.println("Invalid private key selected, please try again.");
            System.out.print("\tEnter private key a (belongs to Z*q) :");
            privateKey = sc.nextInt();
        }   
        
        BigInteger a = BigInteger.valueOf(privateKey);
        setA(a);
        b = g.modPow(a,p);
        setB(b);
        System.out.println("The Public key is [p, g, b] " + "[" + p + "]" + "[" + g + "]" + "[" + b + "]");
        
        System.out.println("The Secret key is [a] " + "[" + a + "]");
    }

    
    public void VerifySinature() {
        
    }
    
    
    public void DisavowalProtocal() {
        // disavowal protocol
    }
    
    
    
    
}
