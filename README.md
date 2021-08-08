# ElectionSchellingSimulator

Project Name: 2016 US Presidential Election Simulator

Categories: Implementation/Empirical Analysis

Description: This project simulates 2016 US Presidential election data via a Schelling model.
Election data, specifically the percentage of votes that were republican/democratic/other, were scraped
from a Wikipedia page on the 2016 election. This data included percentages for the overall election and
specific demographics (gender, ideology, and age). The Schelling Model is composed of three types of groups:
red, blue, and other to represent the different parties, and in each trial of the simulation it produces a layout
of the individuals of the groups according to the proportions set by the data from the wikipedia page. Users of this 
program can request specific demographics, view maps of the simulation, collect homophily data, and restart the program 
from the Customizer class that holds the main method. 

DataScrape.java
	Function: uses JSoup to scrape data from Wikipedia page
	(1) Scraped the Wikipedia page for all of the election statistics.
	(2) Saved the results to functions to be called in other classes.

Main.java 
	Function: User-interface with main method to run the program and customize the simulation.
	(1) Wrote the code/text for command-line arguments.
	(2) Saved function outputs from Datascrape.java to call in running the simulation.

SchellingSimulator.java
	Function: Runs the Schelling Simulation
	(1) Added functions to calculate the election outcomes.
	(2) Divided the Schelling map into regions to resemble states.
	(3) Modified the main method into a function to be called by Main.java.  
	(4) Mdified the populate function to call different proportions for each class (republican/democrat/other). 
	
SchellingVisualizer.java
	Function: Creates Map of Simulation
	(1) Made modifications to the class and converted main method to a function called by Main.java. 
