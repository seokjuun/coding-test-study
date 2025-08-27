
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String str;
    static List<Pair> pairs = new ArrayList<>();
    static boolean[] removed;
    static Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();

        // list 에 괄호 위치 짝지어서 넣어두기
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '('){
                stack.push(i);
            } else if (c == ')'){
                pairs.add(new Pair(stack.pop(), i)); // 0,10  3,7
            }
        }

        removed = new boolean[str.length()];
        dfs(0); // 괄호쌍은 1개 이상, 괄호쌍 맨 앞부터

//        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx){
        // 되돌아가라
        if(idx == pairs.size()){
            // 사전순 정렬 나중에 해야해서 여기선 걍 해시셋에 넣어두기만
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!removed[i]) { // removed 가 트루면 안받는다고 ㅇㅇ
                    sb.append(str.charAt(i));
                }
            }

            if (!sb.toString().equals(str)) { // 원래 수식은 제외
                result.add(sb.toString());
            }
            return;
        }

        Pair p = pairs.get(idx);
        // 현재 괄호 쌍 제거
        removed[p.startIdx] = true;
        removed[p.endIdx] = true;
        dfs(idx+1);
        // 여기서 기저조건 찍고 돌아올거니까 원복
        removed[p.startIdx] = false;
        removed[p.endIdx] = false;
        // 제거 안한 거
        dfs(idx+1);

    }

    static class Pair {
        int startIdx;
        int endIdx;

        public Pair(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }
}
