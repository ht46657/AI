import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Mastermind471
{
	
	// int pegs = 0;
	//private int colors = 0;
	int[] toGuess = { 1, 2, 3, 4};
	
	
	public Mastermind471(int pegs, int colors)
	{
		boolean solved = false;
		
	    //PrintWriter childOutput = new PrintWriter(child.getOutputStream());
	    //Scanner childInput = new Scanner(child.getInputStream());
	    Scanner s = new Scanner(System.in);
		//String abc = s.nextLine();
		//System.out.println(abc);
		
	    int[] guess = new int[pegs];//{ -1, -1, -1, -1} ;
	    for(int i = 0; i < guess.length; i++)
	    	guess[i] = 0;
	    //childOutput.write(5 + " " + 4); // Number of possible keys followed by number of pegs
	   
	    int numRightPlace = 0;
	    int numRight = 0;
	    
	    while(! listEquals(guess, toGuess))
	    {

	    	guess = guess(pegs, colors, numRightPlace, numRight);
	    	
	    	numRightPlace = numRightPlace(toGuess, guess);
	    	numRight = numRight(toGuess, guess);
	    	
			System.out.println(numRightPlace(toGuess, guess) + " " + numRight(toGuess, guess));
	    }
	}
	
	private String printGuess(int[] guess)
	{
		String s = "";
		
		for(int i = 0; i < guess.length; i++)
		{
			s += guess[i] +  " ";
		}
		
		return s;
	}
	
	private int[] guess(int pegs, int colors, int numRightPlace, int numRight)
	{
		int[] guess = new int[pegs];//{ -1, -1, -1, -1} ;
	    for(int i = 0; i < guess.length; i++)
	    	guess[i] = 1;
	    
		return guess;
	}
	
	public static void main(String[] args)
	{
		int pegs = 0;
		int colors = 0;
		
		try
		{
			pegs = Integer.parseInt(args[0]);
			colors = Integer.parseInt(args[1]);

		}
		catch(Exception e)
		{
			
		}
		
		if(args.length < 2)
			System.out.println("Please pass in the number of pegs and number of colors.");
		
		Mastermind471 m = new Mastermind471(pegs, colors);
				
	}
	
	/*---------------------------Max's code from his driver--------------------------------------*/
	
	public static int numRightPlace(int[] list1, int[] list2) {
		int counter = 0;
		for(int i = 0; i < list1.length; i++) {
		    if(list1[i] == list2[i]) {
			counter++;
		    }
		}
		return counter;
	    }

	    public static int numRight(int[] list1, int[] list2) {
		int[] hist1 = histogram(list1);
		int[] hist2 = histogram(list2);

		Vector<Integer> newHist = new Vector<Integer>();

		for(int i = 0; i < Math.min(hist1.length, hist2.length); i++) {
		    newHist.add(Math.min(hist1[i], hist2[i]));
		}

		int sum = 0;

		for(int i = 0; i < newHist.size(); i++) {
		    sum += newHist.get(i);
		}
		return sum;
	    }

	    public static int max(int[] m) {
		int max = -1;
		for(int i = 0; i < m.length; i++) {
		    if(m[i] > max) {
			max = m[i];
		    }
		}
		return max;
	    }

	    public static int[] histogram(int[] list1)
	    {
	    	int[] hist = new int[max(list1) + 1];

	    	for(int i = 0; i < list1.length; i++)
	    	{
	    		hist[list1[i]]++;
	    	}
	    	return hist;
	    }

	    public static boolean listEquals(int[] list1, int[] list2)
	    {
	    	boolean test = true;
	    	for(int i = 0; i < list1.length; i++)
	    	{
	    		test = test && list1[i] == list2[i];
	    	}
	    	
	    	return test;
	    }
	
}
