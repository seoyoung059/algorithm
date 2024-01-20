class Solution {
    public int solution(int n, int k) {
        int drinks = Math.max(0, k-(n/10));
        int answer = 12000*n + 2000*drinks;
        return answer;
    }
}