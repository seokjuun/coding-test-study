class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int hp = health;

        for (int i = 0; i < attacks.length; i++) {
            int gap = (attacks[i][0]-1) - time; // 공격 간 시간
            time = attacks[i][0];

            int success = gap / bandage[0]; // 추가 회복 받을 수 있는 횟수
            int fail = gap % bandage[0]; // 추가 회복 못받고 남는 시간

            hp = hp + success * ((bandage[0] * bandage[1]) + bandage[2]) + fail * bandage[1];
            if (hp > health) hp = health;

            hp = hp - attacks[i][1];
            if (hp <= 0) return -1;

        }
        return hp;
    }
}