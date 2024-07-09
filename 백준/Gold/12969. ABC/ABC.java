import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[n+1][n+1][k+1];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        int[] curr = null; int b=0, c=0, kk=0, qSize;
        for (int i = 0; i < n; i++)  {
            qSize = q.size();
            while(qSize-- > 0) {
                curr = q.poll();
//                System.out.println(Arrays.toString(curr));
                if (curr[0] + curr[1] + curr[2] <= k && dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] == 0) {
                    dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] = 1;
                    q.offer(new int[]{curr[0], curr[1], curr[0] + curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) {
                        b = q.peekLast()[0];
                        c = q.peekLast()[1];
                        kk = q.peekLast()[2];
//                        System.out.println(dp[b][c][kk]);
                        break;
                    }
                }

                if (curr[0] < n && curr[1] + curr[2] <= k && dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] == 0) {
                    dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] = 2;
                    q.offer(new int[]{curr[0] + 1, curr[1], curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) {
                        b = q.peekLast()[0];
                        c = q.peekLast()[1];
                        kk = q.peekLast()[2];
//                        System.out.println(dp[b][c][kk]);
                        break;
                    }
                }

                if (curr[1] < n && dp[curr[0]][curr[1] + 1][curr[2]] == 0) {
                    dp[curr[0]][curr[1] + 1][curr[2]] = 3;
                    q.offer(new int[]{curr[0], curr[1] + 1, curr[2]});
                    if (q.peekLast()[2] == k) {
                        b = q.peekLast()[0];
                        c = q.peekLast()[1];
                        kk = q.peekLast()[2];
//                        System.out.println(dp[b][c][kk]);
                        break;
                    }
                }
            }
        }

        int tmp;
        if(kk!=k){
            System.out.println(-1);
        } else {
            ArrayDeque<Integer> ans = new ArrayDeque<>();
            tmp = dp[b][c][kk];
            while(b!=0 || c!=0 || kk!=0){
//                System.out.println(b+" "+c+" "+kk+" "+tmp);
                ans.offerLast(tmp);
                switch (tmp){
                    case 1:
                        kk -= b+c;
                        break;
                    case 2:
                        kk -= c;
                        b -= 1;
                        break;
                    case 3:
                        c -= 1;
                        break;
                }
                tmp = dp[b][c][kk];
            }

            StringBuilder sb = new StringBuilder();
//            sb.repeat('C',n-ans.size());
            for (int i = 0; i < n-ans.size(); i++) {
                sb.append('C');
            }
            for(Integer i: ans){
                switch (i){
                    case 1:
                        sb.append('A');
                        break;
                    case 2:
                        sb.append('B');
                        break;
                    case 3:
                        sb.append('C');
                        break;
                }
            }
            System.out.println(sb);
        }

    }
}