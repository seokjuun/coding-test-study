import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    static int N;
    static int num=666;
    static int count=0;

    public static void main(String[] args) throws Exception{
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (true){
            if (Integer.toString(num).contains("666")) { // 문자열 변환 후 "666" 포함 여부 확인
                count++;
                if(count == N){
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}
