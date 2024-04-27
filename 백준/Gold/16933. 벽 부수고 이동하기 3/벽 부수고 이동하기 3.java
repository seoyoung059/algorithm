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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] curr;
        int ny, nx, qSize;
        q.offer(new int[]{0, 0, k});
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][][] visited = new boolean[n][m][k + 1][2];
        visited[0][0][k][0] = true;
        boolean tmp, answer = false;
        int cnt = 1;
        if (n == 1 && m == 1) answer = true;
        loop:
        while (!q.isEmpty() && answer == false) {
//            System.out.print(cnt+" "+((cnt%2==0)?"밤":"낮")+": ");
            qSize = q.size();
            while (qSize-- > 0) {
                curr = q.pollFirst();
                for (int i = 0; i < 4; i++) {
                    ny = curr[0] + dir[i][0];
                    nx = curr[1] + dir[i][1];

                    if (ny < 0 || n <= ny || nx < 0 || m <= nx) continue;
                    if ((tmp = arr[ny].charAt(nx) == '1') && cnt % 2 == 0) continue;
                    if (tmp && curr[2] == 0) continue;
                    if (ny == n - 1 && nx == m - 1) {
                        cnt++;
                        answer = true;
                        break loop;
                    }
                    if (visited[ny][nx][curr[2] - (tmp ? 1 : 0)][(cnt + 1) % 2]) continue;
                    q.offerLast(new int[]{ny, nx, curr[2] - (tmp ? 1 : 0)});
                    visited[ny][nx][curr[2] - (tmp ? 1 : 0)][(cnt + 1) % 2] = true;
                }

                if (!visited[curr[0]][curr[1]][curr[2]][(cnt + 1) % 2]) {
                    q.offerLast(new int[]{curr[0], curr[1], curr[2]});
                    visited[curr[0]][curr[1]][curr[2]][(cnt + 1) % 2] = true;
                }
            }
            cnt++;
//            for(int[] a: q){
//                System.out.print(Arrays.toString(a)+" ");
//            }
//            System.out.println();
        }
        System.out.println(answer ? cnt : -1);
    }
}