import java.math.BigInteger;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String msgFilename, signatureFilename, message;
        KeyGeneration kg = new KeyGeneration(null, null, null, null, null);
        VerificationSignature vs = new VerificationSignature();
        kg.KeyGeneration();
        Message ms = new Message();
        Message sm = new Message();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("- OPERATIONS");
            System.out.println("\t1. Sign message");
            System.out.println("\t2. Verify signature");
            System.out.println("\t3. Disavowal protocal");
            System.out.println("\t4. Exit");
            System.out.print("\tChoice : ");
            choice = sc.nextInt();
            System.out.println();
            switch(choice) {
                case 1:
                    System.out.println("- MESSAGE SIGNING");
                    System.out.print("\tEnter message: ");                    
                    int message1 = sc.nextInt();
                    ms.setMessage(BigInteger.valueOf(message1));
                    BigInteger m1 = BigInteger.valueOf(message1);
                    BigInteger a = kg.getA();                                        
                    //System.out.println(a);
                    BigInteger signMessage = m1.modPow(kg.getA(), kg.getP());
                    sm.setMessage(signMessage);
                    System.out.println("The message is: " + message1);
                    System.out.println("The signature of message is: " + signMessage);
                                        
                break;
                case 2:
                    System.out.println("- SIGNATURE VERIFICATION");
                    System.out.print("\tEnter message filename : ");
                    System.out.println("Bob pick two random numbers");
                    int randomA = 55;
                    int randomB = 105;
                    System.out.println("The numbers are: " + "a: " + randomA + " b: " + randomB);
                    BigInteger challengeC = vs.Challenge(sm.getMessage(), kg.getB(), kg.getP(), randomA, randomB);
                    System.out.println("The challenge is : " + challengeC);
                    BigInteger responceD = vs.Response(challengeC, kg.getA(), kg.getQ(), kg.getP());
                    System.out.println("The response is : " + responceD);
                    boolean verification = vs.Verify(ms.getMessage(), responceD, kg.getG(), kg.getP(), randomA, randomB);                   
                    if (verification){
                        System.out.println("true");
                    } else{
                        System.out.println("false");
                    }
//                    
                break;
                case 3:
//                    
                case 4:
                    System.out.println("- BYE BYE");
                break;
            }
        } while(choice!=4);
    }

}
