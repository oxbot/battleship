package BattleShip;

public class Destroyer extends Ship {

    public Destroyer() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {
        if(isDamaged) {
            return "x";
        }
            return 'd';
    }
	
	public int getLength() {

        return 1;

    }
}