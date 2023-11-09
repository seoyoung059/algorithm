class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] answer = new int[n+1];
        System.arraycopy(num_list, 0, answer, 0, n);
        if(num_list[n-1]>num_list[n-2]){
            answer[n] = num_list[n-1]-num_list[n-2];
        }
        else{
            answer[n] = num_list[n-1]*2;
        }
        return answer;
    }
}