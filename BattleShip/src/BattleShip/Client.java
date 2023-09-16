package BattleShip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
	final String NEWL = System.getProperty("line.separator");
	
	private String name = "Player";
	PrintWriter out = null;
	BufferedReader in = null;
	GameManager man = null;
	GameBoard board = new GameBoard(10,10);
	GameBoard targets = new GameBoard(10,10);

	Scanner scanner;
	
	Client( BufferedReader in, PrintWriter out, GameManager manager )
	{
		this.in = in;
		this.out = out;
		this.man = manager;
	}
	
	public void playGame() throws IOException
	{
		this.out.println( NEWL + NEWL + "   Missiles Away! Game has begun" );
		this.out.println( "   To Launch a missle at your enemy:" );
		this.out.println( "F 2 4" );
		this.out.println( "Fires a missile at coordinate x=2, y=4." );
		
		while(processCommand()) // put Code Here to process in game commands, after each command, print the target board and game board w/ updated state )
		{
			out.println( "------------------------" );
			out.println( "Target Board:" + this.targets.draw() );
			out.println( "Your Ships: " + this.board.draw() );
			out.println( "   Waiting for Next Command...\n\n" );
			out.flush();
			String input = scanner.nextLine();
			
			//Perform test here to see if we have run or lost
		}
	}
	
	//Returns a bool, true iff all of this client's ships are destroyed
	boolean allMyShipsAreDestroyed()
	{
		return false;
	}

	//Returns a bool, true iff all of the opponent's ships are destroyed
	boolean allEnemyShipsAreDestroyed()
	{
		return false;
	}

	//"F 2 4" = Fire command
	//"C Hello world, i am a chat message"
	//"D" - Redraw the latest game and target boards
	boolean processCommand() throws IOException
	{
		return true;
	}
	
	//When a fire command is typed, this method parses the coordinates and launches a missle at the enemy
	boolean processFireCmd( String [] s )
	{
		return true;
	}
	
	//Send a message to the opponent
	boolean processChatCmd( String s )
	{
		return true;
	}
	
	GameBoard getGameBoard() { return this.board; }
	
	public void initPlayer() throws IOException
	{
		//1.Get player name
		out.println("Enter player name: ");
		out.flush();
		//Maybe use the buffer instead of a scanner
		scanner = new Scanner(in);
		
		String input = scanner.nextLine();
		this.name = input;
		//2.Print out instructions
		
		//Here's some nice instructions to show a client		
		out.println("   You will now place 2 ships. You may choose between either a Cruiser (C) " );
		out.println("   and Destroyer (D)...");
		out.println("   Enter Ship info. An example input looks like:");
		out.println("\nD 2 4 S USS MyBoat\n");
		out.println("   The above line creates a Destroyer with the stern located at x=2 (col)," );
		out.println("   y=4 (row) and the front of the ship will point to the SOUTH (valid" );
		out.println("   headings are N, E, S, and W.\n\n" );
		out.println("   the name of the ship will be \"USS MyBoat\"");
		out.println("Enter Ship 1 information:" );
		out.flush();

		
		//Get ship locations from the player for all ships (or more than 2 if you're using more ships)
		//Need to do a ton of error checking and input validation here

		boolean addShipB = false;
		while (!addShipB) {
			input = scanner.nextLine();
			addShipB = this.addShip(input);
			//Check if ship was successfully added
		}

		out.println("Enter Ship 2 information:" );
		out.flush();
		System.out.println("Here");

		addShipB = false;
		while (!addShipB) {
			input = scanner.nextLine();
			addShipB = this.addShip(input);
		}
		
		//After all game state is input, draw the game board to the client

		out.println( "Waiting for other player to finish their setup, then war will ensue!" );
		out.flush();
	}

	boolean addShip(String input) {

		//Need to validate input

		String[] boatInfo = input.split(" ");
		//Take 1 away from input to normalize for 0 indexing
		Position s1 = new Position(Integer.parseInt(boatInfo[1]) - 1, Integer.parseInt(boatInfo[2]) - 1 );
		Ship s = null;
		if (boatInfo[0].equals("D")) {
			//Need to fix boat name getting from the scanner
			s = new Destroyer(boatInfo[4]);
		}
		else if (boatInfo[0].equals("C")) {
			//Need to fix boat name getting from the scanner
			s = new Cruiser(boatInfo[4]);
		}

		HEADING h = null;

		switch (boatInfo[3].toLowerCase()) {
			case "w":
				h = HEADING.WEST;
				break;
			case "s":
				h = HEADING.SOUTH;
				break;
			case "n":
				h = HEADING.NORTH;
				break;
			case "e":
				h = HEADING.EAST;
				break;
			default:
				//Handle this
				break;
			
		}

		return board.addShip(s, s1, h);
	}
	
	String getName() { return this.name; }
	
	public static void main( String [] args )
	{
		
		
	}
}
