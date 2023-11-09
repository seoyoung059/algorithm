class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int tmp1 = 1;
        int tmp2 = 0;
        
        for(int i=0;i<num_list.length;i++){
            tmp1*=num_list[i];
            tmp2+=num_list[i];
        }
        
        if (tmp1 < Math.pow(tmp2,2)){
            answer = 1;
        }
        return answer;
    }
}