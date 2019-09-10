public class Regex
{
   public static void main( String [] args )
   {
      //String input = "hello world, how    are   you today?\n I am good...";
      String input = "12, 34.21,  987.23  adf -232.1 ";

      System.out.println( input );

      String [] ss = input.split( "(\\s|,)+" );
      //String [] ss = input.split( "[0-9]+" );

      for( int i = 0; i < ss.length; ++i )
      {
         System.out.print(i + ": " + ss[i]);
         System.out.println( "   - is floating point? " + ss[i].matches("[-+]?[0-9]*\\.?[0-9]*.") );
      }
   }
}