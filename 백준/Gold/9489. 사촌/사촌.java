
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int n,k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        while (inputCheck()){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[] parent = new int[n];

            int parentIdx = -1;
            int kIdx = -1;
            parent[0] = parentIdx;
            arr[0] = Integer.parseInt(st.nextToken());
            if (arr[0] == k) {
                kIdx = 0;
            }

            for (int i = 1; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) kIdx = i;

                if (arr[i]-arr[i-1] == 1){
                    parent[i] = parentIdx;
                } else {
                    parent[i] = ++parentIdx;
                }
            }

            int cnt = 0;
            if (parent[kIdx] != -1 && parent[parent[kIdx]] != -1){
                for (int i = 1; i < n; i++) {
                    if (parent[i] != parent[kIdx] && parent[parent[i]] == parent[parent[kIdx]]) cnt++;
                }

            }
            sb.append(cnt).append("\n");


        }
        System.out.println(sb);
    }

    static boolean inputCheck() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n==0 && k==0) return false;
        return true;
    }
}
