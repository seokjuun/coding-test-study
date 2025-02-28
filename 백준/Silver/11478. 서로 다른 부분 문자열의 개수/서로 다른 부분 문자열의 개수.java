
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    static String S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        // 시작 점 과 크기
        for (int i = 1; i <= S.length(); i++) { // 크기
            for (int j = 0; j < S.length()-i+1; j++) { //시작점
                if(i+j > S.length()) continue;
                set.add(S.substring(j,j+i));
            }
        }

        System.out.println(set.size());
    }
}
