package BattleShip;

public class Cell
{
	protected boolean struckByMissle = false;
	protected Ship ship = null;
	
	public Cell()
	{		
	}
	
	public boolean hasBeenStruckByMissile()
	{
		return false;
	}
	
	public void hasBeenStruckByMissile( boolean wasStruck )
	{	
	}
	
	public char draw()
	{
		if( this.ship != null ){
			return ship.drawShipStatusAtCell(struckByMissle);
		}
		else {
			return '*';
		}
	}
	
	public Ship getShip() { return this.ship; }
	public void setShip( Ship s ) { this.ship = s; }

	public static void main(String[] args)
	{
	}

}
