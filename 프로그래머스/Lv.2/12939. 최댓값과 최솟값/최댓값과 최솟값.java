import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arrStr = s.split(" ");
        int max = (int)-Math.pow(10, 9);
        int min = (int)Math.pow(10,9);
        int tmp;
        
        for(String num: arrStr){
            tmp = Integer.parseInt(num);
            max = (tmp > max) ? tmp : max;
            min = (tmp < min) ? tmp : min;
        }
        answer += min + " "+ max;
        return answer;
    }
}