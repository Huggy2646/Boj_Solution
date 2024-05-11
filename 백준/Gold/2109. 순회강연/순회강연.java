import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		// index 0 : pay, index 1 : time
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[0], o1[0]);
			}
		});
		for(int n=0; n<N; n++) {
			st =new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {p,d});
		}
		boolean[] visited = new boolean[10001];
		int result=0;
		while(!pq.isEmpty()) {
			int [] buffer = pq.poll();
			int p = buffer[0];
			int d = buffer[1];
//			System.out.println("p: "+p+" d: "+d);
			if(!visited[d]) {
				visited[d]=true;
				result+=p;
			}
			else {
				for(int i=d-1; 1<=i; i--) {
					if(!visited[i]) {
						visited[i]=true;
						result+=p;
						break;
					}
				}
			}

		}
		System.out.println(result);

	}

}