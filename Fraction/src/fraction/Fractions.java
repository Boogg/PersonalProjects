package fraction;

/**
 *
 * @author Travis Hajagos
 */
public class Fractions {


    public static void main(String[] args) {

        fraction a = new fraction(10,16);
        fraction b = new fraction(1,8);
        
        fraction c;
        
        //Add test. Should equal 3/4
        c = add(a,b);
        printFraction(c);
        
        //subtraction test. Should equal 1/2
        c = subtract(a,b);
        printFraction(c);  
        
        //multiplication test. Should equal 5/64
        c = multiply(a,b);
        printFraction(c);

        //division test. Should equal 5
        c = divide(a,b);
        printFraction(c);
    }

    public static fraction add(fraction X, fraction Y){
           
        fraction Z = new fraction();
        int GCD;
        
        Z.setA( (X.getA()*Y.getB())+(Y.getA()*X.getB()) );
        Z.setB( (X.getB()*Y.getB()));
        do{
            GCD = GCD(Z.getA(), Z.getB());
            Z.setA(Z.getA() / GCD);
            Z.setB(Z.getB() / GCD);
        }while(GCD != 1);
        return Z;
    }
    
    public static fraction subtract(fraction X, fraction Y){
           
        fraction Z = new fraction();
        int GCD;
        
        Z.setA( (X.getA()*Y.getB())-(Y.getA()*X.getB()) );
        Z.setB( (X.getB()*Y.getB()));
        do{
            GCD = GCD(Z.getA(), Z.getB());
            Z.setA(Z.getA() / GCD);
            Z.setB(Z.getB() / GCD);
        }while(GCD != 1);
        return Z;
    }

    public static fraction multiply(fraction X, fraction Y){
        
        fraction Z = new fraction();
        int GCD;
        
        Z.setA( X.getA() * Y.getA());
        Z.setB( X.getB() * Y.getB());
        
        do{
            GCD = GCD(Z.getA(), Z.getB());
            Z.setA(Z.getA() / GCD);
            Z.setB(Z.getB() / GCD);
        }while(GCD != 1);
        return Z;
    }

    public static fraction divide(fraction X, fraction Y){
        
        fraction Z = new fraction();
        int GCD;
        
        Z.setA( X.getA() * Y.getB());
        Z.setB( X.getB() * Y.getA());
        
        
        do{
            GCD = GCD(Z.getA(), Z.getB());
            Z.setA(Z.getA() / GCD);
            Z.setB(Z.getB() / GCD);
        }while(GCD != 1);
        return Z;
    }
    
    public static int GCD(int a, int b){
       
        if(b == 0){
            return a;
        }else{
            return GCD(b,a%b);

        }
    }
    
    public static void printFraction(fraction a){
        if(a.getB() == 1){
            System.out.println(a.getA());
        }else{
            System.out.println(a.getA()+"/"+a.getB());
        }
    }
}
