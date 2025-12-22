import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        // S 지점찾기
        int sy = -1, sx = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    sy = i;
                    sx = j;
                }
            }
        }

        for (String route : routes) {
            StringTokenizer st = new StringTokenizer(route);
            char dir = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());

            int d = -1;
            switch (dir) {
                case 'N': d = 0; break;
                case 'S': d = 1; break;
                case 'W': d = 2; break;
                case 'E': d = 3; break;
            }
            
            // 체크
            int ny = sy + dy[d]*dist;
            int nx = sx + dx[d]*dist;
            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

            boolean blocked = false;
            int cy = sy;
            int cx = sx;
            for (int i = 1; i <= dist; i++) {
                cy = sy + dy[d] * i;
                cx = sx + dx[d] * i;

                if (park[cy].charAt(cx) == 'X') {
                    blocked = true;
                    break;
                }
            }

            if (!blocked) {
                sy = ny;
                sx = nx;
            }
        }

        return new int[]{sy, sx};
    }
}