import java.util.*;
class Solution {
    
    boolean solve(String num, int start, int end){
        if(num.charAt((end+start)/2)=='1') {
            if(end==start) return true;
            else return (solve(num, start, (start+end)/2-1) && solve(num, (start+end)/2+1, end));
        } else {
            for(int i=start; i<=end; i++){
                if(num.charAt(i)=='1') return false;
            }
            return true;
        }
    }
    
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        String tmp;
        StringBuilder sb;
        int tmpLength, cnt;
        for(int i=0; i < n; i++){
            tmp = Long.toBinaryString(numbers[i]);
            tmpLength = tmp.length();
            // cnt=0;
            // while((1<<cnt) <= tmpLength){
            //     cnt++;
            // }
            // System.out.println(cnt+" "+Math.ceil(Math.log(tmpLength)/Math.log(2)));
            cnt = (int) Math.ceil(Math.log(tmpLength+1)/Math.log(2));
            sb= new StringBuilder();
            sb.append("0".repeat(Math.max(0, (1<<cnt)-1 - tmpLength))); 
            sb.append(tmp);
            tmp = sb.toString();
            answer[i] = solve(tmp, 0,tmp.length()-1)?1:0;
        }
        return answer;
    }
}