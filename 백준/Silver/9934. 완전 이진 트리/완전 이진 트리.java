

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        //중위순회
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = (int) Math.pow(2, K) - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[K];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        method(0,N-1,0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                sb.append(list[i].get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void method(int left, int right, int depth) {
        if (left > right) return;
        int mid = (left + right) /2;
        list[depth].add(arr[mid]);
        method(left,mid-1, depth+1);
        method(mid+1,right, depth+1);


    }
}
