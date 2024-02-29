import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//입출력 처리
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 갯수 입력
		int T=Integer.parseInt(br.readLine());

		// 4개의 자석을 저장할 배열 
		List<Integer>[] ListArray = new ArrayList[4];

		//테스트 케이스 시작
		for(int t=0; t<T; t++) {
			int score=0;
			int K=Integer.parseInt(br.readLine());

			// 톱니바퀴 init
			for(int i=0; i<4; i++) {
				String[] buffer = br.readLine().split(" ");
				ListArray[i]=new ArrayList<>();
				// 톱니바퀴의 날 init
				for(int j=0; j<8; j++) {
					ListArray[i].add(Integer.parseInt(buffer[j]));
				}
			}

			// 명령어 시작
			for(int k=0; k<K ; k++) {
				String[] buffer = br.readLine().split(" ");
				int index = Integer.parseInt(buffer[0])-1;
				int cw_ccw = Integer.parseInt(buffer[1]);
				int cw_ccw_buffer=cw_ccw;

				// 톱니바퀴들이 돌려지는 상태
				int []change=new int[4];

				// 처음 돌리는 자석의 방향은 바로 저장
				change[index]=cw_ccw;
				
				// 처음 돌리는 자석 부터 처음 자석까지 
				for(int i=index; i>0; i--) {
					// 현재 자석의 7번째 날과 왼쪽의 자석의 3번째 날의 극을 비교
					if(ListArray[i].get(6)!=ListArray[i-1].get(2)) {
						// 다르다면 현재 돌리는 방향과 반대 방향으로 전환
						cw_ccw*=(-1);
						// 후 저장
						change[i-1]=cw_ccw;
					}
					else
						//같으면 더 이상 할 필요가 없어서 break
						break;
				}
				
				// 돌리는 방향 초기화
				cw_ccw=cw_ccw_buffer;
				
				// 처음 돌리는 자석 부터 마지막자석 까지
				for(int i=index; i<3; i++) {
					//현재 자석 3번째 날과 오른쪽 자석 7번째 날의 극을 비교
					if(ListArray[i].get(2)!=ListArray[i+1].get(6)) {
						//다르다면 반대방향으로 전환하고
						cw_ccw*=(-1);
						//저장
						change[i+1]=cw_ccw;
					}
					else
						//같으면 더 이상 할 필요가 없어서 break
						break;
				}

				// 자석마다 돌려지는 방향 확인 후 List 값 변환
				for(int i=0; i<4; i++) {
					//반시계 방향이면
					if(change[i]==-1) {
						//제일 앞의 data를 제일 뒤로 저장
						ListArray[i].add(ListArray[i].get(0));
						ListArray[i].remove(0);
					}

					//시계방향이면
					else if(change[i]==1) {
						//제일 뒤의 data를 제일 앞에 저장
						ListArray[i].add(0, ListArray[i].get(7));
						ListArray[i].remove(8);
					}
				}
			}
			
			// 자석들의 현재 상태에서 0번째 data가 0일 때 score계산
			for(int i=0; i<4; i++) {
				if(ListArray[i].get(0)==1)
					score+=Math.pow(2,i);
			}
			sb.append("#").append(t+1).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}

}