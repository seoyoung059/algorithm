import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2]; int answer = 0;
        arr[0] = 1001;
        arr[n+1] = 1001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+2][2];
        int prev; int val;
        for (int i = 1; i < n+1; i++) {
            val = -1; prev = 0;
            for (int j = i; j >= 0 ; j--) {
                if(dp[j][0] > dp[prev][0] && arr[j] < arr[i]){
                    prev = j;
                }
            }
            dp[i][0] = dp[prev][0]+1;
        }

        for(int i=n; i>=1; i--){
            prev = i; val = -1;
            for (int j = i; j < n+2; j++) {
                if(dp[j][1] > dp[prev][1] && arr[j] < arr[i]){
                    prev=j;
                }
            }
//            System.out.println(arr[i]+" "+arr[prev]);
            dp[i][1] = dp[prev][1]+1;
        }

        for (int i = 1; i < n+1; i++) {
            answer = Math.max(answer, dp[i][0]+dp[i][1]);
        }
        System.out.print(answer-1);
    }
}