class Solution {
    public int solution(int n) {
        int answer = 0;
        // 홀수일때 (n+1)/2**2
        // 짝수일때 4*(n/2)**2
        if (n%2==0){
            // answer = (int)(4*Math.pow(n/2, 2));
            for(int i=1;i<=n/2;i++){
                answer += i*i;
            }
            answer *= 4;
        }
        else {
            answer = (int)(Math.pow((n+1)/2, 2));
        }
        return answer;
    }
}