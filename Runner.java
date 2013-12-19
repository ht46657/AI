package Project;

public class Runner
{
	public static void main(String[] args)
	{
		
		System.out.println("1 - Mastermind");
		System.out.println("2 - Traveling Salesman.");
		System.out.println("3 - Exit.");
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		while(true)
		{
			System.out.println("Please select a game: ");
			
			try
			{
				int i = Integer.parseInt(s.nextLine());
				
				if(i == 1)
				{
					System.out.println("You have selected Mastermind...");
					Mastermind471 m = new Mastermind471();
					s.close();
					return;
				}
				else if(i == 2)
				{
					System.out.println("You have selected Traveling Salesman");
					s.close();
					return;
				}
				else if(i == 3)
				{
					System.out.println("Goodbye.");
					s.close();
					return;
				}
				
				System.out.println();
			}
			catch(Exception e)
			{
				System.out.println("Please input a valid choice");
			}
		}
	}
}
