package BattleShip;

public class Cruiser extends Ship {

    public Cruiser() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {

        if (isDamaged) {
            return 'c';
        }
        else {
            return 'C';
        }
    }
	
	public int getLength() {

        return 4;

    }

}