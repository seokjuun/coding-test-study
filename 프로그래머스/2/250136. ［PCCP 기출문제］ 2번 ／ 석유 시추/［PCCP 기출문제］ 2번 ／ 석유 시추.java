
import java.util.*;

class Solution {
    static int n,m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] oilId; // 덩어리 아이디
    static List<Integer> oilSize; // 아이디 별 사이즈

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oilId = new int[n][m];
        oilSize = new ArrayList<>();
        oilSize.add(0);
        int id = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && oilId[i][j] == 0) {
                    int size = dfs(i, j, land, id);
                    oilSize.add(size);
                    id++;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            int sum =0;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int groupId = oilId[j][i];
                if (groupId > 0 && !set.contains(groupId)){
                    set.add(groupId);
                    sum += oilSize.get(groupId);
                }
            }
            max = Math.max(max,sum);
        }

        return max;
    }

    static int dfs(int y, int x, int[][] land,int id){
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(new int[]{y,x});
        oilId[y][x] = id;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny>=0 && nx>=0 && ny<n && nx<m && land[ny][nx]==1 && oilId[ny][nx] ==0){
                    oilId[ny][nx] = id;
                    queue.offer(new int[]{ny,nx});
                    count += 1;
                }
            }

        }

        return count;
    }
}