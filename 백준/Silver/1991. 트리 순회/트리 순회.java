 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] arr = new Node[26];
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();

    static class Node{
        char left, right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            arr[node-'A'] = new Node(left, right);
        }

        first('A');
        middle('A');
        last('A');

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
    }

    static void first(char c){
        if (c == '.') return;

        sb1.append(c);
        first(arr[c-'A'].left);
        first(arr[c-'A'].right);
    }

    static void middle(char c){
        if (c == '.') return;

        middle(arr[c-'A'].left);
        sb2.append(c);
        middle(arr[c-'A'].right);
    }

    static void last(char c){
        if (c == '.') return;

        last(arr[c-'A'].left);
        last(arr[c-'A'].right);
        sb3.append(c);
    }

}
