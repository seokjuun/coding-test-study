

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static boolean is = true;
    static int total =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        int stCount = st.countTokens();

        for (int i = 0; i < stCount; i++){
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
            int num=0;

            int st2Count = st2.countTokens();
            for (int j = 0; j < st2Count; j++) {
                num+= Integer.parseInt(st2.nextToken());
            }


            if (is){
                total += num;
                is = false;
            } else {
                total -= num;
            }
        }

        System.out.println(total);

    }
}
