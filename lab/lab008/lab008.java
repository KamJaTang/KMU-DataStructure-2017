import java.util.*;

// ---------- Graph class -------------

class Graph {
    int numofnodes;  // the number of nodes in the graph
    private int[][] AdjMatrix; // Adjacency matrix
    private int[] visited; // mark the visitied node
    private int[] mark;


    Graph() {
        // Graph constructor.
        numofnodes = 0;
    }

    void Init(int n) {
        numofnodes = n;
        // now create 2 dimensional array of numofnodes * numofnodes
        AdjMatrix = new int[numofnodes][numofnodes];
        for(int i = 0; i < numofnodes; i++) {
            // initialize all entries to 0
            for(int j = 0; j < numofnodes; j++)
                AdjMatrix[i][j] = 0;  // initialize the adjacency matrix
        }

    }


	void Edge(int n1, int n2) {
    AdjMatrix[n1][n2] = 1;
    AdjMatrix[n2][n1] = 1;

	}

	void Bfs(int v) {
    visited = new int[numofnodes];
    for(int i=0; i<numofnodes; i++){
      visited[i]=0;
    }

    Queue<Integer> q = new LinkedList<>();

    int cnt=0;

    q.add(v);

    while(!q.isEmpty()){
        if (visited[q.peek()]==0){
          visited[q.peek()]=1;

          for(int i=0; i<numofnodes; i++){
            if(visited[i]==0&&visited[i]==0&&AdjMatrix[q.peek()][i]==1&&AdjMatrix[i][q.peek()]==1){
              q.add(i);
            }
          }
          System.out.print(q.peek() + " ");
          q.poll();

        }

        else{
          q.remove();
        }
    }




	}


}
