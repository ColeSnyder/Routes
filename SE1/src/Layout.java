import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Layout {
	
	String direction;
	String town;
	//ArrayList <String> info = new ArrayList<String> ();
	ArrayList <String> verticalStreet = new ArrayList<String> ();
	ArrayList <String> horizontalStreet = new ArrayList<String> ();


	String[] splitArr;


	public Layout(ArrayList input) 
	{
				
		
		
		
		

		for(int i = 0; i < input.size(); i++)
		{
			String temp = (String) input.get(i);
			
			if(temp.contains("Vertical")) 
			{
				i++;
				 temp = (String) input.get(i);
				
				while(!temp.contains("Horizontal"))
				{
					i++;
					verticalStreet.add(temp);
					
					 temp = (String) input.get(i);
				}
				while (temp.contains("Horizontal"))
				{
				
					if (!temp.isEmpty())
					{
						i = i + 1;
						temp = (String) input.get(i);

						if(!temp.contains("Horizontal"))
						{
							
							horizontalStreet.add(temp);
						}
						
						// temp = (String) input.get(i);
						 
						 if(i==input.size()-1) {
							 break;
						 }
					}
			
				}
				
			}
			

			
			
			town = (String) input.get(0);
			splitArr = town.split(":" , 2);
			town = splitArr[1];
			
		}
			
	}

	
	
	
	
	
	public String getTown()
	{
		
		return town;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String getTown()
//	{
//		
//	}
	
	
	
	
	
	
}
