import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        list.sort((a, b) ->
                a.length() != b.length()
                        ? a.length() - b.length()      
                        : a.compareTo(b)              
        );
        
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}