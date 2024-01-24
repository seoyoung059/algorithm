import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean isValid(int y, int x, int n) {
        return (0<=y&&y<n&&0<=x&&x<n);
    }
    static int solution(int[][] arr, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[0]-o2[0]);
        boolean[][] visited = new boolean[n][n];
        for(boolean[] d: visited) Arrays.fill(d,false);
        int[] start = {arr[0][0], 0, 0};
        int[] current; int ny; int nx;
        pq.offer(start);
        while(!pq.isEmpty()){
            current = pq.poll();
            for (int i = 0; i < 4; i++) {
                ny = current[1]+dy[i];
                nx = current[2]+dx[i];
                if (ny==n-1 && nx==n-1) {
                    return (current[0] + arr[n - 1][n - 1]);
                }
                if (isValid(ny, nx, n) && !visited[ny][nx]){
                    visited[ny][nx]=true;
                    int[] newOffer = {current[0]+arr[ny][nx], ny, nx};
                    pq.offer(newOffer);
                }
            }
//            System.out.println(pq);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int caseNum = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if (n==0) break;
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ");
            sb.append(caseNum++);
            sb.append(": ");
            sb.append(solution(arr,n));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}