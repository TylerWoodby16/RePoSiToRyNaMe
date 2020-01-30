package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WeightedUndirectedGraph {

		public int Edge, Vertice;
		public static final String NEXTLINE = System.getProperty("line.separator");
	    private LinkedList<WeightedEdge>[] newAdj;
		
	    public WeightedUndirectedGraph(BufferedReader reader) throws IOException{
        String line;
        line = reader.readLine();
        Vertice = Integer.parseInt(line);
        line = reader.readLine();
        Edge = Integer.parseInt(line);
        newAdj =  new LinkedList[Vertice];
        for (int v = 0; v < Vertice; v++) {
            newAdj[v] = new LinkedList<WeightedEdge>();
        }
        while ((line = reader.readLine()) != null) {
            int tempV1, tempV2;
            float tempV3;
            StringTokenizer st = new StringTokenizer(line, " ");
            tempV1 = Integer.parseInt(st.nextToken());
            tempV2 = Integer.parseInt(st.nextToken());
            tempV3 = Float.parseFloat(st.nextToken());
            addWeightedEdge(tempV1, tempV2, tempV3);
        }	    
      }
	    
	    public int getV(){
	    		return Vertice;
	    }
	    
	    public int getE(){
	    		return Edge;
	    }
	    
	    public Iterable<WeightedEdge> getAdjacent(int v){
	    		checkVertex(v);
	    		return newAdj[v];
	    }
	    
	    public int getDegree(int v){
	    		checkVertex(v);
	    		return newAdj[v].size();
	    }
	    
	    public void checkVertex(int v){
	    	if(v < 0 || v >= Vertice)
	    		throw new IndexOutOfBoundsException("vertex "+v+" is not eligible.");
	    }
	    
	    public void addWeightedEdge(int v, int w, float weight) {
	         checkVertex(v);
	         checkVertex(w);
	         Edge++;
	         newAdj[v].add(new WeightedEdge(v, w, weight));
	         newAdj[w].add(new WeightedEdge(w, v, weight));
	    }
	    
	    public String toString(){
	        String s = new String();
	        s = "There are "+Vertice+" vertices and "+Edge+" edges " + NEXTLINE;
	        for(int i = 0;i < Vertice;i++){
	            s = s + i+ ": ";
	            for(int j = 0; j<newAdj[i].size();j++){
	            		WeightedEdge e = newAdj[i].get(j);
	                s = s+e.start+"-"+e.end+"-"+e.weight+" ";
	            }
	            s = s + NEXTLINE;
	            
	        }
	        return s.toString();
	    }
}