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
		Scanner br = new Scanner(new File("Book1.csv"));
		
		List<String[]> rowList = new ArrayList<String[]>();
		
		
		while(br.hasNext()) {
			String line = br.nextLine();
			String[] columns = line.split(","); 
			rowList.add(columns);
			
			
		}
		
		
		ArrayList<String> currencyNames = new ArrayList<>();
		
		for(int i = 1; i < rowList.get(0).length; i++) {
			currencyNames.add(rowList.get(0)[i]);
		}
		
		String rates [][] = new String [rowList.get(1).length-1][rowList.get(1).length-1];
		
		for(int row = 1; row < rowList.size(); row++) {
			for(int column = 1; column < rowList.get(1).length; column++) {
				rates[row-1][column-1] = rowList.get(row)[column];
				//System.out.println(rates[row-1][column-1]);
			}
		}
		
		
		
		System.out.println(Arrays.deepToString(rates).replace("],","\n").replace(",", "\t| ").replaceAll("[\\[\\]]"," "));
		
		
		
//		Scanner sc= new Scanner(System.in);     
//		System.out.print("Choose currency: ");  
//		String a= sc.nextLine();  
//		
//		while(!currencyNames.contains(a)) {
//			System.out.println("Invalid answer, try another \nEx: Kuwaiti Dinar, Japanese Yen ");
//			a= sc.nextLine();
//		}
				
	}
	
}


