import java.math.BigInteger;

public class Message {
    
    public BigInteger message;

    public Message(BigInteger message) {
        super();
        this.message = message;
    }
    
    public Message() {
        super();
    }


    public BigInteger getMessage() {
        return message;
    }

    public void setMessage(BigInteger message) {
        this.message = message;
    }
    
       
    

}
