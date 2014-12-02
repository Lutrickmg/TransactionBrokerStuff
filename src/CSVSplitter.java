
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVSplitter 
{
	BufferedReader reader = null;
	public CSVSplitter()
	{}
	public void split(String toSplitCSV)
	{
		String[] patientList = this.getPatientList(toSplitCSV);
		String[][] commaSplitList = this.commaSplitList(patientList);
		//String[][] removedQuotes = this.removeQuotes(commaSplitList);
		this.print(commaSplitList);
	}
	
	public String[] getPatientList(String toSplitCSV)
	{
		int afterHeader = 3;
		int counter = 0;
		String workingLine = "";
		String[] patientList = null;
		try
		{
			this.openReader(toSplitCSV);
			while ((workingLine = reader.readLine()) != null)
			{
				//System.out.print("Made inside getPatientList()'s first while loop");
				if (counter >= afterHeader)
				{
					counter++;
				}
			}
			this.closeReader();
			this.openReader(toSplitCSV);
			patientList = new String[counter-3];
			while ((workingLine = reader.readLine()) != null)
			{
				if (counter >= afterHeader)
				{
					patientList[counter-3] = workingLine;
				}
				counter++;
			}
		}
		catch (IOException e)
		{
			
		}
		finally
		{
			this.closeReader();
		}
		return patientList;
	}
	
	public String[][] commaSplitList(String[] patientList)
	{
		int counterForPatients = 0;
		int counterForData = 1;
		String[][] returnList = new String[patientList.length/10][10];
		String[] commaSplitLine = new String[10];
		while (counterForPatients < patientList.length/10)
		{
			commaSplitLine = patientList[counterForPatients].split(",");
			while(counterForData < 10)
			{
				returnList[counterForPatients][counterForData] = commaSplitLine[counterForData];
				counterForData++;
			}
			counterForData = 0;
			counterForPatients++;
		}
		return returnList;
	}
	
	
	public String removeQuotes(String toRemove)
	{
		char[] holder = toRemove.toCharArray();
		String toReturn = "";
		for(char c : holder)
		{
			if (!(c == '\"'))
			{
					toReturn += c;
			}
		}
		return toReturn;
	}
	
	public void openReader(String fileName)
	{
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e)
		{
			
		}
	}
	
	public void closeReader()
	{
		if (reader != null)
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				
			}
		}
	}
	
	public void print(String[][] toPrint)
	{
		int counter1 = 0;
		int counter2 = 0;
		
		while (counter1 < toPrint.length)
		{
			while (counter2 < toPrint[counter1].length)
			{
				System.out.print(toPrint[counter1][counter2]);
				counter2++;
			}
			System.out.println();
			counter2 = 0;
			counter1++;
		}
	}
}
