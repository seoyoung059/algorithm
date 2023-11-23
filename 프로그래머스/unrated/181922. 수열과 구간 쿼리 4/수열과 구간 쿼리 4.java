// import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int q = 0; q < queries.length; q++) {
            int[] answer = new int[queries.length];
            int s = queries[q][0];
            int e = queries[q][1];
            int k = queries[q][2];
            for (int i = s; i < e+1; i++){
                if (i % k == 0) {
                    arr[i]++;
                }
            }
            // System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}