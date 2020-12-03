import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Cost Adjacency matrix
	private int[] d;
	private int[] p;
	private int[] check;
	int source;

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
		CostAdj[v1][v2] = cost;
	}

	void Dijk(int src) {
		source = src;
		check = new int[numofnodes];
		int min;
		int newVertex=0;

		for ( int i = 0; i < numofnodes; i++) {
			check[i] = 0;
			d[i] = CostAdj[source][i];

			if ( CostAdj[source][i] == 0 || CostAdj[source][i] == LargeCost )
				p[i] = -1;
			else
				p[i]=source;
		}

		System.out.print("d : ");
		for ( int i=0; i<numofnodes; i++ )
			System.out.print(d[i] + " ");
		System.out.print("\np : ");
		for ( int i=0; i<numofnodes; i++)
			System.out.print(p[i] + " ");
		System.out.println();

		check[source]=1;


		for ( int i = 1; i < numofnodes; i++ )
		{
			min = LargeCost;

			for ( int j = 0; j < numofnodes; j++ )
			{
				if ( min > d[j] && check[j] != 1)
				{
					min = d[j];
					newVertex = j;
				}
			}

			check[newVertex] = 1;

			for ( int j = 0; j < numofnodes; ++j )
			{
				if( check[j] != 1)
				{
					if( min + CostAdj[newVertex][j] < d[j])
					{
						d[j] = min + CostAdj[newVertex][j];
						p[j] = newVertex;
					}
				}
			}

			System.out.print("d : ");
			for ( int item : d )
				System.out.print(item + " ");
			System.out.print("\np : ");
			for ( int item : p )
				System.out.print(item + " ");
			System.out.println();
		}
	}

	void ShowAllPath() {
		Stack<Integer> q = new Stack<>();
		for ( int i = 0; i < numofnodes; i++)
		{
			int j;

			if ( i != source) {
				System.out.print("Path " + source + " to " + i + " : " + source);
				if ( p[i] == source )
					System.out.println("-" + i + " => " + d[i]);
				else
				{
					j = i;
					while ( true )
					{
						if ( j == source ) break;
						if( j != source) q.push(j);
						j=p[j];
					}

					while ( !q.isEmpty() )
						System.out.print("-" + q.pop());

					System.out.println(" => " + d[i]);
				}
			}
		}

	}
}
