public class Animal
{
    protected int age = 0;
    protected String name = "";
    protected boolean hasMated = false;

    public Animal( String name_in )
    {
        this.name = name_in;        
    }

    public boolean breathe()
    {
        System.out.println("undering respiration");
        return false;
    }

    public String communicate()
    {
        return this.name + " is communicating";
    }

    public static void main( String [] args )
    {
        System.out.println( "Running Animal Program...");

        Animal ted = new Animal( "Bill" );
        if( ted.breathe() )
            System.out.println("Feeling refreshed...");

        Animal b = new Animal( "Ted" );
        b.communicate(); //communicate(b)
    }
}