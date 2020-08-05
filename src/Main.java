import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner br = new Scanner(new File("exchangerates.csv"));
		
		List<String[]> rawData = new ArrayList<String[]>(); //raw data coming from exchangerates.csv
		
		
		while(br.hasNext()) {
			String line = br.nextLine();
			String[] columns = line.split(","); // dividing columns in the raw data
			rawData.add(columns);
		}
		
		ArrayList<String> currencyNames = new ArrayList<>(); 
		
		for(int i = 1; i < rawData.get(0).length; i++) {
			currencyNames.add(rawData.get(0)[i]); //from raw data, in row 0, add the names of the currencies
		}
		
		double rates [][] = new double [rawData.get(1).length-1][rawData.get(1).length-1]; // exchange rates between all currencies
		
		for(int row = 1; row < rawData.size(); row++) { // row is 1 to avoid currency names
			for(int column = 1; column < rawData.get(1).length; column++) { // column is 1 to avoid currency names
				double rate = Double.parseDouble(rawData.get(row)[column]); // get all the exchange rates without the currency names
				rates[row-1][column-1] = rate ; // subtract column and rate so that  is doing start at rates[1][1], but rather rates[0][0]
			}
		}
		
		double weight[][] = new double[rates[0].length][rates[0].length]; // weights of each exchange
		
		for(int row = 0; row < rates[0].length; row++) {
			for(int column = 0; column < rates[0].length; column++) {
				//if we can find a cycle of vertices such that the sum of their weights if negative, 
				//then we can conclude there exists an opportunity for currency arbitrage
				weight[row][column] -=  Math.log(rates[row][column]) ; 
			}
		}
		
		Scanner sc= new Scanner(System.in);     
		
		for(int i =0; i < currencyNames.size(); i++) {
		
			System.out.println((i+1) + " : " + currencyNames.get(i)); // Display currencies to choose
		}
	
		System.out.print("\nSelect a number based on currency of choice: ");
	
		int choice = sc.nextInt(); // take user input
	
		System.out.println("\nYour choice was " + currencyNames.get(choice-1) + "\n"); // display currency of choice
		
		bellmanFord(currencyNames,rates,weight, choice-1); // Initiate algorithm
		
		
	}
	
	/**
	 * This method finds the most profitable exchanges between the currency of choice and all other currencies.
	 * It provides a direct exchange (Ex. USD transfered to CAD) and the most profitable exchange, can be direct or indirect 
	 * (Ex. USD transferred to CAD transferred to MEX). 
	 * @param currencies
	 * @param rates
	 * @param weights
	 * @param source
	 */
	static void bellmanFord(ArrayList<String> currencies, double rates[][], double[][] weights, int source){
		double dist[] = new double [currencies.size()+1]; // most profitable exchanges
		
		for(int i = 0; i < currencies.size(); i++) {
			dist[i] = Integer.MAX_VALUE; // all values are infinity
		}
		
		dist[source] = 0; //the source value of the currency chosen by user
		
		for(int n = 0; n < currencies.size(); n++) { // for each currency
			for(int src = 0; src < currencies.size(); src++) { // this is the source exchange
				for(int destination = 0; destination < currencies.size(); destination++) { // this is the destination exchange
					if(dist[destination] > dist[src] + weights[src][destination]) {
						//if destination is more "expensive" (or less profitable) than source + the weight
						// destination will be changed to the most profitable value, source + the weight.
						dist[destination] = dist[src] + weights[src][destination];
					}
				}
			}
		}
		
		for(int n = 0; n < currencies.size(); n++) {
			dist[n] = Math.exp(-dist[n]); // inverse the log() value to rate values
			System.out.println(currencies.get(n)+ ": max Exchange Rate is "+dist[n] +", and direct rate is " + rates[source][n]);
			// display values for source currency
		}
	}	
}
   
	



