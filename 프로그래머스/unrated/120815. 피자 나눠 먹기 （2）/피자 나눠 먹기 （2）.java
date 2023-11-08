class Solution {
    public int solution(int n) {
        int answer = 0;
        int tmp;
        if (n>6) tmp = getGCD(n,6);
        else tmp = getGCD(6,n);
        
        answer = n/tmp;
        return answer;
    }
    
    public int getGCD(int a, int b){
        if (a%b==0){
            return b;
        }
        return getGCD(b, a%b);
    }
}