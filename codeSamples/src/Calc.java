public class Calc
{
    double left = 0;
    double right = 0;

    public Calc(){}

    public Calc( double a, double b)
    {
        this.left = a;
        this.right = b;
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
    }
}