import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> map = new HashMap<>(); 
		List<Integer> keys = new ArrayList<>();
		for(int i=0; i< num; i++){
		    String word = br.readLine();
		    if(map.get(word.length()) == null){
		        map.put(word.length(),new ArrayList<>());
		        keys.add(word.length());
		    }
		    if(!map.get(word.length()).contains(word))
		        map.get(word.length()).add(word);
		  //  System.out.println(word);
		}
		
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		for(int key : keys){
		    List<String> words = map.get(key);
		    Collections.sort(words);
		    for(String word : words)
		        sb.append(word).append("\n");
		}
		System.out.println(sb);
	}
}
