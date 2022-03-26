package lab03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainfallDataGenerator {
	

		public static void main(String[] args) {
			
			String stationId[] = {"2222006","2223023","2324033","2225044","2421003","2322006"};
			String name[] = {"Cheng (Taman Merdeka)","Sg. Duyong","Hospital Jasin","Sg. Chohong","Simpang Ampat","Melaka Pindah"};
			String district[] = {"Melaka Tengah","Melaka Tengah","Jasin","Jasin","Alor Gajah","Alor Gajah"};
			
			//rainfall data
			double data1[] = {7,0,0,8,0,0};
			double data2[] = {7,0,0,42,0,0};
			double data3[] = {12,0,0,16,0,0};
			double data4[] = {15,0,0,25,0,0};
			double data5[] = {3,0,0,0,0,14};
			double data6[] = {1,0,0,1,0,0};
			
			double rainfallData[][] = {data1,data2,data3,data4,data5,data6};
			
			for(int index=0; index<name.length;index++) {
				
				dataGenerator(index,stationId[index],name[index],district[index],rainfallData[index]);
			}
		}
		
		public static void dataGenerator(int number, String stationId, String name, String district, double[] data) {
			
			//locate destination
			String targetStorage = "station"+number+".txt";
			
			try {
				
				//create an output stream between this program and traget storage
				DataOutputStream dosObject= new DataOutputStream (new FileOutputStream(targetStorage)) ;
				
				// write title into stream
				String stationInfo = "District: "+district+"\nStation ID: "+stationId+"\nStation Name: "+name;
				dosObject.writeUTF(stationInfo);
				
				//clear the stream
				dosObject.flush();
				
				for(int index=0;index<data.length;index++) {
					
					//write rainfall data into stream
					dosObject.writeDouble(data[index]);
					dosObject.flush();
				}
				dosObject.close();
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}

}
