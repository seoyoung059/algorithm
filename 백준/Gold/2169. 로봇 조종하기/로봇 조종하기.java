import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][][] dp = new int[n][m][3];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + arr[i - 1][j];
                }

                if (j + 1 < m) {
                    dp[i][j + 1][0] = Math.max(dp[i][j][0], dp[i][j][1]) + arr[i][j];
                }
            }

            if (i == 0 || i == n - 1) continue;
            for (int j = m - 1; j > 0; j--) {
                dp[i][j - 1][2] = Math.max(dp[i][j][1], dp[i][j][2]) + arr[i][j];
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(Arrays.toString(dp[i][j]) + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Math.max(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]) + arr[n - 1][m - 1]);
    }
}