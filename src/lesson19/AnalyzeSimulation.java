package lesson19;

public class AnalyzeSimulation {
	private static int MAX_TICKS = 1000;
	
	public static void main(String[] args) { // use code base of RunSimulation to a set number of simulations 
	int width = Integer.parseInt(args[0]);
	int height = Integer.parseInt(args[1]);
	int numStayHome = Integer.parseInt(args[2]);
	int numEssential = Integer.parseInt(args[3]);
	int numSkeptic = Integer.parseInt(args[4]);
	int numFrequentFlier = Integer.parseInt(args[5]);
	int numPredisposed = Integer.parseInt(args[6]);
	int numRuns = Integer.parseInt(args[7]);
	int currentRun = 1; // this will be each individual simulation
	int totalnumofDays = 0; // this will eventually go to the average number of Days
	int averagenumInfected = 0; // this will eventually go to the average number of infected
	int totalnumInfected = 0; // this is the total infected
	
	while(currentRun < numRuns+1) { 
		MixedPopulation population; //following will initiate the current simulation  

		population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numPredisposed);
		population.createPeople();
		Country country = new Country(width, height);
		country.population = population;
		population.placePeople(country);      // the same as the RunSimulation class
		
		int numofDays = 0; // will eventually output number of days till no one is infected 
		int newnumInfected = country.numInfected;   //will initiate the number of infected originally 
		
		for (int k = 0; k < MAX_TICKS; k++) {
			country.simulateOneStep();
			totalnumofDays++;
			if(newnumInfected < country.numInfected) { // if statement will return highest number of Infected during that simulation
				newnumInfected = country.numInfected;
			}
			totalnumInfected += country.numInfected;
			
			if (country.numInfected == 0) { //ends the simulation 
				totalnumofDays++;
				numofDays = k;
				break;
			}
		}
		
		averagenumInfected += newnumInfected; // will return the average number of Infected 
		
		System.out.println("Simulation: "+currentRun+  // will print the simulation number, number of days, highest number of Infected, and total number of infected 
				"	  Number of Days: " + numofDays + 
				"	Highest Number of Infected: " + newnumInfected + "	Total Number of Infected: " + totalnumInfected);
		
		currentRun++; // is for the while loop 
		totalnumInfected = 0; //resets total number of infected for next simulation 
	}
	int averagenumofDays = totalnumofDays/numRuns; // returns mean of Days
	averagenumInfected = averagenumInfected/numRuns; // returns mean of Infected
	System.out.println("\nAverage number of Days: "+ averagenumofDays); //Prints mean of Days
	System.out.println("Average number of Infected: "+ averagenumInfected); // Prints mean of Days 
	}
}
