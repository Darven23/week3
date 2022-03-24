package lab03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Input{
	
	public static void main(String[] args) {
		
		//1.declaration of target storage
		String inFile = "cheng.txt";
		
		//data declaration
		String date[]= {"18/03/2022","19/03/2022","20/03/2022","21/03/2022"
						,"22/03/2022","23/03/2022"};
		double rainfall[]= {7.0,0.0,0.0,8.0,0.0,0.0};
		
		try {
			//2.create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(inFile));
			
			//process data
			for(int index = 0;index<date.length;index++) {
				
				//3.Write data into the data stream
				dos.writeUTF(date[index]);
				dos.writeDouble(rainfall[index]);
				
				//4.flush for each writing
				dos.flush();
			}
			
			//5.Close stream
			dos.close();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + inFile); 
	}
}