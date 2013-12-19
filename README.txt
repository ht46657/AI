README (TRAVELING SALESMAN PROBLEM)

1) To execute this program we have provided a runnable JAR file.

2) To run our traveling salesman program, make sure you are in the same directory as the jar file and your input and output text files,
	and then at the command line, enter:
	
	java -jar TSP3.jar "inputFileName" "outputFileName"
	
3) In the main method of TempTFS471, it will take in the name of the inputFile and outputFile,
   and work with those (read in the input from the inputFile, and output results into the outputFile.)
   
4) There is also a section of commented out code (labeled under //RANDOM GENERATED FILE CODE// and above //COMMAND LINE INPUT CODE// in main that works with 
	an already generated input/output file (input is randomly generated, and output is generated to the already existing output file. This does not take in 
	the files from the command line, but can be tested as well in a crunch (and if any complications arise). The number of randomly generated cities 
	can be altered in the generateRandomFile method in TempTFS.java file in the for loop in the method (it should loop to i < 101, change that value to create 
	a random file with however many cities you want.