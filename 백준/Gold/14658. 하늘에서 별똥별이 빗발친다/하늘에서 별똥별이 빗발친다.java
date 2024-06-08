import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] stars = new int[K][2];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine()," ");
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stars, (a, b) -> a[0] - b[0]);

        int maxCatch = 0;
        for(int i = 0; i < K; i++) {
            int endX = Math.min(N, stars[i][0] + L);
            for(int j = 0; j < K; j++) {
                int endY = Math.min(M, stars[j][1] + L);
                int count = 0;
                for(int[] star : stars) {
                    if(star[0] >= stars[i][0] && star[0] <= endX && star[1] >= stars[j][1] && star[1] <= endY) {
                        count++;
                    }
                }
                maxCatch = Math.max(maxCatch, count);
            }
        }

        System.out.println(K - maxCatch);
    }
}