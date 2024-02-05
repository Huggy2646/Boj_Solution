import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {

            LinkedList<Integer> password = new LinkedList<>();
            
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < size; i++) {
                password.add(Integer.parseInt(st.nextToken()));
            }

            int num = Integer.parseInt(br.readLine());

            String commands = br.readLine();
            st = new StringTokenizer(commands, " ");

            for (int i = 0; i < num; i++) {

                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int j = 0; j < y; j++) {
                    password.add(x, Integer.parseInt(st.nextToken()));
                    x++;
                }
            }

            System.out.printf("#%d ", testCase);
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ", password.get(i));
            }
            System.out.println();
        }
    }
}