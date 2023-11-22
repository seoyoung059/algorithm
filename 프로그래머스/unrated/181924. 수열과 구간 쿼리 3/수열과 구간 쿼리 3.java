class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for (int q=0; q<queries.length;q++){
            int i = queries[q][0];
            int j = queries[q][1];
            
            int tmp = arr[j];
            
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        answer = arr;
        return answer;
    }
}