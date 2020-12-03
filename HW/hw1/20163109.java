import java.util.*;

// offset
/**
 * Maze Class
 *
 */

class Maze {

	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking

	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}


	public void Path(int m, int p) {
		int[] a = {0,1,-1,-1,-1,0,1,1};
		int[] b = {1,1,1,0,-1,-1,-1,0};

		Stack<Integer> walk = new Stack<>();
		Stack<Integer> prt = new Stack<>();

		int i=1, j=1; // 초기 위치
		walk.push(i);
		walk.push(j);

		int g, h; // 이동한 위치

			// 미로의 길을 찾을 때까지 돈다.
		while(true){
			int scc=0;
			int dir=0; // 방향. 동쪽으로 초기화
			int s=0;

			// 현재 위치에서 8방향을 살핌
			while(true){
				// 이동한 좌표
				g=i+a[dir];
				h=j+b[dir];

				// 도착 했을 때
				if((m==g)&&(p==h)){
					walk.push(g);
					walk.push(h);
					while(!walk.empty()){
						prt.push(walk.peek());
						walk.pop();
					}
					while(!prt.empty()){
						System.out.print("("+prt.peek());
						prt.pop();
						System.out.println(","+prt.peek()+")");
						prt.pop();
					}
					scc++;
					break;
				}

				// 길이 있을 때.
				if((maze[g][h]==0)&&(mark[g][h]==0)){
					mark[g][h]=1;
					walk.push(g);
					walk.push(h);
					i=g;
					j=h;
					break;
				}

					// 길이 없을 떼.
				else{
					dir++;
				}

				// 갈 길이 없을 때
				if(dir>=8){
					if(walk.empty()){
						System.out.println("No path in maze.");
						scc++;
						break;
					}
					else{
						walk.pop();
						walk.pop();
						j=walk.peek();
						walk.pop();
						i=walk.peek();
						walk.push(j);
						break;
					}
				}
			}

			if(scc==1){
				break;
			}
		}
	}
};
