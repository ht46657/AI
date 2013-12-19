package tfsmastermind;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tfsmastermind.TempTFS.City;


public class TempTFS471{
	
	public TempTFS471()
	{
		
	}
	
	public static void main(String[] args)
	{
		try{
			String args2[] = new String[10];
			int randomDistance = 0;
			int totalDistance = 0;
			ArrayList<City> original = new ArrayList<City>();
			ArrayList<City> solution = new ArrayList<City>();
			TempTFS temp = new TempTFS(args2);
			
			
			
			//RANDOM GENERATED FILE CODE//
			
			/*String inputFile = "inputFile.txt";
			String outputFile = "outputFile.txt";
			FileWriter output = null;
			output = new FileWriter(outputFile);
			BufferedWriter writer = new BufferedWriter(output);
			temp.generateRandomFile(inputFile);
			original = temp.read(inputFile);
			//Calculate the distance from the random traversal
			randomDistance = temp.doMath(original);
			
			solution = temp.nearestNeighbor(original);
			temp.check(solution, original);
			//Calculate the distance from Dijkstra's algorithm traversal
			totalDistance = temp.doMath(solution);
			
			
			writer.write("Solution List " + "\n");
			for(int i = 0; i < solution.size(); i++){
				writer.write(String.valueOf(solution.get(i).getX()) + " " + String.valueOf(solution.get(i).getY()) + "\n");
			}
			writer.write("Random Distance: " + randomDistance + "\n");
			writer.write("Total Distance: " + totalDistance);
			writer.close();*/
			
			
			
			//COMMAND LINE INPUT CODE//
			
			String inputFile2 = args[0];
			String outputFile2 = args[1];
			
			original = temp.read(inputFile2);
			randomDistance = temp.doMath(original);
			solution = temp.nearestNeighbor(original);
			temp.check(solution, original);
			totalDistance = temp.doMath(solution);
	
		
			FileWriter output2 = null;
			output2 = new FileWriter(outputFile2);
			BufferedWriter writer2 = new BufferedWriter(output2);
			
			writer2.write("Solution List " + "\n");
			for(int i = 0; i < solution.size(); i++){
				writer2.write(String.valueOf(solution.get(i).getX()) + " " + String.valueOf(solution.get(i).getY()) + "\n");
			}
			writer2.write("Random Distance: " + randomDistance + "\n");
			writer2.write("Total Distance: " + totalDistance);
			writer2.close();
			}
			catch (FileNotFoundException e) {
				throw new RuntimeException("File not found");
			} 
			catch (IOException e) {
				throw new RuntimeException("IO Error occured");
			}
	}
	
}