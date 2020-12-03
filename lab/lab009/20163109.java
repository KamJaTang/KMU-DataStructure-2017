// Lab 009	: Graph Floyd Algorithm
// Name :
// Student ID :

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Adjacency matrix
	private int[] dist; // dist array
	private int[] p; // p array

	final int LargeCost = 999999;

	Graph() {
		// Graph constructor.
		numofnodes = 0;
	}


	void Init(int n) {
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes
		CostAdj = new int[numofnodes][numofnodes];
		dist = new int[numofnodes];
		p = new int[numofnodes];

		for(int i = 0; i < numofnodes; i++) {
			// initialize all entries to 0
			for(int j = 0; j < numofnodes; j++)
				CostAdj[i][j] = LargeCost;  // initialize the adjacency matrix
			CostAdj[i][i] = 0;
		}
	}
	public String toString() {
		String str;
		int i = 0;
		str = "Dist : ";
		for(i = 0; i < numofnodes; i++)
			str +=  dist[i] + " ";
		str += "\n";

		str += "P    : ";
		for( i = 0; i < numofnodes; i++)
			str += p[i] + " ";
		str += "\n";

		// show the paths to all the destinations
		for( i = 0; i < numofnodes; i++) {
			str += "Path to " + i + " : ";
			str += OutPath(i);
			str += i + " ";
			str += "\n";
		}
		return str;
	}



	void Edge(int v1, int v2, int cost) {
		// NEED TO IMPLEMENT
		CostAdj[v1][v2] = cost;
	}


	String OutPath(int i) {
		String str = "";

		// NEED TO IMPLEMENT

		int next = 0;
		do{
			next = p[i];
			if (next == -1) break;
			str = next + " " + str;
			i = next;
		} while(true);

		return str;
	}

	void BellmanFord(int src) {

		// NEED TO IMPLEMENT

		for(int i=0; i<numofnodes; i++){
			p[i] = -1;
			dist[i] = LargeCost;
		}

		dist[src] = 0;

		for(int k=0; k<numofnodes;k++){
			for(int v=0; v<numofnodes; v++){
				for(int w=0; w<numofnodes; w++){
					if(dist[v]>dist[w] + CostAdj[w][v]){
						dist[v] = dist[w] + CostAdj[w][v];
						p[v] = w;
					}
				}
			}
		}
	}
}
