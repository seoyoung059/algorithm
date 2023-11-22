class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int q=0;q<queries.length;q++){
            int s = queries[q][0];
            int e = queries[q][1];
            int k = queries[q][2];
            int ans = 1000001;
            for (int idx = s;idx<e+1;idx++){
                if (k<arr[idx] && arr[idx]<ans){
                    ans = arr[idx];
                }
            }
            answer[q] = (ans>1000000)?-1:ans;
        }
        
        return answer;
    }
}