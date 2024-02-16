import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 1;
    static int rowSize;
    static int colSize;
    static char[][] grid;
    static boolean[] visited;

    public static void dfs(int row, int col, int level) {
        visited[grid[row][col] - 'A'] = true;
        max = Math.max(max, level);
        if (max >= rowSize * colSize) {
            return;
        }

        // 상
        if (row - 1 >= 0 && !visited[grid[row - 1][col] - 'A']) {
            dfs(row - 1, col, level + 1);
        }

        // 하
        if (row + 1 < rowSize && !visited[grid[row + 1][col] - 'A']) {
            dfs(row + 1, col, level + 1);
        }

        // 좌
        if (col - 1 >= 0 && !visited[grid[row][col - 1] - 'A']) {
            dfs(row, col - 1, level + 1);
        }

        // 우
        if (col + 1 < colSize && !visited[grid[row][col + 1] - 'A']) {
            dfs(row, col + 1, level + 1);
        }

        visited[grid[row][col] - 'A'] = false; // 백트래킹을 위해 방문 여부 초기화
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] RC = br.readLine().split(" ");
        rowSize = Integer.parseInt(RC[0]);
        colSize = Integer.parseInt(RC[1]);
        grid = new char[rowSize][];
        visited = new boolean[26]; // 알파벳 개수에 해당하는 크기로 visited 배열 초기화

        for (int i = 0; i < rowSize; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // dfs start
        dfs(0, 0, 1);

        System.out.println(max);
    }
}