package lesson19;

public class Skeptic extends Person {

	public Skeptic() {
		super();
	}

	@Override
	public void tryToMove() {
		// move every tick
		super.tryToMoveRandomly();
	}

}
