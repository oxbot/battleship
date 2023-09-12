package BattleShip;

public class Destroyer extends Ship {

    public Destroyer() {
        super();
    }

    public char drawShipStatusAtCell( boolean isDamaged ) {

        if (isDamaged) {
            return 'd';
        }
        else {
            return 'D';
        }
    }
	
	public int getLength() {

        return 3;

    }
}