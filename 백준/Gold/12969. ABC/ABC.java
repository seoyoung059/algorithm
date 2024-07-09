import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static void makeString(){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[n+1][n+1][k+1];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        int[] curr; int b, c, kk = 0, qSize;
        loop: for (int i = 0; i < n; i++)  {
            qSize = q.size();
            while(qSize-- > 0) {
                curr = q.poll();
                if (curr[0] + curr[1] + curr[2] <= k && dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] == 0) {
                    dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] = 1;
                    q.offer(new int[]{curr[0], curr[1], curr[0] + curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }

                if (curr[0] < n && curr[1] + curr[2] <= k && dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] == 0) {
                    dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] = 2;
                    q.offer(new int[]{curr[0] + 1, curr[1], curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }

                if (curr[1] < n && dp[curr[0]][curr[1] + 1][curr[2]] == 0) {
                    dp[curr[0]][curr[1] + 1][curr[2]] = 3;
                    q.offer(new int[]{curr[0], curr[1] + 1, curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }
            }
        }

        int tmp;
        if(q.peekLast()[2]!=k){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            b = q.peekLast()[0];
            c = q.peekLast()[1];
            kk = q.peekLast()[2];
            tmp = dp[b][c][kk];
            while(b!=0 || c!=0 || kk!=0){
                switch (tmp){
                    case 1:
                        sb.append('A');
                        kk -= b+c;
                        break;
                    case 2:
                        sb.append('B');
                        kk -= c;
                        b -= 1;
                        break;
                    case 3:
                        sb.append('C');
                        c -= 1;
                        break;
                }
                tmp = dp[b][c][kk];
            }
            
            tmp = n-sb.length();
            for (int i = 0; i < tmp; i++) {
                sb.append('A');
            }
            System.out.println(sb);
        }

    }
}