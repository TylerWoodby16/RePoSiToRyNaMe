package graph;

public class PrimsAlgorithm {
    private int[] parent;
    private float[] key;
    private boolean[] mstSet;
    private WeightedUndirectedGraph G;
        
    //vertices connected to the source
    public PrimsAlgorithm(WeightedUndirectedGraph G) {

        this.G = G;

        mstSet = new boolean[G.getV()];
        key = new float[G.getV()];
        parent = new int[G.getV()];

            // Initialize all keys as INFINITE  
        for (int i = 0; i < G.getV(); i++) {
            key[i] = 10000000;
            mstSet[i] = false;
        }  
      
        key[0] = 0;  
        parent[0] = -1;   
    }

    //Depth first search
    public void computeMst() {
        for (int count = 0; count < this.G.getV() - 1; count++) 
        {  
            // Pick the minimum key vertex from the  
            // set of vertices not yet included in MST  
            int u = this.minKey();  
      
            // Add the picked vertex to the MST Set  
            this.mstSet[u] = true;  
      
            // Update key value and parent index of  
            // the adjacent vertices of the picked vertex.  
            // Consider only those vertices which are not  
            // yet included in MST  
            Iterable<WeightedEdge> edges = this.G.getAdjacent(u);
            for (WeightedEdge edge : edges) { 
      
                // graph[u][v] is non zero only for adjacent vertices of m  
                // mstSet[v] is false for vertices not yet included in MST  
                // Update the key only if graph[u][v] is smaller than key[v]
                if (!mstSet[edge.end] && edge.weight < key[edge.end]) {
                    parent[edge.end] = u; 
                    key[edge.end] = edge.weight;  
                }
                //if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])  
            }  
        }
    }

    public void printMST()  
    {  
        System.out.println("Edge \tWeight\n");  
        for (int i = 1; i < this.G.getV(); i++)  
            System.out.println(parent[i] + " - " + i + " \t" + key[i] + " \n"); 
    }  

    private int minKey()  
    {  
        // Initialize min value  
        float min = 10000000;
        int min_index = 0;  
      
        for (int v = 0; v < this.G.getV(); v++)  
            if (this.mstSet[v] == false && this.key[v] < min) {
                min = key[v]; 
                min_index = v;  
            }
      
        return min_index;  
    }  
  
}

