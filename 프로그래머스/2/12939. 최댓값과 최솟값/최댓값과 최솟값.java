import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE, tmp;
        while(st.countTokens() > 0){
            tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}