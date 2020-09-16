public class Dog extends Animal
//public class Dog extends Animal_Abstract
{
    public Dog()
    {
        super("Dog");    
    }

    @Override
    public String communicate()
    {
        return super.communicate() + "\n" + "\"Bark\" says " + this.name; //for non-abstract inheritance
        //return "\"Bark\" says " + this.name;                              //for abstract inheritance
    }

    @Override
    public boolean breathe() //must be defined when abstract; otherwise does not need to be defined and implemented here
    {
        return true;
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