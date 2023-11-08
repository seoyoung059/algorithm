class Solution {
    public int[] solution(int n) {
        int cnt = (n%2==0)?n/2:n/2+1;
        int[] answer = new int[cnt];
        
        for (int i=0;i<cnt;i++){
            answer[i] = i*2+1;
        }
        return answer;
    }
}