import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
			}
		}
		Layout lay = new Layout(temp);
		towns.add(lay);
		temp.clear();
		counter = 0;
		
		
		
		
		
		
	}

}
