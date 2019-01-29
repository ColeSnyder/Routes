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
		String line = ""; //Buffered Reader reads each line  
		
		ArrayList <address> houses = new ArrayList<address> (); //Array List that holds all of the houses/info from Lddresses.dat
		address addr; //New object of type address
		FileInputStream file = new FileInputStream("Address.dat"); //Reading from Addresses.dat
		InputStreamReader reader = new InputStreamReader(file, Charset.forName("UTF-8")); //Reading from Addresses.dat
		BufferedReader br = new BufferedReader(reader); //Reading from Addresses.dat
		while ((line = br.readLine()) != null) //While we're still reading info from Addresses.dat
		{
			StringTokenizer token = new StringTokenizer (line, "\n"); //parsing the file
			addr = 	new address(token.nextToken()); //Saving new address as an object
			houses.add(addr); //Adding the object to the arraylist of addresses
		}
		String line2 = ""; //Buffered Reader reads each line
		ArrayList <Layout> towns = new ArrayList<Layout> (); //Array List that holds all of the towns/info from Layout.dat
		FileInputStream file2 = new FileInputStream("Layout.dat"); //Reading from Layout.dat
		InputStreamReader reader2 = new InputStreamReader(file2, Charset.forName("UTF-8")); //Reading from Layout.dat
		BufferedReader br2 = new BufferedReader(reader2); //Reading from Layout.dat
		ArrayList <String> temp = new ArrayList<String> (); //Temporary arraylist for parsing Layout.dat
		int counter = 0; //counter that allows us to parse through Layout.dat. Increments everytime there is a line break
		while ((line2 = br2.readLine()) != null) //while we are still processing info from Layout.dat
		{
			if(counter < 4) //if the counter is greater than four, it means that we are done with the current town
			{
				if (line2.isEmpty()) //if the line is empty, then we are incrementing i and it gets closer to 4
				{
					counter++;
				}
				else //otherwise
				{
					temp.add(line2); //We add that line to the temporary array that we will eventually send to Layout.java for more processing
				}
			}
			if(counter == 4) //if the counter equals 4 
			{
				Layout lay = new Layout(temp); //create new Layout object and send the temporary arraylist to layout.java for processing
				towns.add(lay); //adding the finished arraylist of the current town to the local 'towns' arraylist
				temp.clear(); //clearing the temp array so we can move onto the next town
				counter = 0; 
				//System.out.println(lay.town);
			}
		}
		Layout lay = new Layout(temp); //create new Layout object and send the temporary arraylist to layout.java for processing
		towns.add(lay); //adding the finished arraylist of the current town to the local 'towns' arraylist
		temp.clear(); //clearing the temp array so we can move onto the next town
		counter = 0;
		//System.out.println(lay.town);
		
		ArrayList <String> hStreet = new ArrayList<String> (); //Arraylist for horizontal streets
		ArrayList <String> vStreet = new ArrayList<String> (); //Arraylist for vertical streets
		
		for(int b = 0; b < towns.size(); b++) //towns is the local Layout arraylist that contains all of the addresses
		{
			for(int i = 0; i < towns.get(b).horizontalStreet.size(); i++) //Iterating throughout the arraylist of horizontal streets
			{
				
				hStreet.add(towns.get(b).horizontalStreet.get(i)); //adding the horizontal streets to the local horizontal array list
			}
		}
		for(int b = 0; b < towns.size(); b++) //towns is the local Layout arraylist that contains all of the addresses
		{
			for(int i = 0; i < towns.get(b).verticalStreet.size(); i++) //Iterating throughout the arraylist of vertical streets
			{
				
				vStreet.add(towns.get(b).verticalStreet.get(i)); //adding the vertical streets to the local vertical array list
			}
		}
		
//		for(int b = 0; b < hStreet.size(); b++)
//		{
//		
//		System.out.println(hStreet.get(b));
//		}
		houses.sort((s1, s2) -> s1.houseNumber - s2.houseNumber); //sorting the houses array list from least to greatest
		
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
			for (int j = 0; j < houses.size(); j++) //iterating through arraylist from layout
			{
				if(houses.get(j).getTown().contains(currentTown)) //making sure we get each town only once
				{
					for(int z = 0; z < vStreet.size(); z++) // Iterating through the vertical streets
					{
						if (vStreet.get(z).contains(houses.get(j).street)) //if the current street matches the current address in the houses arraylist
						{
							System.out.println(houses.get(j).full); 
						}	
					}
				}
			}
			
			//System.out.println("Horizontal");
			System.out.println("");
			for (int j = 0; j < houses.size(); j++) //iterating through arraylist from layout
			{	
				for(int b = 0; b < hStreet.size(); b++) // Iterating through the Horizontal streets
				{
					if (hStreet.get(b).contains(houses.get(j).street)) //if the current street matches the current address in the houses arraylist
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
