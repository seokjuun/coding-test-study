
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min=101; //짝수
    static int[][] board;
    static boolean[] selected;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i <N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dst(0,0);
        System.out.println(min);
    }

    static void dst(int index, int count){
        if(count == N/2){
            statD();
            return;
        }

        for (int i = index; i < N; i++) {
            if(!selected[i]){
                selected[i] = true;
                dst(i+1, count+1);
                selected[i] = false;
            }
        }
    }

    static void statD(){
        int t1Sum=0, t2Sum=0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    t1Sum = t1Sum + board[i][j] + board[j][i];
                } else if (!selected[i] && !selected[j]) {
                    t2Sum = t2Sum + board[i][j] + board[j][i];
                }
            }
        }

        if(min>Math.abs(t1Sum-t2Sum)){
            min = Math.abs(t1Sum-t2Sum);
        }
    }
}
