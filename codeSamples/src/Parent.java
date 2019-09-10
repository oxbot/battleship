public class Parent
{
   public Parent()
   {
      System.out.println( "Hello World from Parent...");
   }

   public String talk()
   {
      return "I say I am the parent...";
   }
   protected String whisper() { return "shhh..."; }

   public static void main( String [] args )
   {
      Parent p = new Parent();
      Child c = new Child();
      System.out.println( p.talk() );
      System.out.println( c.talk() );
   }

}

class Child extends Parent
{
   public Child()
   {
      super();
   }

   @Override
   public String talk() {
      String s = super.talk();
      s += " says the child...";
      return s;
   }
}