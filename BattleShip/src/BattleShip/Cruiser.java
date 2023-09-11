package BattleShip;

public class Cruiser extends Ship {

    public Cruiser() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {
        return 'a';
    }
	
	public int getLength() {

        return 1;

    }

}