import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Main {
	static Set<Integer> s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] Ndkc = br.readLine().split(" ");
		int N= Integer.parseInt(Ndkc[0]);
		int d= Integer.parseInt(Ndkc[1]);
		int k= Integer.parseInt(Ndkc[2]);
		int c= Integer.parseInt(Ndkc[3]);
		int max = Integer.MIN_VALUE;
		int buffer_max=0;
		int []count = new int[d+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> window = new ArrayDeque<>();
		for(int n=0; n<N; n++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
		for(int i=0; i<k; i++) {
			window.offer(queue.peek());
			if(count[queue.peek()]==0) {
				buffer_max++;
			}
			count[queue.peek()]++;
			queue.poll();
		}
		
		if(count[c]==0) {
			max = max<buffer_max+1? buffer_max+1:max;
		}
		else
			max = max<buffer_max? buffer_max:max;
		
		for(int i=0; i<N; i++) {
			int a = window.poll();
			queue.add(a);
			count[a]--;
			if(count[a]==0) {
				buffer_max--;
			}
			window.offer(queue.peek());
			if(count[queue.peek()]==0) {
				buffer_max++;
			}
			count[queue.peek()]++;
			queue.poll();
			if(count[c]==0) {
				max = max<buffer_max+1? buffer_max+1:max;
			}
			else
				max = max<buffer_max? buffer_max:max;
		}
		System.out.println(max);
	}

}