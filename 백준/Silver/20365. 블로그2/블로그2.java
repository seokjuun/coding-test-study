
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int blue = 0;
        int red = 0;
        if (str.charAt(0) == 'B') blue++;
        else red++;


        for (int i = 1; i < N; i++) {
            if (str.charAt(i) != str.charAt(i-1)){
                if (str.charAt(i) == 'B') blue++;
                else red++;
            }
        }

        System.out.println(Math.min(blue,red) +1);
    }
}
