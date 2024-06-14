import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int h;
    static int w;
    static boolean isValid(int y, int x) {
        return 0<=y && y<h && 0<=x && x<w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        boolean[][] visited = new boolean[h][w];

        int[] dy = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
        ArrayDeque<int[]> q = new ArrayDeque<>();

        String str;
        int ny, nx;
        for (int i = 0; i < h; i++) {
            str = br.readLine();
            for (int j = 0; j < w; j++) {
                switch(str.charAt(j)) {
                    case '.':
                        arr[i][j] = 0;
                        q.offerLast(new int[] {i, j});
                        break;
                    default:
                        arr[i][j] += str.charAt(j)-'0';
                        visited[i][j] = true;
                        break;
                }
            }
        }

        int qCnt; int[] curr;
        int answer = 0;
        while(!q.isEmpty()) {
            answer++;
            qCnt = q.size();
            while(qCnt-->0) {
                curr = q.pollFirst();
                for (int k = 0; k < 8; k++) {
                    ny = curr[0]+dy[k]; nx = curr[1]+dx[k];
                    if (isValid(ny, nx) && arr[ny][nx] > 0) {
                        arr[ny][nx]--;
                        if(arr[ny][nx] <= 0 && visited[ny][nx]){
                            q.offerLast(new int[] {ny, nx});
                            visited[ny][nx] = false;
                        }
                    }
                }
            }
        }

        System.out.println(answer-1);
    }
}