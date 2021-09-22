import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetExample
{
   private ServerSocket listener = null;
   BufferedReader input_from_client = null;
   PrintWriter out_to_client = null;

   public NetExample(){}

   public void waitForConnect() throws IOException
   {
      try
		{
		    this.listener = new ServerSocket( 10000 );
		    {
		    	Socket clientSocket = listener.accept();
            this.out_to_client = new PrintWriter( clientSocket.getOutputStream(), true );
            this.input_from_client = new BufferedReader( new InputStreamReader(clientSocket.getInputStream() ) );
            System.out.println( "A client has joined..." );
            out_to_client.println( "           ...Welcome to my echo server..." ); 
		    }
		}
		finally
		{
			System.out.println( "Done listening for client to join into Echo server..." );
		}
   }

   public void echoClientInput() throws IOException
   {
      String s = "";
      while(! s.equals("Q") )
      {
         s = this.input_from_client.readLine();
         System.out.println(s);
      }
   }

   public static void main( String [] args )
   {
      NetExample n = new NetExample();
      try
      {
         n.waitForConnect();
         n.echoClientInput();
      }
      catch( Exception e )
      {
         System.out.println( e.toString() );
      }


   }
}