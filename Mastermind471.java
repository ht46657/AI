import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/*
 * Project 471
 * Authors: Justin Whiteside, Zach Hisley. 
 * Runs the mastermind code. 
 */

public class Mastermind471
{
	
	// int pegs = 0;
	//private int colors = 0;
	private int[] toGuess = {1, 2, 3, 4};
	
	private int index = 1;
	private int lastZero = 1;
	
	
	
	public Mastermind471(int pegs, int colors, int[] key)
	{
		toGuess = key;

		
	    int[] guess = new int[pegs];
	    
	    for(int i = 0; i < guess.length; i++)
	    	guess[i] = 0;
	    //childOutput.write(5 + " " + 4); // Number of possible keys followed by number of pegs
	   
	    int numRightPlace = 0;
	    int numRight = 0;
	    int numGuess = 0;
	    
	    //ArrayList<int[]> guesses = generate(pegs, colors);
	    
	    ArrayList<Integer> numColors = new ArrayList<Integer>();
	    int[] startGuess = new int[pegs];
	    
	    //Finds all the colors in the answer
	    for(int i = 1; i <= colors; i++)
	    {
	    	if(numColors.size()< pegs)
	    	{
	    	 guess[0] = i;
	    	 
	    	 numRightPlace = numRightPlace(toGuess, guess);
		     numRight = numRight(toGuess, guess);
		     
		     if(numRight == 1)
		     {
		    	 numColors.add(i);
		     }
		     
		     if(numRight == 1 && numRightPlace == 1)
		     {
		    	startGuess[0] = i;
		     }
		     
		     System.out.println("Guess--> " + printGuess(guess));
			 System.out.println("Reads--> " + numRightPlace + " " + numRight);	
			 numGuess ++;
			 }	    	 
	    }
	    

	    numRightPlace = 1;
	    numRight = 0;
    	int lastRightPlace = 1;
    	int lastRight = 1;
    	guess = startGuess;
    	
    
    	ArrayList<int[]> guesses = new ArrayList<int[]>();
    	guesses.add(guess);
    	
    	while(! listEquals(guess, toGuess))
    	//(int i = 0; i < 10; i++)
	    {
	    	guess = smartGuess(numColors, numRightPlace, numRight, guess, lastRight, lastRightPlace);
	    	lastRightPlace = numRightPlace;
	    	lastRight = numRight;
	    	numRightPlace = numRightPlace(toGuess, guess);
	    	numRight = numRight(toGuess, guess);
	    	System.out.println("Guess--> " + printGuess(guess));
			System.out.println("Reads--> " + numRightPlace + " " + numRight);	
			
			
			
			/*try
			//Slows down input inorder to read it.
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
			}*/
			
			numGuess ++;
	    }
	    
	    System.out.println("Solution Found: " + printGuess(guess));
	    System.out.println("Number of guess: " + numGuess);
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
	
	private int[] smartGuess(ArrayList<Integer> colors, int numRightPlace, int numRight, int[] lastGuess, int lastnumRight, int lastnumRightPlace)
	{
		int[] guess = new int[lastGuess.length];

		for(int i = 0; i < guess.length; i++)
		{
			guess[i] = lastGuess[i];
		}


		
		if(lastnumRightPlace == numRightPlace)
		{
			guess[lastZero] = 0;
		}
		
		
		if(guess[index] == 0)
		{
			guess[index] = colors.get(0);			
		
			lastZero = index;
			index = nextZero(guess);		
		}
		
		
		if(nextZero(guess) > index)
		{
			index = 0;
			index = nextZero(guess);
			colors.remove(0);
		}
		
		
	
		
		//System.out.println(dif1);
		
		//System.out.println(printGuess(lastGuess) + " " + printGuess(guess) + " " + numRightPlace + " " + numRight + " " + lastnumRight + " " + lastnumRightPlace + " " + index);
	
		return guess;
	}

	private int nextZero(int[] guess)
	{
		for(int i = index; i < guess.length; i++)
			if(guess[i] == 0)
				return i;
		
		return 0;
	}
	
	private int[] Guess(int pegs, int colors, int numRightPlace, int numRight, int[] lastGuess)
	{
		int[] guess = lastGuess;
		
		guess[numRightPlace] = guess[numRightPlace] + 1;
		
		return guess;
	}
	
	public static void main(String[] args)
	{
		int pegs = 0;
		int colors = 0;
		
		try
		{
			//pegs = Integer.parseInt(args[0]);
			//colors = Integer.parseInt(args[1]);
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Please input the number of colors and pegs seperated by a space (IE: 5 4): ");
			String in = s.nextLine().trim();
			
			if(in.split(" ").length != 2)
			{
				System.out.println("User did not input the colors and pegs in correctly. Please input them in the format \"5 4\"");
				return;
			}
			
			pegs = Integer.parseInt(in.split(" ")[1]);
			colors = Integer.parseInt(in.split(" ")[0]);
			
			System.out.println("Please enter the Key you want the program to guess. (IE: 1 2 3 4)");
			in = s.nextLine().trim();
			
			if(in.split(" ").length != pegs)
			{
				System.out.println("The length of the key did not match the number of pegs you entered.");
				return;
			}

			int[] key = new int[pegs];
			for(int i = 0; i < pegs; i++)
			{
				key[i] = Integer.parseInt(in.split(" ")[i]);
				if(key[i] > colors)
				{
					System.out.println("Key cannot contain an invalid color.");
					return;
				}
				
				if(key[i] == 0)
				{
					System.out.println("Key cannot contain 0, all pegs must contain a color.");
					return;
				}
			}
			
			
			Mastermind471 m = new Mastermind471(pegs, colors, key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(args.length < 2)
			System.out.println("Please pass in the number of pegs and number of colors.");
		
		
				
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
