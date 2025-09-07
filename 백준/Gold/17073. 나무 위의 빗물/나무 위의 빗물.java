
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, W;
    static ArrayList<Integer>[] list;
    static int[] waterArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken()); // water
        waterArr = new int[N+1];

        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 정보
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

        int cnt = 0;
        for (int i = 2; i < N+1; i++) {
            if (list[i].size() ==1) cnt++;
        }


        System.out.println((double)W/cnt);
    }
}
