import java.util.*;

class Solution {
    public int solution(String s) {
        int answer=0;
        int idx;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        loop: for(int start = 0; start<s.length(); start++){
            dq = new ArrayDeque<>();
            answer = 0;
            for(int i=0; i<s.length(); i++){
                idx = Math.floorMod(start+i, s.length());
                if("[{(".indexOf(s.charAt(idx))>=0){
                    dq.offer(s.charAt(idx));
                }
                else {
                    if(dq.isEmpty()) continue loop;
                    switch(s.charAt(idx)){
                        case ')':
                            if(dq.peekLast()=='('){
                                dq.pollLast();
                            } else continue loop;
                            break;
                        case '}':
                            if(dq.peekLast()=='{'){
                                dq.pollLast();
                            } else continue loop;
                            break;
                        case ']':
                            if(dq.peekLast()=='['){
                                dq.pollLast();
                            } else continue loop;
                            break;
                    }
                    if(dq.isEmpty()) {
                        answer++;
                        if(i==s.length()-1) break loop;
                    }
                }
            }
        }
        if(dq.size() > 0) answer = 0;
        return answer;
    }
}