class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int maxAlp =0, maxCop=0;
        // 목표
        for (int i = 0; i < problems.length ; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        // dp[알고력][코딩력] => 알고력, 코딩력 가지는데 필요한 최소 시간
        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        // 최소값이 들어가야 하니까 최대값으로 세팅
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0; // 시작점

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);

                for (int[] problem : problems){
                    if (i>= problem[0] && j>=problem[1]){ // 문제 풀 수 있는 조건충족
                        int nextAlp = Math.min(maxAlp, i + problem[2]);
                        int nextCop = Math.min(maxCop, j + problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}