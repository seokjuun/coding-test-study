import java.util.*;

class Solution {
        public int solution(String s) {
            int answer = 0;
            Deque<Character> deque = new ArrayDeque<>();
            // ArrayDeque 에 문자열 저장
            for (char c : s.toCharArray()){
                deque.offerLast(c);
            }

            // 문자열 만큼 회전
            for (int i = 0; i < s.length(); i++) {
                // 올바른 괄호 검증
                if(isRight(deque)) answer++;
                deque.offerLast(deque.pollFirst());
            }

            return answer;
        }

        static boolean isRight(Deque<Character> deque){  // {}()[]
            Deque<Character> stack = new ArrayDeque<>();

            for(char c : deque){
                if( c == '(' || c == '{' || c == '['){
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }