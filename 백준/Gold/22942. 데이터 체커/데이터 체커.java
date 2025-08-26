
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Event[] events = new Event[2*N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            events[2*i]   = new Event(x - r, i, 0); // 시작
            events[2*i+1] = new Event(x + r, i, 1); // 끝
        }
        // 좌표 별 정렬
        Arrays.sort(events, (a, b) -> {
            int c = Integer.compare(a.x, b.x);
            if (c != 0) return c;
            return Integer.compare(a.type, b.type);
        });

        for (int i = 1; i < events.length; i++) {
            if (events[i].x == events[i-1].x) {
                System.out.println("NO");
                return;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (Event e : events) {
            if (e.type == 0) stack.push(e.id);
            else {
                if (stack.isEmpty() || stack.peek() != e.id) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println("YES");
    }

    static class Event {
        int x, id, type;
        Event(int x, int id, int type) {
            this.x = x;
            this.id = id;
            this.type = type;
        }
    }
}

