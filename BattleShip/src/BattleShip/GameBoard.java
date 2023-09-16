package BattleShip;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GameBoard
{
	int rowCount = 10;
	int colCount = 10;
	
	final String LINE_END = System.getProperty("line.separator"); 
	
	ArrayList< ArrayList< Cell > > cells;
	ArrayList< Ship > myShips = new ArrayList<Ship>();
	
	public GameBoard( int rowCount, int colCount )
	{
		cells = new ArrayList< ArrayList< Cell > >();
		this.rowCount = rowCount;
		this.colCount = colCount;
		
		//create the 2D array of cells
		for (int i = 0; i < this.rowCount; i++) {
			ArrayList< Cell > cellRow = new ArrayList< Cell >();
			for (int j = 0; j < this.colCount; j++) {
				Cell cell = new Cell();
				cellRow.add(cell);
			}
			cells.add(cellRow);
		}
	}
	
	public String draw()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\n*----------*\n");
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount + 2; j++) {
				if (j == 0) {
					sb.append("|");
				}
				else if (j == colCount + 1) {
					sb.append("|\n");
				}
				else {
					sb.append(this.cells.get(i).get(j-1).draw());
				}
			}
		}
		sb.append("*----------*\n");
		//draw the entire board... I'd use a StringBuilder object to improve speed
		//remember - you must draw one entire row at a time, and don't forget the
		//pretty border...
		return sb.toString();
	}
	
	//add in a ship if it fully 1) fits on the board and 2) doesn't collide w/
	//an existing ship.
	//Returns true on successful addition; false, otherwise
	public boolean addShip( Ship s , Position sternLocation, HEADING bowDirection )
	{
		//Check if fits on board
		//check if collides with other ship
		
		ArrayList<Cell> shipLoc = new ArrayList<Cell>();

		//Different loops depending on ship heading, if there's issues with ship putting need to check this
		if (bowDirection == HEADING.SOUTH) {
			for (int i = sternLocation.y; i < sternLocation.y + s.getLength(); i++){
				cells.get(i).get(sternLocation.x).setShip(s);
				shipLoc.add(cells.get(i).get(sternLocation.x));
			}
		}
		else if (bowDirection == HEADING.NORTH) {
			for (int i = sternLocation.y; i > sternLocation.y - s.getLength(); i--){
				cells.get(i).get(sternLocation.x).setShip(s);
				shipLoc.add(cells.get(i).get(sternLocation.x));
			}
		}
		else if (bowDirection == HEADING.EAST) {
			for (int i = sternLocation.x; i < sternLocation.x + s.getLength(); i++){
				cells.get(sternLocation.y).get(i).setShip(s);
				shipLoc.add(cells.get(sternLocation.y).get(i));
			}
		}
		else if (bowDirection == HEADING.WEST) {
			for (int i = sternLocation.x; i > sternLocation.x - s.getLength(); i--){
				cells.get(sternLocation.y).get(i).setShip(s);
				shipLoc.add(cells.get(sternLocation.y).get(i));
			}
		}
		s.setPosition(shipLoc);
		myShips.add(s);
		return true;
	}
	
	//Returns A reference to a ship, if that ship was struck by a missle.
	//The returned ship can then be used to print the name of the ship which
	//was hit to the player who hit it.
	//Ensure you handle missiles that may fly off the grid
	public Ship fireMissle( Position coordinate )
	{
		Cell cell = cells.get(coordinate.y).get(coordinate.x);

		if (cell.getShip() != null ) {
			if (cell.hasBeenStruckByMissile()) {
				//should I do something if a ship was already struck at this location?
			}
			else {
				cell.hasBeenStruckByMissile(true);
				return cell.getShip();
			}
		}
		return null;
	}
	
	//Here's a simple driver that should work without touching any of the code below this point
	public static void main( String [] args )
	{
		System.out.println( "Hello World" );
		GameBoard b = new GameBoard( 10, 10 );	
		System.out.println( b.draw() );
		
		Ship s = new Cruiser( "Cruiser" );
		if( b.addShip(s, new Position(3,6), HEADING.WEST ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		s = new Destroyer( "Vader" );
		if( b.addShip(s, new Position(3,5), HEADING.NORTH ) )
			System.out.println( "Added " + s.getName() + "Location is " );
		else
			System.out.println( "Failed to add " + s.getName() );
		
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(3,5) );
		System.out.println( b.draw() );
		b.fireMissle( new Position(3,4) );
		System.out.println( b.draw() );
		b.fireMissle( new Position(3,3) );
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(0,6) );
		b.fireMissle( new Position(1,6) );
		b.fireMissle( new Position(2,6) );
		b.fireMissle( new Position(3,6) );
		System.out.println( b.draw() );
		
		b.fireMissle( new Position(6,6) );
		System.out.println( b.draw() );
	}

}
