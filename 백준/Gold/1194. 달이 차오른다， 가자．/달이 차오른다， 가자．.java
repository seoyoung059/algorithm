import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int n, m, sy, sx;
    static char[][] arr;

    static boolean isValid(int y, int x) {
        return (0<=y) && (y<n)&&(0<=x)&&(x<m);
    }
    static int solution(){
//        boolean[][][] visited = new boolean[n][m][(1<<6)];
        long[][] visited = new long[n][m];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sy, sx, 0});
//        visited[sy][sx][0] = true;
        visited[sy][sx] = 1;
        int cnt = 0;

        int qSize, ny, nx, tmp;
        int[] curr;
        while(!q.isEmpty()){
            qSize = q.size();
            cnt++;
            while(qSize-->0){
                curr = q.poll();
//                System.out.println(Arrays.toString(curr));
                for (int i = 0; i < 4; i++) {
                    ny = curr[0]+dy[i];
                    nx = curr[1]+dx[i];
                    if(isValid(ny, nx)){
                        if((arr[ny][nx]== '.') && ((visited[ny][nx]&(1L<<curr[2]))==0)) {
                            visited[ny][nx] |= (1L<<curr[2]);
                            q.offer(new int[] {ny, nx, curr[2]});
                        }
                        else if(((tmp = "abcdef".indexOf(arr[ny][nx]))>=0) && ((visited[ny][nx]&(1L<<(curr[2]|(1<<tmp))))==0)){
//                            System.out.println("getKey "+ny+" "+nx+" "+ tmp);
                            visited[ny][nx]|=(1L<<(curr[2]|(1<<tmp)));
                            q.offer(new int[] {ny, nx, (curr[2]|(1<<tmp))});
                        }
                        else if(((tmp = "ABCDEF".indexOf(arr[ny][nx]))>=0) && (curr[2]&(1<<tmp))>0 && (visited[ny][nx]&(1L<<curr[2]))==0){
//                            System.out.println("openDoor");
                            visited[ny][nx]|=(1L<<curr[2]);
                            q.offer(new int[] {ny, nx, curr[2]});
                        }
                        else if(arr[ny][nx]=='1'){
                            return cnt;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        String tmp;
        for (int i = 0; i < n; i++) {
            tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j);
                if(arr[i][j]=='0') {
                    sy = i;
                    sx = j;
                    arr[i][j]='.';
                }
            }
//            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(solution());
    }
}