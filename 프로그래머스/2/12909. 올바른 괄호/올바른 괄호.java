class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt= 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                cnt++;
            }
            else {
                if (cnt > 0){
                    cnt--;
                }
                else {
                    answer = false;
                    break;
                }
            }
        }
        if(cnt!=0) answer = false;
        return answer;
    }
}