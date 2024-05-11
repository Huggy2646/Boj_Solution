import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	static class Edge implements Comparable<Edge> {
		int my;
		int next;
		int w;

		public Edge(int my, int next, int w) {
			super();
			this.my = my;
			this.next = next;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {

			return Integer.compare(this.w, o.w);
		}

	}

	private static int[] parents;
	private static char[][] grid;
	private static int[] weight;
	private static int result;
	private static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// grid init
		for (int n = 0; n < N; n++) {
			String row = br.readLine();
			for (int c = 0; c < N; c++) {
				if (row.charAt(c) != '0') {
					int input = row.charAt(c);
					if (input >= 97)
						input -= 96;
					else
						input -= 38;
					if (n == c)
						result += input;
					else {

						pq.offer(new Edge(n, c, input));
					}

				}

			}
		}
		// grid init end
		parents = new int[N];
//		weight = new int[N];

		for (int n = 0; n < N; n++) {
			parents[n] = n;
		}
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int my = e.my;
			int next = e.next;
			int w = e.w;
			union(my, next, w);
		}

		if (cnt == N - 1)
			System.out.println(result);
		else
			System.out.println(-1);

	}

	private static boolean union(int i, int j, int w) {
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot) {
			result += w;
			return false;
		}
		if (iroot < jroot) {
			parents[jroot] = iroot;
		}

		else
			parents[iroot] = jroot;
		cnt++;
		return true;

	}

	private static int find(int j) {
		if (parents[j] == j)
			return j;
		return parents[j] = find(parents[j]);
	}

}