package Dijkstraa;

public class Dijk2 {
	

	

		public static void main(String[] args) {
			int testing_number_of_vertices = 6;
	//test 1
			int testing_graph[][] = new int[][] {
				{ -1, 24, 5, 10, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, 1, 30, 10 },
				{ -1, -1, -1, -1, -1, 8 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, 20, -1 } };

			Dijk2 test1 = new Dijk2(testing_graph,testing_number_of_vertices);
			test1.applyAlgorithm(0);
			System.out.println("test 1 distances");
			test1.printDistances();
			
//test 2
			Dijk2 test2 = new Dijk2(testing_number_of_vertices);
			test2.addEdge(0, 1, 24);
			test2.addEdge(0, 2, 5);
			test2.addEdge(0, 3, 10);
			test2.addEdge(2, 3, 1);
			test2.addEdge(2, 4, 30);
			test2.addEdge(2, 5, 10);
			test2.addEdge(3, 5, 8);
			test2.addEdge(5, 4, 20);
			test2.applyAlgorithm(0);
			
			System.out.println("\n_______________________________________\n");
			
			System.out.println("test 2 distances");
			test2.printDistances();

			
		}
		private int number_of_vertices;
		private int source;
		private int[] distances;
		private boolean[] visited;
		private int[][] graph;

		public Dijk2(int[][] graph, int number_of_vertices) {
			if (number_of_vertices < 1) {
				throw new IllegalArgumentException("Number of vertices should be at least 1.");
			}
			this.source = -1;  
			this.number_of_vertices = number_of_vertices;
			this.distances = new int[number_of_vertices];
			this.visited = new boolean[number_of_vertices];
			this.graph = new int[number_of_vertices][number_of_vertices];
			
			for (int i = 0; i < number_of_vertices; i++) {

				this.distances[i] = Integer.MAX_VALUE;
				this.visited[i] = false;

				for (int j = 0; j < number_of_vertices; j++) {
					
					this.graph[i][j] = graph[i][j];
				}

			}
		}

		public Dijk2(int number_of_vertices) {
			if (number_of_vertices < 1) {
				throw new IllegalArgumentException("Number of vertices should be at least 1.");
	
			}
	
			this.source = -1;
			this.number_of_vertices = number_of_vertices;
			distances = new int[number_of_vertices];
			visited = new boolean[number_of_vertices];
			graph = new int[number_of_vertices][number_of_vertices];
	
			for (int i = 0; i < number_of_vertices; i++) {
				distances[i] = Integer.MAX_VALUE;
				visited[i] = false;
	
				for (int j = 0; j < number_of_vertices; j++) {
					graph[i][j] = -1;
				}
			}
	
		}

		// add edges--> Two D A???
		public void addEdge(int source, int destination, int weight) // undirected graph
		{
			if (source < 0 || source >= number_of_vertices || destination < 0) {
				System.out.println();
				return;
			}
	
			graph[source][destination] = weight;
			//graph[destination][source] = weight;
		}

		public int findMinDistance() 
		{
			int minDistance = Integer.MAX_VALUE;
			int minDistanceVertex = -1;

			for (int v = 0; v < number_of_vertices; v++) {
				if (!visited[v] && distances[v] < minDistance) {
					minDistance = distances[v];
					minDistanceVertex = v;
				}
			}

			return minDistanceVertex;

		}

		public void applyAlgorithm(int source) {
			if (source < 0 || source >= number_of_vertices) {
				System.out.println("invalid source vertex.");
				return;
			}

			this.source = source; 
			distances[source] = 0; // start vertex has the shortest distance from its self =0
			for (int count = 0; count < number_of_vertices - 1; count++) { //visited
				int u = findMinDistance();  //show the adjacent vertices then convert it to visited vertex
				visited[u] = true;  //visited
				
				if(distances[u] != Integer.MAX_VALUE)
				{
					continue;
				}
				
				for (int v = 0; v < number_of_vertices; v++)  //visited[0] is true --> !true --> false no change the distance 
				{
					if (!visited[v] && graph[u][v] > -1 && distances[u] + graph[u][v] < distances[v]) 
					{
						distances[v] = distances[u] + graph[u][v];
					}
				}
			}
		}

		public void printDistances() 
		{

			if (source == -1) 
			{
				System.out.println("The algorithm isn't applyed");
				return;
			}
			for (int i = 0; i < number_of_vertices; i++) {
				System.out.println("the minimum distance between " + source + " and " + i + " is " + distances[i]);
			}
		}

	}


