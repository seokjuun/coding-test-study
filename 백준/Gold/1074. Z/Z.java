import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,r,c,ans;

    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //
        N = 1<<N; 

        z(0,0);
        System.out.println(ans);
    }

    static void z(int y, int x){ // 원점
        if(N ==1){
            return;
        }
        N/=2;

        // r,c 가 4개의 영역 중 어디에 있는 지 판단
        if( r < y+N && c < x+N){ //좌 상
            z(y,x);
        } else if( r < y+N && c>= x+N){ // 우 상
            ans += N * N * 1;
            x += N; // 원점 이동 (우)
            z(y,x);
        } else if(r >= y+N && c < x+N){ // 좌 하
            ans += N*N*2;
            y += N; // 원점 이동 (하)
            z(y,x);
        } else{
            ans += N*N*3;
            y+=N;
            x+=N;
            z(y,x);
        };
    }
}
