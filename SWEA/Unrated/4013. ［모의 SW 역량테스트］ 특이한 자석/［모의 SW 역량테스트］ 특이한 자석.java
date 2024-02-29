import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		List<Integer>[] ListArray = new ArrayList[4];
		
		for(int t=0; t<T; t++) {
			int score=0;
			int K=Integer.parseInt(br.readLine());
			for(int i=0; i<4; i++) {
				String[] buffer = br.readLine().split(" ");
				ListArray[i]=new ArrayList<>();
				for(int j=0; j<8; j++) {
					ListArray[i].add(Integer.parseInt(buffer[j]));
				}
			}
			for(int k=0; k<K ; k++) {
				String[] buffer = br.readLine().split(" ");
				int index = Integer.parseInt(buffer[0])-1;
				int cw_ccw = Integer.parseInt(buffer[1]);
				int cw_ccw_buffer=cw_ccw;
				int []change=new int[4];
				//				if(index==0) {
				change[index]=cw_ccw;

				for(int i=index; i>0; i--) {
					// 돌리는 곳 부터 처음까지
					int buffer_start=ListArray[i-1].get(2);
					if(ListArray[i].get(6)!=ListArray[i-1].get(2)) {
						cw_ccw*=(-1);
						change[i-1]=cw_ccw;
					}
					else
						break;
					//					start=ListArray[i-1].get(2);
				}
				cw_ccw=cw_ccw_buffer;
				for(int i=index; i<3; i++) {
					// 돌리는 곳 부터 마지막까지
					if(ListArray[i].get(2)!=ListArray[i+1].get(6)) {
						cw_ccw*=(-1);
						change[i+1]=cw_ccw;
						
					}
					else
						break;
					//					start=ListArray[i].get(2);
				}
				for(int i=0; i<4; i++) {
					if(change[i]==-1) {
						ListArray[i].add(ListArray[i].get(0));
						ListArray[i].remove(0);
					}
					else if(change[i]==1) {
						ListArray[i].add(0, ListArray[i].get(7));
						ListArray[i].remove(8);
					}
				}
				//				}

			}
			for(int i=0; i<4; i++) {
				if(ListArray[i].get(0)==1)
					score+=Math.pow(2,i);
			}
			sb.append("#").append(t+1).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}

}