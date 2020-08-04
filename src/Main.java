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
		
		List<String[]> rawData = new ArrayList<String[]>();
		
		
		while(br.hasNext()) {
			String line = br.nextLine();
			String[] columns = line.split(","); 
			rawData.add(columns);
		}
		
		ArrayList<String> currencyNames = new ArrayList<>();
		
		for(int i = 1; i < rawData.get(0).length; i++) {
			currencyNames.add(rawData.get(0)[i]);
		}
		
		double rates [][] = new double [rawData.get(1).length-1][rawData.get(1).length-1];
		
		for(int row = 1; row < rawData.size(); row++) {
			for(int column = 1; column < rawData.get(1).length; column++) {
				double rate = Double.parseDouble(rawData.get(row)[column]);
				rates[row-1][column-1] = rate ;
			}
		}
		
		double weight[][] = new double[rates[0].length][rates[0].length];
		
		for(int row = 0; row < rates[0].length; row++) {
			for(int column = 0; column < rates[0].length; column++) {
				weight[row][column] -=  Math.log(rates[row][column]) ;
			}
		}
		
		Scanner sc= new Scanner(System.in);     
		
		for(int i =0; i < currencyNames.size(); i++) {
		
			System.out.println((i+1) + " : " + currencyNames.get(i));
		}
	
		System.out.print("\nSelect a number based on currency of choice: ");
	
		int choice = sc.nextInt();
	
		System.out.println("\nYour choice was " + currencyNames.get(choice-1) + "\n");
		
		bellmanFord(currencyNames,rates,weight, choice-1);
		
		
	}
	
	static void bellmanFord(ArrayList<String> currencies, double rates[][], double[][] weights, int source){
		double dist[] = new double [currencies.size()+1];
		
		for(int i = 0; i < currencies.size(); i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[source] = 0; 
		
		for(int n = 0; n < currencies.size(); n++) {
			for(int src = 0; src < currencies.size(); src++) {
				for(int destination = 0; destination < currencies.size(); destination++) {
					if(dist[destination] > dist[src] + weights[src][destination]) {
						dist[destination] = dist[src] + weights[src][destination];
					}
				}
			}
		}
		
		for(int n = 0; n < currencies.size(); n++) {
			dist[n] = Math.exp(-dist[n]);
			System.out.println(currencies.get(n)+ ": max Exchange Rate is "+dist[n] +", and direct rate is " + rates[source][n]);
		}
	}	
}
   
	



