import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		String line = "";
		ArrayList <address> houses = new ArrayList<address> ();
		address addr;
		FileInputStream file = new FileInputStream("Address.dat");
		InputStreamReader reader = new InputStreamReader(file, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(reader);
		while ((line = br.readLine()) != null) 
		{
			StringTokenizer token = new StringTokenizer (line, "\n");
			addr = 	new address(token.nextToken());
			houses.add(addr);
			System.out.println();
		}
		String line2 = "";
		ArrayList <Layout> towns = new ArrayList<Layout> ();
		FileInputStream file2 = new FileInputStream("Layout.dat");
		InputStreamReader reader2 = new InputStreamReader(file2, Charset.forName("UTF-8"));
		BufferedReader br2 = new BufferedReader(reader2);
		ArrayList <String> temp = new ArrayList<String> ();
		int counter = 0;
		while ((line2 = br2.readLine()) != null) 
		{
			if(counter < 4)
			{
				if (line2.isEmpty())
				{
					counter++;
				}
				else
				{
					temp.add(line2);
				}
			}
			if(counter == 4)
			{
				Layout lay = new Layout(temp);
				towns.add(lay);
				temp.clear();
				counter = 0;
				//System.out.println(lay.town);
			}
		}
		Layout lay = new Layout(temp);
		towns.add(lay);
		temp.clear();
		counter = 0;
		//System.out.println(lay.town);
		
		ArrayList <String> hStreet = new ArrayList<String> ();
		ArrayList <String> vStreet = new ArrayList<String> ();
		
		for(int b = 0; b < towns.size(); b++)
		{
			for(int i = 0; i < towns.get(b).horizontalStreet.size(); i++)
			{
				
				hStreet.add(towns.get(b).horizontalStreet.get(i));
				
			}
		}
		for(int b = 0; b < towns.size(); b++)
		{
			for(int i = 0; i < towns.get(b).verticalStreet.size(); i++)
			{
				
				vStreet.add(towns.get(b).verticalStreet.get(i));
				
			}
		}
		
		
//		
//		for(int b = 0; b < hStreet.size(); b++)
//		{
//		
//		System.out.println(hStreet.get(b));
//		}
		houses.sort((s1, s2) -> s1.houseNumber - s2.houseNumber);
		
		
//		for (int i = 0; i < houses.size(); i++)
//		{
//			System.out.println(houses.get(i).full);
//		}

		
		
		for (int k = 0; k < towns.size(); k++)
		{
			
			String currentTown = towns.get(k).getTown();
			
			System.out.println(currentTown);
		//	System.out.println("Vertical streets: " + towns.get(k).verticalStreet);
		//	System.out.println("Horizontal streets: " + towns.get(k).horizontalStreet);
			System.out.println("");
			for (int j = 0; j < houses.size(); j++)
			{
				if(houses.get(j).getTown().contains(currentTown) )
				{
					
					
					for(int z = 0; z < vStreet.size(); z++)
					{
						
						if (vStreet.get(z).contains(houses.get(j).street))
						{
							System.out.println(houses.get(j).full);
						}
						
					}
					
					

				}
				

				
			}
			
			//System.out.println("Horizontal");
			System.out.println("");
			for (int j = 0; j < houses.size(); j++)
			{	
			
				for(int b = 0; b < hStreet.size(); b++)
				{
					
					if (hStreet.get(b).contains(houses.get(j).street))
					{
						System.out.println(houses.get(j).full);
					}
					
				}
			
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			
		}
		
		System.out.println();
		
		//System.out.println(hStreet.get(1));
	}

	

	
}
