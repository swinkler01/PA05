package lesson19;

import java.util.Random;

/**
 * 
 * @author team 14
 *
 */

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS = 1000;

	// private Random random = new Random();

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFlier = Integer.parseInt(args[5]);
		int numPredisposed = Integer.parseInt(args[6]);

		// next we create the population and the country
		MixedPopulation population;

		// population = new Population(numPeople);
		// population = new AllStayAtHome(numPeople);
		// int numEssential = numPeople/10;
		// int numOther = numPeople/20;
		// int numStayHome = numPeople - numEssential - numOther;
		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numPredisposed);
		population.createPeople();

		Country country = new Country(width, height);
		// and add a link to the population in the country
		country.population = population;
		// next we place the people into the country randomly
		population.placePeople(country);

		System.out.println("Initial State of the Country");
		country.printCountry();

		System.out.println("\nTracking the Infection");
		for (int k = 0; k < MAX_TICKS; k++) {
			country.simulateOneStep();
			country.printState(k);

			if (country.numInfected == 0) {
				break;

			}
		}
		System.out.println("\nFinal State of the Country");
		country.printCountry();

	}

}
