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
				//System.out.println( weight[row][column]);
				
			}
		}
		
		
		
		
		
		//System.out.println( rates[2][3] + " 1 - log(5) = 0.3010299 : " + weight[2][3]);
		//System.out.println( rates[0][3] + " 1 - log(12) = -07918124 : " + weight[0][3]);
		
		 Scanner sc= new Scanner(System.in);     
		//System.out.println(currencyNames.get(41));
		
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
	
	
	
///////////////////THIS IS TRASH/////////////////////////////////////////////	

//	
//	for(int i = 0; i < rates[0].length; i++) {
//		System.out.println(currencyNames.get(i)+ " max Exchange Rate is: "+ rates[2][i] +", and direct rate is: " + rates[3][i]);
////	}
////	
////	System.out.println("\nYour choice was " + currencyNames.get(choice-1));
//	int V = houses.size();
//	int E = V * V;
//	float dist[] = new float[V];
//	
//	for(int i =0; i < V; i++) {
//		dist[i] = Integer.MAX_VALUE; // initalize vertices as infinite
//	}
//	
//	dist[source] = 0; // starting point
//	
//	for(int i = 0; i < V-1; i++) {
//		//Update the edge
//		float u = distances[0][i];
//		
//		for(int j = 0; j < E; j++) {
//			float v = distances[i+1][j];
//			float weight = weights[i+1][j];
//			if((v != Integer.MAX_VALUE || u != 0 || v != 0 ) && u + weight < v) {
//				u = v;
//			}
//		}
//	}
//	
}
   
	



