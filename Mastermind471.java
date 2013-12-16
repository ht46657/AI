import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mastermind471
{
	
	private int pegs = 0;
	private int colors = 0;
	
	public Mastermind471()
	{
		boolean solved = false;
		
	    //PrintWriter childOutput = new PrintWriter(child.getOutputStream());
	    //Scanner childInput = new Scanner(child.getInputStream());
	    Scanner s = new Scanner(System.in);
		//String abc = s.nextLine();
		//System.out.println(abc);
		
		while(!solved)
		{
			System.out.println("1");
			
			try
			{
				wait(100);
			}
			catch (Exception e)
			{
				
			}
			//String guess = s.nextLine();
			
		}
	}
	
	private void guess()
	{
		
	}
	
	public static void main(String[] args)
	{
		Mastermind471 m = new Mastermind471();
	}
	
}
