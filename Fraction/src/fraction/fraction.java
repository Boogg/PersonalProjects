package fraction;

/**
 *
 * @author Travis Hajagos
 */
public class fraction {
    
    private int a, b;
    
    fraction(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    fraction(){
        this.a = 0;
        this.b = 0;
    }
    
    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return this.a;
    }
    public void setB(int b){
        this.b = b;
    }
    public int getB(){
        return this.b;
    }
    


    
    
}
