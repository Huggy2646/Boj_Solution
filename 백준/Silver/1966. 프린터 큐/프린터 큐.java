import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		int num;
		int value;

		public Node(int a, int b) {
			this.num = a;
			this.value = b;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int caseNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < caseNum; i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			Queue<Node> nodeQueue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int numSize = Integer.parseInt(st.nextToken());
			int findIndex = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			for (int ns = 0; ns < numSize; ns++) {
				Node node = new Node(ns, Integer.parseInt(st.nextToken()));
				nodeQueue.offer(node);
				pq.offer(node.value);
			}

			int max = pq.poll();
			int cnt = 1;
			while (true) {
				Node node = nodeQueue.poll();
				if (max == node.value && node.num == findIndex) {
					sb.append(cnt).append("\n");
					break;
				} else {
					if (max == node.value) {
						max = pq.poll();
						cnt++;
					} else {
						nodeQueue.offer(node);
					}

				}
			}
		}
		System.out.println(sb);
	}
}