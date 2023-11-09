class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int tmp = (a==b?1:0)+(b==c?1:0)+(c==a?1:0);
        if (tmp>=0) answer *= a+b+c;
        if (tmp>=1) answer *= Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2);
        if (tmp>=2) answer *= Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3);
        
        return answer;
    }
}