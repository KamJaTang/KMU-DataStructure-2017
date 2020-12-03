import java.util.*;

/**
 */

class WinnerTree  {
	int[] tree; // Winner tree

	int capacity;	// size of the tree
	int n;	// number of external elements in WinnerTree


	WinnerTree(int theCapacity) { // WinnerTree constructor.
		capacity = theCapacity;
		tree = new int[capacity];	// tree[0] is not used
		n = 0;
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
		str = "WT : - ";

		// print all the nodes in the tree
		for(int i = 1; i < n * 2; i++)
			str += tree[i] + "  ";
		return str;

	}

	void  Init(int[] treedata, int nitems) {
		// initialize the tree by using the input
		n = nitems / 2;

		int i = 1;
		for(i = 1; i < nitems; i++) {
			tree[i] = treedata[i];
		}
	}

	void PopNReplace(int data) {
		// NEED TO IMPLEMENT
		int root;
		root = tree[1];
		int i=n;

		while(true){
			if(tree[i]==root){
				tree[i]=data;
				break;
			}
			i++;
		}

		while(true){
			while(true){
				if(i==1) break;
				
				if(i%2==0){
					if(data<=tree[i+1]){
						i=i/2;
						tree[i]=data;
					}
					else break;
				}
				else{
					if(data<=tree[i-1]){
						i=(i-1)/2;
						tree[i]=data;
					}
					else break;
				}
			}

			if(i!=1){
				if(i%2==0) i=i+1;
				else i=i-1;
				data=tree[i];
			}
			else break;
		}
	}

}
