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
	
	//String direction;
	String townName;
	String townZip;
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

			}
			else
			{
	
				temp = (String) input.get(i);
				horizontalStreet.add(temp);
				
			}
			

			
			townName = (String) input.get(0);
			splitArr = townName.split(":" , 2);
			townName = splitArr[1];
			
		}
			
	}

	
	
	
	
	
	public String getTown()
	{
		
		String[] townPart = townName.split(",", 2);
		
		townName = townPart[0].substring(1);
		townZip = townPart[1];
		
		return townName;
		
		
	}
	
	
	
	
	public void printH()
	{
		
		for (int i = 0; i < horizontalStreet.size(); i++)
		{
			System.out.println(horizontalStreet.get(i));
		}
		
		
	}
	
	
	public void printV()
	{
		for (int i = 0; i < verticalStreet.size(); i++)
		{
			System.out.println(verticalStreet.get(i));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String getTown()
//	{
//		
//	}
	
	
	
	
	
	
}
