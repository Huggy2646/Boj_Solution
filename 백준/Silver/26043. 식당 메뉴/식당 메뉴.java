import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static class Student implements Comparable<Student>{
		int num;
		int good;
		public Student(int num, int good) {
			this.num = num;
			this.good = good;
		}
		@Override
		public String toString() {
			return "student [num=" + num + ", good=" + good + "]";
		}
		
		@Override
		public int compareTo(Student e) {
			return Integer.compare(this.num, e.num);
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Student> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Student> a = new PriorityQueue<>();
		PriorityQueue<Student> b = new PriorityQueue<>();
		for(int n=0; n<N; n++) {
			String[] input = br.readLine().split(" ");
			if(input.length==3) {
				int num = Integer.parseInt(input[1]);
				int good = Integer.parseInt(input[2]);
				q.offer(new Student(num,good));
			}
			else if(input.length==2) {
				Student student= q.poll();
				int food = Integer.parseInt(input[1]);
				if(student.good==food) {
					a.offer(student);
				}
				else {
					b.offer(student);
				}
			}
		}
		
		PriorityQueue<Student> c = new PriorityQueue<>(q);

		
		StringBuilder sb = new StringBuilder();
		
		if(a.isEmpty()) {
			sb.append("None");
		}
		else {
			while(!a.isEmpty()) {
				sb.append(a.poll().num).append(" ");
			}
		}
		sb.append("\n");
		
		if(b.isEmpty()) {
			sb.append("None");
		}
		else {
			while(!b.isEmpty()) {
				sb.append(b.poll().num).append(" ");
			}
		}
		sb.append("\n");
		
		
		if(c.isEmpty()) {
			sb.append("None");
		}
		else {
			while(!c.isEmpty()) {
				sb.append(c.poll().num).append(" ");
			}
		}
		sb.append("\n");
		
		System.out.println(sb.toString());

	}
	

}