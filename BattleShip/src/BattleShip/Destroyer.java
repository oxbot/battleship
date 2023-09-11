package BattleShip;

public class Destroyer extends Ship {

    public Destroyer() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {
        return 'a';
    }
	
	public int getLength() {

        return 1;

    }
}