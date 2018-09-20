package lab3;

import cse131.ArgsProcessor;

public class Dice {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numDice = ap.nextInt("How many dice?");
		int numSimu = ap.nextInt("How many simulations?");
		int[] arr = new int[numDice];
		int numSame = 0;
		int[][] sumAndTimes = new int[numDice*6-numDice+1][2];

		for(int m=numDice; m<=numDice*6; m++) {
			sumAndTimes[m-numDice][0] = m;
		}

		for(int j=0; j<numSimu; j++) { //number of the simulation
			int sum = 0;
			boolean same = true; //initialize a boolean to check if each dice in a simulation is the same
			for (int i=0; i < numDice; i++) { //number of the dice in each simulation
				int rollDice = (int) (Math.random()*6+1); //generate the value from 1 to 6
				arr[i] = rollDice; //store the value to the array stored
				for (int k=1; k<=i;k++) { //check if the value of each dice is the same
					if(arr[0] != arr[k]) {
						same = false; 
					}
				}
				sum = rollDice + sum;
			}
			if(same == true) {
				numSame++;
			}
			for(int l=0; l<sumAndTimes.length; l++) {
				if (sumAndTimes[l][0] == sum) {
					sumAndTimes[l][1] = sumAndTimes[l][1]+1;
				}
			}
		}
		System.out.println("Sum" + "\t" + "Number of times " + "\t" + "% of number of times");
		System.out.println("\t Sum was seen\t\t Sum was seen");
		for(int o = 0; o<sumAndTimes.length;o++) {
			if (sumAndTimes[o][1] != 0) {
				System.out.println(sumAndTimes[o][0] + "\t\t"+ sumAndTimes[o][1] +"\t\t\t" + (double)Math.round(((double)sumAndTimes[o][1]/numSimu)*1000)/10 +"%");
			}
		}
		System.out.println();
		System.out.println("The ratio of all dice are the same is: " + (double)Math.round((numSame/ (double)numSimu)*1000)/10 + "%");
	}
}