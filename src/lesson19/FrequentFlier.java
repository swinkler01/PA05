package lesson19;

import java.util.Random;

public class FrequentFlier extends Person{
	
	private Random random = new Random();
	
	public FrequentFlier() {
		super();
	}

	
	@Override
	public void tryToMove() {
		// jump to a random, unoccupied space on the board
		// find an open random space for the person
	    int i = random.nextInt(this.country.places.length);
	    int j = random.nextInt(this.country.places[i].length);
	    while (this.country.places[i][j] != null) {
	        // loop to make sure it is an open space ...
	        i = random.nextInt(this.country.places.length);
	        j = random.nextInt(this.country.places[i].length);
	    }

	    this.moveTo(i, j);

	}

}
