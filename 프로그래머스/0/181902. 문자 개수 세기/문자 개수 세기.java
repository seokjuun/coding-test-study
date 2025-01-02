class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            if(Character.isUpperCase(ch)){
                answer[my_string.charAt(i) - 'A']++;
            } else {
                answer[26+my_string.charAt(i) - 'a']++;
            }
        }

        return answer;
    }
}