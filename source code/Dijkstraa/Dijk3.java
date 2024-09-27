package Dijkstraa;

public class Dijk3 {

public static void main(String[] args) {
	int testing_number_of_vertices = 6;
//test 1
	int testing_graph[][] = new int[][] { { -1, 24, 5, 10, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, 1, 30, 10 }, { -1, -1, -1, -1, -1, 8 }, { -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, 20, -1 } };

	Dijk3 test1 = new Dijk3(testing_graph, testing_number_of_vertices);
	test1.applyAlgorithm(0);
	System.out.println("test 1 distances");
	test1.printDistances();

}

private int number_of_vertices;
private int source;
private int[] distances;
private boolean[] visited;
private int[][] graph;

public Dijk3(int[][] graph, int number_of_vertices) {
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

public int findMinDistance() {
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
        System.out.println("Invalid source vertex.");
        return;
    }
    this.source = source;
    
    distances[source] = 0;

    for (int count = 0; count < number_of_vertices - 1; count++) {
        int u = findMinDistance();
        visited[u] = true;

        for (int v = 0; v < number_of_vertices; v++) {
            if (!visited[v] 
                && graph[u][v] > -1 
                && distances[u] != Integer.MAX_VALUE 
                && distances[u] + graph[u][v] < distances[v]
                ) 
            {
                distances[v] = distances[u] + graph[u][v];
            }
        }
    }
}

public void printDistances() {

	if (source == -1) {
		System.out.println("The algorithm isn't applyed");
		return;
	}
	for (int i = 0; i < number_of_vertices; i++) {
		System.out.println("the minimum distance between " + source + " and " + i + " is " + distances[i]);
	}
}


}
