class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int tmp1 = Integer.parseInt(""+a+b);
        int tmp2 = Integer.parseInt(""+b+a);
        if (tmp1>tmp2){
            answer = tmp1;
        }
        else {
            answer = tmp2;
        }
        return answer;
    }
}