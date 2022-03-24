package lab03;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Output {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "cheng.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream read = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double rainfall = 0;
			double totalRainfall = 0;
			int totalRecords = 0;
			String date = "";
			
			// 3. Process data until end-of-file
			while(read.available() > 0) {
				
				// Read data
				date = read.readUTF();
				rainfall = read.readDouble();
				System.out.println( date + "\t" + rainfall);
				
				// Calculate total utilization
				totalRainfall += rainfall;
				totalRecords++;
			}
			
			// 4. Close stream
			read.close();
			
			// Calculate average utlization
			double averageRainfall = totalRainfall / totalRecords;
			System.out.print("\nAverage Rainfall for " + totalRecords 
					+ " dates: " + averageRainfall);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indication of end of program
		System.out.println("\nEnd of program.");
		

	}

}