package lesson19;

public class StayAtHomeIfSick extends Person {

	public StayAtHomeIfSick() {
		super();
	}

	@Override
	public void tryToMove() {
		if (!this.infected) {// move when not sick
			super.tryToMoveRandomly();
		}
	}

}
