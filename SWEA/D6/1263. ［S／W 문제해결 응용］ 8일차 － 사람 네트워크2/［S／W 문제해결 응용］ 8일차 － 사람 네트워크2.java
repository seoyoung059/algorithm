import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static final int MAX = 999_999_999;

    static int sol(BufferedReader br) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0 && i!=j) arr[i][j] = MAX;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp+=arr[i][j];
            }
            answer = Integer.min(tmp, answer);
        }
        return answer;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append("#").append(i+1).append(" ").append(sol(br)).append("\n");
        }
        System.out.println(sb);
    }
}