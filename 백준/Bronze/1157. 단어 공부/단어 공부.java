import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		input = input.toUpperCase();
		Map<Character, Integer> map = new HashMap<>();
		List<Character> list = new LinkedList<>();
		int maxCount = Integer.MIN_VALUE;
		char maxC = 0;
		int count=0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (map.get(c) == null) {
				map.put(c, 1);
				list.add(c);
			} else {
				map.put(c, map.get(c) + 1);
			}

		}
		for(int i=0; i<list.size(); i++) {
			if(maxCount<map.get(list.get(i))) {
				maxCount=map.get(list.get(i));
				maxC = list.get(i);
				count=0;
			}
			else if(maxCount==map.get(list.get(i))) {
				count++;
			}
		}
		if(count==0)
			System.out.println(maxC);
		else
			System.out.println('?');
	}

}