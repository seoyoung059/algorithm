import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        StringTokenizer st;
        int[] dp = new int[n + 2];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int tmp;
        int answer = 0;
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            tmp = i + arr[i][0];
            if (tmp > n+1) continue;
            dp[i] = Math.max(dp[i-1], dp[i]);
            dp[tmp] = Math.max(dp[i]+arr[i][1], dp[tmp]);
            answer = Math.max(answer, dp[tmp]);
//            max = Math.max(dp[i], max);
        }

//        for(int a: dp)
//            System.out.print(a+" ");
//        System.out.println();
        System.out.println(answer);
//        System.out.println(dp[n]);
    }
}