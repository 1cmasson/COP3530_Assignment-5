
public class Graph {
	
	class Edge{
		int source, destination , weight;
		
		Edge(){
			source = destination = weight = 0;
		}
	};
	
	int V, E;
	Edge edge[];
	
	Graph(int vertices, int edges){
		V = vertices;
		E = edges;
		edge = new Edge[edges];
		
		for(int i =0; i < edges; i++) {
			edge[i]= new Edge();
		}
	}
	

	

	
}
