import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n, m, w, s, e, t;
        boolean neg;
//        HashMap<Integer, Integer>[] edges = new HashMap[501];
        ArrayDeque<int[]> eArr = new ArrayDeque<>();
        int[][] edges = new int[501][501];
        for (int i = 1; i < 501; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        }
        int[] distance;
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            distance = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                if (edges[s][e] > t) edges[s][e] = t;
                if (edges[e][s] > t) edges[e][s] = t;
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = -Integer.parseInt(st.nextToken());

                if (edges[s][e] > t) edges[s][e] = t;
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (edges[i][j] != Integer.MAX_VALUE) {
                        eArr.offer(new int[]{i, j, edges[i][j]});
                        edges[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            neg = false;
            int eCnt;

            loop:
            for (int i = 1; i <= n; i++) {
                for (int[] curr : eArr) {
                    s = curr[0];
                    e = curr[1];
                    t = curr[2];
                    if (distance[s] != Integer.MAX_VALUE && distance[s] + t < distance[e]) {
                        distance[e] = distance[s] + t;
                        if (i == n) {
                            neg = true;
                            break loop;
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(distance));
            sb.append(neg ? "YES" : "NO").append("\n");
            eArr.clear();
        }
        System.out.print(sb);
    }
}