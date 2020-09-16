abstract public class Animal_Abstract
{
    protected int age = 0;
    protected String name = "";
    protected boolean hasMated = false;

    public Animal_Abstract( String name_in )
    {
        this.name = name_in;        
    }

    abstract public boolean breathe();

    abstract public String communicate();

    public static void main( String [] args )
    {
        System.out.println( "Running Animal Program...");

        // Animal ted = new Animal( "Bill" );
        // if( ted.breathe() )
        //     System.out.println("Feeling refreshed...");

        // Animal b = new Animal( "Ted" );
        // b.communicate(); //communicate(b)
        // a.communicate(); //communicate(a)
    }
}