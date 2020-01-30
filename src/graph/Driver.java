package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	  public static void main(String[] args) throws IOException {
	        FileReader file = new FileReader("XtralargeDG.txt");
	        BufferedReader br = new BufferedReader(file);
	        
	        WeightedUndirectedGraph G = new WeightedUndirectedGraph(br);
	        PrimsAlgorithm primG = new PrimsAlgorithm(G);
	        long startTimer = System.nanoTime();
	        System.out.println(G.toString());

          primG.computeMst();
          primG.printMST();
          long endTimer = System.nanoTime(); 
 		 
 		 System.out.println(endTimer - startTimer);
	  }	        
}
