
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, deleteNode, rootNode = -1;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1) {
                rootNode = i;
            } else {
                list[parentNode].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == rootNode) {
            System.out.println(0);
            return;
        }

        System.out.println(dfs(rootNode));
    }

    static int dfs(int node){
        if (node == deleteNode) return 0;

        int save = 0;
        int leaf = 0;

        for (int n : list[node]){
            if (n == deleteNode) continue;
            leaf += dfs(n);
            save++;
        }
        
        if (save == 0) return 1;
        return leaf;
    }
}

