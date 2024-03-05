import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N=0;
    static int M=0;
    static boolean [] visited;
    static int [] result;
    static List<Integer>numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        result = new int[M];
        visited = new boolean [100000];
        st = new StringTokenizer(br.readLine()," ");
        //중복되는 것을 제외하고 list에 저장
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            if(!visited[num]){
                visited[num]=true;
                numbers.add(num);
            }
        }
        // 사전 순으로 결과를 받으려고 sorting
        Collections.sort(numbers);
        combi(0,0);
        System.out.println(sb);
    }

    //중복조합
    public static void combi(int level,int start){
        if(level==M){
            for(int a:result){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 중복제거한 list의 크기만큼 반복
        for(int i=start; i<numbers.size(); i++){
            result[level]=numbers.get(i);
            combi(level+1,i);
        }

    }
}