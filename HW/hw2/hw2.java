// HW 172 : Dijkstra's Algorithm
// Name : 박재효
// Student ID : 20163109

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Cost Adjacency matrix
	private int[] d; // d array
	private int[] p; // p array
	int source;	// source node

	final int LargeCost = 999999;

	Graph() {
		// Graph constructor.
		numofnodes = 0;
	}

	void Init(int n) {
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes

		CostAdj = new int[numofnodes][numofnodes];

		for(int i = 0; i < numofnodes; i++) {
			for(int j = 0; j < numofnodes; j++) {
				CostAdj[i][j] = LargeCost;
			}
			CostAdj[i][i] = 0;
		}
		// now create d[] and p[]
		d = new int[numofnodes];
		p = new int[numofnodes];

	}



	void Edge(int v1, int v2, int cost) {
		//	"NEED TO IMPLEMENT"
		CostAdj[v1][v2] = cost;

	}

	void Dijk(int src) {
		//	"NEED TO IMPLEMENTr"
		source = src;

		int[] visit;
		visit = new int[numofnodes];

		int cnt=0;
		int new_vert=0;
		for(int i=0; i<numofnodes; i++){
			d[i] = CostAdj[source][i];
			if(d[i]!=LargeCost&&d[i]!=0) p[i] = source;
			else p[i] = -1;
			visit[i] = 0;
		}

		d[source] = 0;
		visit[source] = 1;

		System.out.print("d : ");
		for(int i=0; i<numofnodes; i++){
			System.out.print(d[i] + " ");
		}
		System.out.print("\n" + "p : ");
		for(int i=0; i<numofnodes; i++){
			System.out.print(p[i] + " ");
		}
		System.out.print("\n");

		for(int i=0; i<numofnodes-1; i++){
			for(int j=0; j<numofnodes; j++)
				if(d[j]!=0 && visit[i]==0){
					new_vert=j;
					break;
				}
			for(int j=0; j<numofnodes; j++){
				if(d[j]<d[new_vert]&&visit[j]==0&&d[j]!=0) new_vert=j;
			}
			visit[new_vert] = 1;
			for(int j=0; j<numofnodes; j++){
				if(visit[j]==0){
					if(d[j]>d[new_vert]+CostAdj[new_vert][j]){
						d[j] = d[new_vert]+CostAdj[new_vert][j];
						p[j] = new_vert;
					}
				}
			}
			System.out.print("d : ");
			for(int j=0; j<numofnodes; j++){
				System.out.print(d[j] + " ");
			}
			System.out.print("\n");
			System.out.print("p : ");
			for(int j=0; j<numofnodes; j++){
				System.out.print(p[j] + " ");
			}
			System.out.print("\n");
		}
	}

	void ShowAllPath() {
		//	"NEED TO IMPLEMENT"
		Stack<Integer> q = new Stack<>();
		for(int i=0; i<numofnodes; i++){
			int j;

			if(i!=source){
				System.out.print("Path " + source + " to " + i + " : " + source);
				if(p[i]==source) System.out.println("-"+i+" => " + d[i]);
				else{
					j=i;
					while(true){
						if(j==source) break;
						else q.push(j);
						j=p[j];
					}

					while(!q.isEmpty()) System.out.print("-"+q.pop());

					System.out.println(" => " + d[i]);
				}
			}
		}
	}

}
