package graph;



public class WeightedEdge {
  public int start, end;
  public float weight;

  public WeightedEdge(int start, int end, float weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }
}