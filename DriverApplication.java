//Thomas Kestler CS310
import java.io.*;
import java.util.*;
public class DriverApplication {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		BufferedReader pat=null;
		BufferedReader value = null;
		ArrayList<Integer> pats = new ArrayList<Integer>(); //for patterns
		Queue values = new Queue();
		try {
			String line;
			
			pat = new BufferedReader(new FileReader("./pats.txt"));
			value = new BufferedReader(new FileReader("./values.txt"));
		while((line = pat.readLine())!= null) {//put values from pats into an arraylist of patterns
			StringTokenizer stringToken = new StringTokenizer(line,",");
			while(stringToken.hasMoreElements()) {
				pats.add(Integer.parseInt((String) stringToken.nextElement()));
			}
			
		}
		while((line = value.readLine())!= null) {//put values from "values" into a queue
			StringTokenizer stringToken = new StringTokenizer(line,",");
			while(stringToken.hasMoreElements()) {
				values.loadValue(Integer.parseInt((String) stringToken.nextElement()));
			}
			
		}
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pat != null)
					pat.close();
				if(value != null)
					value.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		
		
		}
	
	Queue decoded = Decoder.Decode(values,pats); //pass the queue and list to be decoded
	
	FileOutputStream outputStream = new FileOutputStream("output.csv",true);//write the decoded queue to an output file
	PrintWriter outWriter = new PrintWriter(outputStream);
	int[] outputArr = decoded.peek(decoded.size());
	for(int i=0;i<decoded.size();i++) {
		outWriter.println(outputArr[i]+",");
		
	}
	outWriter.close();
	
	System.out.println("file output.csv has been created");
		
		
	}
	
}
