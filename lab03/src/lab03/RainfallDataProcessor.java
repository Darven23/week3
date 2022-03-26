package lab03;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainfallDataProcessor {
	
	public static void main(String[] args) {
		
		int numberOfStation = 6;
		for(int index = 0;index<numberOfStation;index++) {
			
			String sourceInput = "station"+index+".txt";
			
			try {
				
				DataInputStream disObject = new DataInputStream(new FileInputStream(sourceInput));
				
				String stationInfo = disObject.readUTF();
				System.out.println(stationInfo);
				
				double data = 0.0;
				double totalRainfall = 0.0;
				double AverageRainfall = 0.0;
				
				int i=0;
				while(disObject.available()>0) {
					
					//put logic here to calculate average
					data = disObject.readDouble();
					System.out.println(data+"");
					totalRainfall+=data;
					i++;
					
					if(i%6==0) {
						AverageRainfall=totalRainfall/6.0;
						System.out.println("Average Rainfall Intensity: "+AverageRainfall);
					}
				}
				
				System.out.println();
				
				disObject.close();
				
			}catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
