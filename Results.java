public class Results {  
	
	private SchellingSimulator simulator;
	
	public int repVote = 0;
	public int demVote = 0;

	/*
	 * This function calculates the winner for each state and then updates the total scores. 
	 * @param x1 starting width position
	 * @param x2 end width position ~ add later
	 * @param y1 starting height position
	 * @param y2 end height position ~ add later
	 * @param allocatedVotes - number of electoral votes
	 * */
	public void election(int x1, int x2, int y1, int y2, int allocatedVotes) {
		int red = 0;
		int blue = 0;
		int other = 0;
		// Iterates through grid region for state and adds up votes for state
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				int label = simulator.getGrid(x, y);

				if (label == 1) {
					blue += 1;
				} else if (label == 2) {
					red += 1;
				} else if (label == 3) {
					other += 1; 
			    } else {
			    	other += 0;
				}
			}
		}
		// decides the winner of the state and adds to the electoral vote count
		if (red > blue && red > other) {
			repVote += allocatedVotes;
		} else if (blue > red && blue > other) {
			demVote += allocatedVotes;
		} else {
			other += allocatedVotes;
		}
	}

	/*
	 * 
	 * CDM indicates Congressional District Method of delegating electoral votes
	 * */
	
	public Results() {
		
		simulator = new SchellingSimulator(1, 3, 538, 2, 28, 20);
		
		election(0,5,0,5,9);	//Alabama
		election(0,5,0,5,3);	//Alaska
		election(0,5,0,5,11);	//Arizona
		election(0,5,0,5,6);	//Arkansas
		election(0,5,0,5,55);	//California
		election(0,5,0,5,9);	//Colorado
		election(0,5,0,5,7);	//Connecticut
		election(0,5,0,5,3);	//Delaware
		election(0,5,0,5,3);	//DC
		election(0,5,0,5,29);	//Florida
		election(0,5,0,5,16);	//Georgia
		election(0,5,0,5,4);	//Hawaii
		election(0,5,0,5,4);	//Idaho
		election(0,5,0,5,20);	//Illinois
		election(0,5,0,5,11);	//Indiana
		election(0,5,0,5,6);	//Iowa
		election(0,5,0,5,6);	//Kansas
		election(0,5,0,5,8);	//Kentucky
		election(0,5,0,5,8);	//Louisiana
		
		//Maine (state - 2 votes, x1 & y1 include FCD and SCD via. CDM)
		election(0,5,0,5,2);
		election(0,5,0,5,1);	//Maine (First Congressional District - 1 votes)
		election(0,5,0,5,1);	//Maine (Second Congressional District - 1 vote)
	
		election(0,5,0,5,10);	//Maryland
		election(0,5,0,5,11);	//Massachusetts
		election(0,5,0,5,16);	//Michigan 
		election(0,5,0,5,10);	//Minnestoa
		election(0,5,0,5,6);	//Mississippi
		election(0,5,0,5,10);	//Missouri
		election(0,5,0,5,3);	//Montana
		
		//Nebraska (state - 2 votes, x1 and y1 include FCD,SCD, and TCD via. CDM)
		election(0,5,0,5,2);
		election(0,5,0,5,1);//Nebraska (FCD - 1 vote)
		election(0,5,0,5,1);	//Nebraska (SCD - 1 vote)
		election(0,5,0,5,1);	//Nebraska (TCD - 1 vote)

		election(0,5,0,5,6);	//Nevada
		election(0,5,0,5,4);	//New Hampshire
		election(0,5,0,5,14);	//New Jersey
		election(0,5,0,5,5);	//New Mexico
		election(0,5,0,5,29);	//New York
		election(0,5,0,5,15);	//North Carolina
		election(0,5,0,5,3);	//North Dakota
		election(0,5,0,5,18);	//Ohio
		election(0,5,0,5,7);	//Oklahoma
		election(0,5,0,5,7);	//Oregon
		election(0,5,0,5,20);	//Pennsylvania
		election(0,5,0,5,4);	//RhodeIsland
		election(0,5,0,5,9);	//South Carolina
		election(0,5,0,5,3);	//South Dakota
		election(0,5,0,5,11);	//Tennessee
		election(0,5,0,5,38);	//Texas
		election(0,5,0,5,6);	//Utah
		election(0,5,0,5,3);	//Vermont
		election(0,5,0,5,13);	//Virginia
		election(0,5,0,5,12);	//Washington
		election(0,5,0,5,5);	//West Virigina
		election(0,5,0,5,10);	//Wisconsin 
		election(0,5,0,5,3);	//Wyoming
		
		
		//The total of the third parameter equals the 538 electoral votes 
	}
	
	public String callRace() {
		if (repVote >= 270) {
			return "Donald Trump (Republican)";
		} else if (demVote >= 270) {
			return "Hillary Clinton (Democrat)";
		} else {
			return "no one";
		}
	}	
	
	public static void main(String[] args) {
		
		Results res = new Results();
		System.out.println("The winner is " + res.callRace() + "!");
		
	}
	
	
}
