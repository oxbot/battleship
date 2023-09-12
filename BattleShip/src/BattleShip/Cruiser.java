package BattleShip;

public class Cruiser extends Ship {

    public Cruiser() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {
        if(isDamaged) {
            return "x";
        }
            return 'c';
    }
	
	public int getLength() {

        return 1;

    }

}