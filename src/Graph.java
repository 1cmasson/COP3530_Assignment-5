
public class Graph {
	
	
	class DirectExchange {
		int source, destination, weight;
		DirectExchange(){
			this.source = 0;
			this.destination = 0;
			this. weight = 0;
		}
	}
	
	int currencies, exchanges;
	DirectExchange directExchanges[];
	
	Graph(int currencies, int exchanges){
		this.currencies = currencies;
		this.exchanges = exchanges;
		directExchanges = new DirectExchange[exchanges];
		
		for(int i =0; i < exchanges; i++ ) {
			directExchanges[i] = new DirectExchange();
		}
	}
	
	
	void BellmanFord(Graph graph, int source) {
		int vector = graph.currencies;
		int edge = graph.exchanges;
		int distance[] = new int[vector];
		
		for(int i = 0; i < vector; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[source] = 0;
		
		for(int i = 1; i < vector; i++) {
			for(int j = 0; j < edge; j++){
				int u = graph.directExchanges[j].source;
				int v = graph.directExchanges[j].destination;
				int weight = graph.directExchanges[j].weight;
				
				if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
				}
			}
		}
	}
	
	
	
}
