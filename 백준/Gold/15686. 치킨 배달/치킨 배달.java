import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[][] grid;
    static int N, M;
    static List<int[]> store_posi;
    static List<int[]> home_posi;
    static int[][] result;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void make_combi(int level, int start) { // 레벨과 시작 인덱스를 추가로 전달받도록 수정합니다.
        if (level == M) {
            int degree = 0;
            for (int i = 0; i < home_posi.size(); i++) {
                int buffer_min = Integer.MAX_VALUE;
                for (int j = 0; j < result.length; j++) {
                    int buffer_degree = Math.abs(home_posi.get(i)[0] - result[j][0])
                            + Math.abs(home_posi.get(i)[1] - result[j][1]);
                    buffer_min = buffer_degree < buffer_min ? buffer_degree : buffer_min;
                }
                degree += buffer_min;
            }
            min = Math.min(degree, min); // 최소 거리를 갱신할 때 Math.min() 함수를 사용하여 수정합니다.
            return;
        }

        for (int i = start; i < store_posi.size(); i++) { // 시작 인덱스부터 반복하도록 수정합니다.
            if (!visited[i]) {
                visited[i] = true;
                result[level][0] = store_posi.get(i)[0];
                result[level][1] = store_posi.get(i)[1];
                make_combi(level + 1, i + 1); // 다음 레벨과 시작 인덱스를 전달하도록 수정합니다.
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // System.setIn(new FileInputStream("res/boj_15686_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        grid = new int[N][N];

        result = new int[M][2];
        store_posi = new ArrayList<int[]>();
        home_posi = new ArrayList<int[]>();

        for (int n = 0; n < N; n++) {
            grid[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < N; i++) {
                if (grid[n][i] == 2) {
                    int[] buffer = { n, i };
                    store_posi.add(buffer);
                } else if (grid[n][i] == 1) {
                    int[] buffer = { n, i };
                    home_posi.add(buffer);
                }
            }

        }
        visited = new boolean[store_posi.size()];
        make_combi(0, 0); // 시작 인덱스를 0으로 전달합니다.
        System.out.println(min);
    }
}