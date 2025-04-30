
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void countPaper(int y, int x, int size) {
        if (isSameNumber(y, x, size)) {
            int num = paper[y][x];
            if (num == -1) minusOne++;
            else if (num == 0) zero++;
            else one++;
            return;
        }

        int newSize = size / 3;
        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                countPaper(y + dy * newSize, x + dx * newSize, newSize);
            }
        }
    }

    static boolean isSameNumber(int y, int x, int size) {
        int num = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != num) return false;
            }
        }
        return true;
    }
}