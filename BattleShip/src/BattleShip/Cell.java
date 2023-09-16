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
		return struckByMissle;
	}
	
	public void hasBeenStruckByMissile( boolean wasStruck )
	{	
		struckByMissle  = wasStruck;
	}
	
	public char draw()
	{
		if( this.ship != null ){
			return ship.drawShipStatusAtCell(struckByMissle);
		}
		else if (this.ship == null && hasBeenStruckByMissile()) {
			//this case should only be true for the target board after a successful hit
			return 'X';
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
