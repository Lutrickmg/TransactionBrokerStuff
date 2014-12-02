import java.io.File;




public class TestRun 
{

	public static void main(String[] args) 
	{
		CSVSplitter thisSplitter = new CSVSplitter();
		File testFile = new File("hi.txt");
		String testString = "\"Johnston, James  - 27381 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES 1029330,,A7039 \n\"Yoda, Master  - 27361 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES 1035442,,A7038 \n\"Prait, Chris L - 93047 : 1\",5154 MAUDELAYNE DR S,MOBILE,AL,36693-0000,(251) 214 - 7503,001 - CIGNA GOVERNMENT SERVICES JURISDICTION C,MED WRITEOFF,,A7034 \n\"Johnston, James  - 23412 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES A7035,,A7035 \n\"Prait, Chris L - 12345 : 1\",5154 MAUDELAYNE DR S,MOBILE,AL,36693-0000,(251) 214 - 7503,001 - CIGNA GOVERNMENT SERVICES JURISDICTION C,MED WRITEOFF,,A7037";

		/*try 
		{
			FileWriter writer = new FileWriter(testFile);
			writer.write("\"Johnston, James  - 27381 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES 1029330,,A7039 \n\"Yoda, Master  - 27361 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES 1035442,,A7038 \n\"Prait, Chris L - 93047 : 1\",5154 MAUDELAYNE DR S,MOBILE,AL,36693-0000,(251) 214 - 7503,001 - CIGNA GOVERNMENT SERVICES JURISDICTION C,MED WRITEOFF,,A7034 \n\"Johnston, James  - 23412 : 1\",807 SHELTON BEACH RD #33,SARALAND,AL,36571-0000,(205) 368 - 5265,950 - VIVA HEALTH,RES A7035,,A7035 \n\"Prait, Chris L - 12345 : 1\",5154 MAUDELAYNE DR S,MOBILE,AL,36693-0000,(251) 214 - 7503,001 - CIGNA GOVERNMENT SERVICES JURISDICTION C,MED WRITEOFF,,A7037");
			writer.flush();
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}*/
		String deQuoted = thisSplitter.removeQuotes(testString);
		System.out.println(deQuoted);
		String[] lineSplit = null;
		try
		{
			lineSplit = deQuoted.split("\n");
		}
		catch(Exception ex)
		{
			lineSplit = new String[1];
			lineSplit[0] = deQuoted;
		}
		String[] holding = new String[Math.multiplyExact(lineSplit.length, 12)];
		String[] holding2 = new String[Math.multiplyExact(lineSplit.length, 16)];
		String[] finalHolding = new String[holding2.length];
		int counter = 0;
		for (String s : lineSplit)
		{
			String[] deCommaed = s.split(",");
			for (String s2 : deCommaed)
			{
				holding[counter] = s2;
				counter++;
			}
		}
		counter = 0;
		/*for(String s3 : holding)
		{
			if (s3 != null)
			{
				System.out.println(s3);
			}
		}*/
		for (String s4 : holding)
		{
			String[] deHyphened = s4.split("-");
			for (String s5 : deHyphened)
			{
				holding2[counter] = s5;
				counter++;
			}
		}
		counter = 0;
		for (String s6 : holding2)
		{
			String[] deColoned = s6.split(":");
			for (String s7 : deColoned)
			{
				finalHolding[counter] = s7;
				counter++;
			}
		}
		
		for (String s8 : finalHolding)
		{
			System.out.println(s8);
		}
		/*char[] chars = new char[1000];
		try 
		{
			FileReader reader = new FileReader(testFile);
			reader.read(chars);
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		for(char c : chars)
		{
			System.out.print(c);
		}*/
	}	
}
