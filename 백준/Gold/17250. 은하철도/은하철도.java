import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int parent;
		int size;
		public Node(int parent, int size) {
			super();
			this.parent = parent;
			this.size = size;
		}
		@Override
		public String toString() {
			return "Node [parent=" + parent + ", size=" + size + "]";
		}
		
	}

	private static Node[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new Node[N+1];
		for(int n=1; n<=N; n++) {
			parents[n]=new Node(n,Integer.parseInt(br.readLine()));
		}
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(union(a,b));

		}
	}

	private static int union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		// root가 다르면 새로 연결된 경우라 방문 할 수 있는 행성의 수 업데이트 후 return
		// root가 같으면 이미 연결되어있는 경우라 방문 할 수 있는 행성의 수는 그대로
		if(aroot!=broot) {
			if(aroot<broot) {
				parents[broot].parent=aroot;
				parents[aroot].size += parents[broot].size;
				return parents[aroot].size;
			}
			else {
				parents[aroot].parent=broot;
				parents[broot].size += parents[aroot].size;
				return parents[broot].size;
			}
		}
		else {
			if(aroot<broot) {
				return parents[aroot].size;
			}
			else {
				return parents[broot].size;
			}
		}
		
	}

	private static int find(int num) {
		if(num==parents[num].parent)
			return num;
		return parents[num].parent=find(parents[num].parent);
	}
}