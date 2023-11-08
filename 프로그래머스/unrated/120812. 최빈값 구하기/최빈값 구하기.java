class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int maxval = 0;
        int[] cnt = new int[1001];
        for(int i=0;i<1001;i++){
            cnt[i]=0;
        }
        
        for (int i=0;i<array.length;i++){
            cnt[array[i]]+=1;
            if (maxval<cnt[array[i]]){
                answer = array[i];
                maxval = cnt[array[i]];
            }
            else if(maxval==cnt[array[i]]){
                answer = -1;
            }
        }
        return answer;
    }
}