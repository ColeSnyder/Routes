import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.JobName;

	public class address {
		String full;
		String houseNumber;
		String street;
		String town;
		String zip;
		
	
		public address(String input) 
		{ 

		
			full = input;
			
			StringTokenizer token = new StringTokenizer (input, ",");
			
			int counter = 0;
			while(token.hasMoreTokens()) 
			{
				if (counter == 0)
				{
					
					String tempadd = token.nextToken();
					String parts[] = tempadd.split(" ", 2);
					houseNumber = parts[0];
					street = parts[1];					
					counter++;
					
				}
				
				else if(counter == 1)
				{
					town = token.nextToken().substring(1);;
					counter++;
				}
				else if(counter == 2)
				{
					zip = token.nextToken().substring(1);;
					counter++;
				}
				
				else
				{
					System.out.println(token.nextToken());
					counter++;
				}

				
			}
			
//			System.out.println("full address: " + full);
//			System.out.println("house number: " + houseNumber);
//			System.out.println("Street: " + street);
//			System.out.println("town: " + town);
//			System.out.println("zip code: " + zip);
		}
		
		
		
		public String getFull()
		{
			return full;
			
		}
		public String gethouseNumber()
		{
			return houseNumber;
			
		}
		public String getStreet()
		{
			return street;
			
		}
		public String getTown()
		{
			return town;
			
		}
		public String getZip()
		{
			return zip;
			
		}


		


	}
