
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st,st2;
        N = Integer.parseInt(br.readLine()); // 자료구조 수
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            if(Integer.parseInt(st.nextToken()) == 0){
                list.add(Integer.parseInt(st2.nextToken()));
            } else {
                st2.nextToken();
            }
        }


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = list.size()-1; i >=0; i--) {
            sb.append(list.get(i)).append(" ");
            count ++;
            if(count == M) break;
        }

        while (count < M){
            sb.append(Integer.parseInt(st.nextToken())).append(" ");
            count++;
        }

        System.out.println(sb);
    }
}
