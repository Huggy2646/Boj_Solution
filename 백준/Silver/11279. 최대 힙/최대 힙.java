import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> p_queue = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o1-o2)*-1;
			}
		});
		for(int i=0; i<N; i++) {
			int inp_data=Integer.parseInt(br.readLine());
			switch (inp_data){
				case 0:
					if(p_queue.isEmpty()) {
						sb.append(0).append("\n");
					}
					else {
						sb.append(p_queue.poll()).append("\n");
					}
					break;
				default:
					p_queue.offer(inp_data);
			}
		}
		System.out.println(sb);
	}

}