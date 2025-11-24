import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        // 이전 이후 배열 선언, 삭제여부 배열, 삭제 스택, 선택 위치
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n-1] = -1;
        
        boolean[] removed = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        int curr = k;
        
        // 입력
        for (String s : cmd) {
            StringTokenizer st = new StringTokenizer(s);
            String str = st.nextToken();

            switch(str) {
                case "U": { // 업
                    int x = Integer.parseInt(st.nextToken());
                    while (x-- > 0) {
                        curr = prev[curr];
                    }
                    break;
                }
                case "D": { // 다운
                    int x = Integer.parseInt(st.nextToken());
                    while (x-- > 0) {
                        curr = next[curr];
                    }
                    break;
                }
                case "C": {  // 삭제
                    stack.push(curr);
                    removed[curr] = true;

                    int p = prev[curr];
                    int nxt = next[curr];

                    if (p != -1) next[p] = nxt;
                    if (nxt != -1) prev[nxt] = p;

                    curr = (nxt != -1) ? nxt : p;
                    break;
                }
                case "Z": {  // 복구
                    int r = stack.pop();
                    removed[r] = false;

                    int p = prev[r];
                    int nxt = next[r];

                    if (p != -1) next[p] = r;
                    if (nxt != -1) prev[nxt] = r;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(removed[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}