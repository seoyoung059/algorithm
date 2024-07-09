import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        int[] curr; int b, c, kk, qSize;
        
        loop: for (int i = 0; i < n; i++)  {
            qSize = q.size();
            while(qSize-- > 0) {
                curr = q.poll();                
                // 맨 앞에 'A'를 추가하는 경우, B의 개수 + C의 개수만큼 쌍의 개수가 더해진다.
                if (curr[0] + curr[1] + curr[2] <= k && dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] == 0) {
                    dp[curr[0]][curr[1]][curr[0] + curr[1] + curr[2]] = 1;    // A를 추가함을 표시
                    q.offer(new int[]{curr[0], curr[1], curr[0] + curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }

                // 맨 앞에 'B'를 추가하는 경우, B의 개수는 1개 늘고, C의 개수만큼 쌍의 개수가 더해진다.
                if (curr[0] < n && curr[1] + curr[2] <= k && dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] == 0) {
                    dp[curr[0] + 1][curr[1]][curr[1] + curr[2]] = 2; // B를 추가함을 표시
                    q.offer(new int[]{curr[0] + 1, curr[1], curr[1] + curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }

                // 맨 앞에 'C'를 추가하는 경우, C의 개수는 1개 늘고, 쌍의 개수는 그대로이다.
                if (curr[1] < n && dp[curr[0]][curr[1] + 1][curr[2]] == 0) {
                    dp[curr[0]][curr[1] + 1][curr[2]] = 3;    // C를 추가함을 표시
                    q.offer(new int[]{curr[0], curr[1] + 1, curr[2]});
                    if (q.peekLast()[2] == k) break loop;
                }
            }
        }

        int tmp;
        // k개를 맞추지 못한 경우, 만들 수 없다.
        if(q.peekLast()[2]!=k){
            System.out.println(-1);
        } else {
            // 문자열 복원
            StringBuilder sb = new StringBuilder();
            b = q.peekLast()[0];
            c = q.peekLast()[1];
            kk = q.peekLast()[2];
            tmp = dp[b][c][kk];
            while(b!=0 || c!=0 || kk!=0){
                // 맨 앞부터 문자열 복원
                switch (tmp){
                    case 1:
                        sb.append('A');
                        kk -= b+c;    // A는 (B의 개수+C의 개수)만큼 쌍의 개수를 증가시킴
                        break;
                    case 2:
                        sb.append('B');
                        kk -= c;    // B는 C의 개수만큼 쌍의 개수를 증가시킴
                        b -= 1;    // B의 개수 1개 증가한 것 복원
                        break;
                    case 3:
                        sb.append('C');
                        c -= 1;    // C의 개수 1개 증가한 것 복원
                        break;
                }
                tmp = dp[b][c][kk];
            }
            
            // 문자열의 길이가 짧다면 짧은 만큼 맨 앞에 C를 붙이거나, 맨 뒤에 A를 붙이는 방식으로 보완
            tmp = n-sb.length();
            for (int i = 0; i < tmp; i++) sb.append('A');
            System.out.println(sb);
        }

    }
}