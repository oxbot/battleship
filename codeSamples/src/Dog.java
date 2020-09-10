public class Dog extends Animal
{
    public Dog()
    {
        super("Dog");    
    }

    @Override
    public String communicate()
    {
        return super.communicate() + "\n" + "\"Bark\" says " + this.name;
    }

    public static void main( String [] args )
    {
        System.out.println( "Dog" );

        Dog d = new Dog();
        d.breathe();
        System.out.println( d.communicate() );
        d.name = "Nash_the_dog";
        System.out.println( d.communicate() );

    }
}