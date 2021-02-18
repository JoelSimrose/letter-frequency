//Joel Simrose
//October 29, 2018


import java.net.*;
import java.io.*;

/**
*This is a class which takes a webpage and checks for the frequency of each letter.
*/
public class LetterFrequency
{

	private static int[] count = new int[26];

	public static void main(String[] args)
	{
		try
		{
			URL server = new URL("https://en.wikipedia.org/wiki/The_King%27s_University_(Edmonton)");	//server to connect to 
            		HttpURLConnection webpageConnection= (HttpURLConnection) server.openConnection();
            		webpageConnection.setRequestMethod("GET");
			
			webpageConnection.connect();
			
			InputStream in = webpageConnection.getInputStream();	

			byte[] buffer = new byte[4096];
			int bytesRead = in.read(buffer);	

			while(bytesRead > 0)
			{
				for(int i=0; i<bytesRead; i++)
				{
					
					int upper = Character.toUpperCase((char)buffer[i]);

					if(upper >= 'A' && upper <= 'Z')	//if the value is a character then add it to the array count
					{
						
						count[upper-'A']++;
						//System.out.print(Character.toUpperCase((char)buffer[i]));

					}

				}

				bytesRead = in.read(buffer);

			}

			for(int j=0; j<26; j++)
			{
				System.out.println("Letter " + ((char)((int)'A' + j)) + ": "+count[j]);	//output the array values
			}
		}



		catch(Exception e) { System.out.println("Error opening page\n"+e); }	//error case in case page does not open properly
	}
}

