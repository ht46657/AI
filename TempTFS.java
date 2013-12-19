package tfsmastermind;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class TempTFS {
	
	//Varaible declaration
	private ArrayList<City> solution = new ArrayList<City>();
	private City currentCity;
	private Random rand = new Random();
	private int count = 0;
	private int a = 0;
	private int temp = 0;
	private int minimum = 0;
	private int distance = 0;
	private boolean allVisited;
	
	
	
	
	public TempTFS(String args[])
	{

	}
	
	
	
	//Dijkstra's algorithm implementation
	public ArrayList<City> nearestNeighbor(ArrayList<City> original){
		
		City firstCity;
		
		//Creates an index to start at a random city
		a = rand.nextInt(original.size() - 1);
		
		//Mark the original city as visisted and add it to the solution
		original.get(a).visitCity();
		solution.add(original.get(a));
		firstCity = original.get(a);
		a = 0;
		
		//Add the minimum distance city to the solution until all cities have been covered
		while(solution.size() != original.size()){
			
			solution.add(getMinimum(solution.get(a), original));
			a++;
		}
		//Add the original city to the end to complete the circuit
		solution.add(firstCity);
		return solution;
	}
	
	//Calculates the minimum distance between available cities given the current one
	public City getMinimum(City currentCity, ArrayList<City> original){
		
		int random = rand.nextInt(original.size());
		
		//Sets minimum to an arbitrarily high value
		int minimum = (int)Math.pow(2, 10);
		int index = 0;

		//Loop through the list of orginal cities
		for(int i = 0; i < original.size(); i++){

			//calculate the distance
			int distance = (distance(original.get(i), currentCity));

			if(distance != 0)
			{
				//If it is less than the current minimum value and the city has not been visited
				//set it as the new minimum
				if(distance < minimum && !(original.get(i).getVisited()) || minimum == 0)
				{
					minimum = distance;
					index = i;
				}
			
			}

		}
		//mark the city as visisted and return it
		original.get(index).visitCity();
		return original.get(index);
	}
	
	//CODE AFTER THIS POINT (SANS CITY CLASS) IS DERIVED FROM THE TSP DRIVER PROVIDED BY MAX
	
	public boolean check(ArrayList<City> solution, ArrayList<City> original){
		boolean found = false;
		
		if(solution.size() == original.size())
		{
			int size = solution.size();
		
			for(int i = 0; i < size; i++){
				
				found = false;
				
				for(int j = 0; j < size; j++){
					if((original.get(i).getX() == solution.get(j).getX()) && (original.get(i).getY() == solution.get(j).getY())){
						found = true;
					}
				}
				if(found != true)
				{
					return found;
				}
			}
		}
		else{
			
			return false;
		}
		return true;
	}
	
	public int distance(City city1, City city2){
		return (int)Math.sqrt(Math.pow(city1.getX() - city2.getX(), 2) + (Math.pow(city1.getY() - city2.getY(), 2)));
	}
	
	public int doMath(ArrayList<City> solution){
		int totalDist = 0;
		for(int i = 0; i < solution.size() - 1; i++){
			totalDist += distance(solution.get(i), solution.get(i + 1));
		}
		return totalDist;
	}
	
	public ArrayList<City> read(String inputFile){
		String line = "";
		String split[];
		City temp;
		int int1 = 0;
		int int2 = 0;
		ArrayList<City> cities = new ArrayList<City>();
		try{
			FileReader file = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(file);
		
			while((line = reader.readLine()) != null){
				split = line.split(" ");
				int1 = Integer.parseInt(split[0]);
				int2 = Integer.parseInt(split[1]);
				temp = new City(int1, int2, false);
				cities.add(temp);
			}
		
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("File not found");
		} 
		catch (IOException e) {
			throw new RuntimeException("IO Error occured");
		}
		return cities;
	}
	
	public void generateRandomFile(String file){
		try{
			Random rand = new Random();
			int a = 0;
			int b = 0;
			City temp;
			FileWriter output = null;
			output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			ArrayList<City> cities = new ArrayList<City>();
			for(int i = 0; i < 101; i++){
				a = rand.nextInt(1000);
				b = rand.nextInt(1000);
				temp = new City(a, b, false);
				cities.add(temp);
				writer.write(String.valueOf(a) + " " + String.valueOf(b) + "\n");
			}
			
			writer.close();
			
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("File not found");
		} 
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("IO Error occured");
		}
		
		
	}
	
	//Our implementation of a City, a set of (X,Y) coordinates, and a boolean for whether it's been visited or not
	public class City{
		
		private Integer x;
		private Integer y;
		private boolean visited = false;
		
		public City(int x, int y, boolean visited){
			this.x = x;
			this.y = y;
			this.visited = visited;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public boolean getVisited(){
			return visited;
		}
		
		public void visitCity(){
			visited = true;
		}
		
		public String toString(){
			String s = this.getX() + " " + this.getY();
			return s;
		}
		
	}
	
}
