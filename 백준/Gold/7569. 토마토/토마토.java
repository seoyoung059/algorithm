import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m, n, h;

    static int[][][] box;
    static Queue<GoodTomato> q = new LinkedList<GoodTomato>();
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int max = 0;

    public static class GoodTomato {
        int z;
        int y;
        int x;

        public GoodTomato(int z,int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
    static boolean isValid(int z, int y, int x) {
        return ((0<=z)&&(z<h)&&(0<=y)&&(y<n)&&(0<=x)&&(x<m));
    }
    static void solution(){
        GoodTomato curr;
        int nz, ny, nx;
        while(!q.isEmpty()) {
            curr = q.poll();
//            System.out.println(curr.y+" "+curr.x);
            for (int i = 0; i < 6; i++) {
                nz = curr.z+dz[i];
                ny = curr.y+dy[i];
                nx = curr.x+dx[i];
                if(isValid(nz, ny, nx)&&box[nz][ny][nx]==0){
                    box[nz][ny][nx]=box[curr.z][curr.y][curr.x]+1;
                    max = Math.max(max, box[nz][ny][nx]-1);
                    q.offer(new GoodTomato(nz, ny,nx));
                }
            }
        }
    }

    static boolean isGoodBox(){
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(box[k][i][j]==0)
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if (box[k][i][j]==1) q.offer(new GoodTomato(k, i,j));
                }
            }
        }

        solution();
        if(isGoodBox())
            System.out.println(max);
        else
            System.out.println(-1);

    }
}
