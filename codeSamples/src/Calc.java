//import MyCalc.PCalc;
public class Calc
{
    static int uniqueID = 0;
    int id = 0;
    double left = 0;
    double right = 0;

    public Calc(){
        id = uniqueID;//unique value
        uniqueID++;
    }

    public Calc( double a, double b)
    {
        this();
        this.left = a;
        this.right = b;
    }

    public String toString()
    {
        String val = "My id is " + this.id + ". Operands are " + this.left + ", " + this.right;
        return val;
    }

    double mult( double a, double b )
    {
        return a * b;
    }

    double mult()
    {
        return this.left * this.right;
    }

    double add( double a, double b)
    {
        return a + b;
    }

    public static void main( String [] args )
    {
        System.out.println( "Hello world..." );
        Calc c = new Calc(8,8);
        //double product = c.mult( 7, 7 );
        double cp = c.mult();
        Calc d = new Calc(7,7);
        double dp = d.mult();
        System.out.println( "Product is " + cp );
        System.out.println( "Product is " + dp );

        System.out.println( c.toString() );
        System.out.println( d.toString() );

        // PCalc pc = new PCalc(2,4);
        // pc.left = 5;
        // double prod = pc.mult();
        // System.out.println( "Product is " + prod );

        float a = (float)4;
        float b = (float)4.000001;
        if( a == b )
            System.out.println( "a==b" );
        else
            System.out.println( "a!=b" );

        if( Math.abs( a-b ) < 0.001 )
            System.out.println( "a is close to b" );
    }
}