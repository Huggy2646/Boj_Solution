import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static int [] result;
    static int N;
    static boolean[] visited;
    public static void permu(int level){
        if(level==N){
            for(int a:result){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                result[level]=i+1;
                permu(level+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        visited = new boolean[N];
        result = new int[N];
        permu(0);
    }
}