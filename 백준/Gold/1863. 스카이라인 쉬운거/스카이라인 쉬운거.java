import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> heights = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            heights.add(y);
        }
        heights.add(0);

        for (int i = 0; i < heights.size(); i++) {
            while (!stack.empty() && stack.peek() >= heights.get(i)) {
                if (stack.peek() > heights.get(i)) count++;
                stack.pop();
            }
            stack.push(heights.get(i));
        }
        System.out.println(count);
    }
}