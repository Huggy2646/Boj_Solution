import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			// 1일 이용권
			int day = Integer.parseInt(st.nextToken());
			// 한달 이용권
			int mon = Integer.parseInt(st.nextToken());
			// 3달 이용권
			int mon_3 = Integer.parseInt(st.nextToken());
			// 1년 이용권
			int year = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int [][]dp = new int[4][12];
			// 이용계획
			int []cost = new int[12];

			//1년 이용권은 항상 같기 때문에 처음부터 init
			for(int i=0; i<12; i++) {
				cost[i]=Integer.parseInt(st.nextToken());
				dp[3][i]=year;
			}
			
			//첫달 init
			if(cost[0]!=0) {
				dp[0][0]=cost[0]*day;
				dp[1][0]=mon;
				int buffer = mon_3;
				for(int k=0; k<3; k++) {
					if(13<=k)
						break;
					dp[2][k]=buffer;
				}
			}




			for(int i=1;i<12; i++) {
				//이용계획이 있는경우
				if(cost[i]!=0) {
					//1일 이용권 사용
					dp[0][i]=(Math.min(dp[0][i-1], Math.min(dp[1][i-1], Math.min(dp[2][i-1], dp[3][i-1]))))+(cost[i]*day);					
					//한달 이용권 사용
					dp[1][i]=(Math.min(dp[0][i-1], Math.min(dp[1][i-1], Math.min(dp[2][i-1], dp[3][i-1]))))+mon;
					//3달 이용권 사용
					//이 새끼 때문에 오래걸림
					/* 원래 코드
					 * if(dp[2][i]==0) {
					  		//전 달에 최소값을 더하고
							int buffer = Math.min(dp[0][i-1], Math.min(dp[1][i-1], Math.min(dp[2][i-1], dp[3][i-1])))+mon_3;
						 	//그냥 멍청하게 주르륵 저장쓰...
						 	for(int k=i; k<i+3; k++) {
								if(12<=k)
									break;
								dp[2][k]=buffer;
							}
						} 
					 * 3달 이용권은 3달 주르륵 사용하는 거니깐 그냥 아무생각없이 전달 최솟값 + 3달이용권 비용을 3달 연속으로 저장해버림;;
					 * 
					 * 그런데 이게 웬걸? 3달 이용권은 시간선이 다르게 흐른다는걸 새벽 1시쯤 발견을 해버렸네...?
					 * 
					 * 3달 이용권은 전달의 최소값을 하면 안되는 이유는 3달 이용권을 사용하고 있는 경우에 나온 최소값은 3달 이용권이랑 상관이 x
					 * 그리니깐 3달 전, 3달 이용권을 사용하기 전달의 최솟값을 구해서 더해줘야 됨
					 */
					if(0<=i-3) {
						int buffer = Math.min(dp[0][i-3], Math.min(dp[1][i-3], Math.min(dp[2][i-3], dp[3][i-3])))+mon_3;	
						dp[2][i]=buffer;
					}
					else
						dp[2][i]=mon_3;
					
				}
				//이용계획이 없는 경우 전달의 최소값을 가져옴
				else {
					dp[0][i]=dp[0][i-1];
					dp[1][i]=dp[1][i-1];
					dp[2][i]=dp[2][i-1];

				}

			}
			// 마지막까지 쭉 갔을 때 4개중 최소값이 최적
			sb.append("#").append(t+1).append(" ").append(Math.min(dp[0][11], Math.min(dp[1][11], Math.min(dp[2][11], dp[3][11])))).append("\n");
		}
		System.out.println(sb);
	}
}