import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class kingdom {
		int my;
		int parent;
		int len;

		public kingdom(int my, int parent, int len) {
			super();
			this.my = my;
			this.parent = parent;
			this.len = len;
		}

		public kingdom() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "kingdom [my=" + my + ", parent=" + parent + ", len=" + len + "]";
		}

	}

	static int[][] relations;
	static kingdom[] kingdoms;
	private static int C;
	private static int H;
	private static int K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		relations = new int[M][2];
		kingdoms = new kingdom[N+1];

		for (int i = 1; i < N + 1; i++) {
			kingdoms[i] = new kingdom(i, i, 1);
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relations[m][0] = a;
			relations[m][1] = b;
		}
		st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int[] relation : relations)
			union(relation[0], relation[1]);

		PriorityQueue<kingdom> pq= new PriorityQueue<kingdom>(new Comparator<kingdom>() {

			@Override
			public int compare(kingdom o1, kingdom o2) {
				
				return Integer.compare(o2.len, o1.len);
			}
			
		});
		
		for(int i=1; i<N+1; i++) {
			if(kingdoms[i].my==kingdoms[i].parent)
				pq.offer(kingdoms[i]);
		}
		
		int cnt=0;
		while(true) {
			if(pq.isEmpty() || cnt==K)
				break;
			kingdom kd = pq.poll();
			if(kd.my==H || kd.my==C)
				continue;
			union(C, kd.my);
			cnt++;
		}
		
		System.out.println(kingdoms[C].len);
			
	}

	private static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if (aroot == broot)
			return false;
		else {
			if (a == C || a == H) {
				kingdoms[broot].parent = kingdoms[aroot].parent;
				kingdoms[aroot].len += kingdoms[broot].len;
				kingdoms[broot].len = 0;
			}

			else {
				kingdoms[aroot].parent = kingdoms[broot].parent;
				kingdoms[broot].len += kingdoms[aroot].len;
				kingdoms[aroot].len = 0;
			}
			return true;
		}

	}

	private static int find(int num) {
		if (kingdoms[num].parent == num)
			return num;
		return kingdoms[num].parent = find(kingdoms[num].parent);
	}

}