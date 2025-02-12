import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        while(true){
            if(N<0){
                System.out.println(-1);
                break;
            }
            if(N%5 ==0){
                System.out.println(N/5 + count);
                break;
            }
            N -=3;
            count++;
        }
    }
}