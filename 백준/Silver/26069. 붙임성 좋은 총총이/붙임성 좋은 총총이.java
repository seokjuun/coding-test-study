import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean chong;
    static String cc = "ChongChong";
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set.add(cc);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(str1.equals(cc) || str2.equals(cc)) chong = true;

            if(chong && (set.contains(str1) || set.contains(str2))){
                set.add(str1);
                set.add(str2);
            }
        }
        System.out.println(set.size());
    }
}