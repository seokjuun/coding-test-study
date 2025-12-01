import java.util.*;

class Solution {
    static public Map<String, String> referrals = new HashMap<>(); // <판매원,추천인>
    static public Map<String, Integer> totalProfits = new HashMap<>(); // <판매원,이익금>
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // enroll : 이름배열 | referral : 추천인 | seller : 판매자 | amount : 판매수량
        
        for(int i=0; i<enroll.length; i++){
            referrals.put(enroll[i], referral[i]);
            totalProfits.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++){
            int money = amount[i] * 100;
            String name = seller[i];
            
            addProfit(name, money);
        }

        for(int i=0; i<answer.length; i++){
            answer[i] = totalProfits.get(enroll[i]);
        }
        
        return answer;
    }
    
    static public void addProfit(String name, int money){
        totalProfits.put(name, totalProfits.get(name) + (money - money/10));

        if(referrals.get(name).equals("-")){ // 센터가 추천인이라면
            return;
        } 
        
        if(money/10 >= 1){
            addProfit(referrals.get(name), money/10);
        }
    }

}