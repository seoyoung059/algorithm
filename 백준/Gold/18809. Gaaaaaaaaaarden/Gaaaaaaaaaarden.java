import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean perm(int[] p) {
        int n = p.length;
        int i = n-1;
        while(i>0 && p[i-1]>=p[i]) i--;
        if(i==0) return false;

        int j = n-1;
        while(j>i && p[i-1]>=p[j])j--;
        swap(p, i-1, j);

        int k = n-1;
        while (k > i) swap(p, k--, i++);
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        int[][] arr = new int[n][m];
        int[][] available = new int[10][2];
        int aCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) {
                    available[aCnt][0] = i;
                    available[aCnt++][1] = j;
                }
            }
        }

        int[] p = new int[aCnt];
        int idx = aCnt-1;
        for (int i = 0; i < g; i++) {
            p[idx] = 2;
            idx--;
        }
        for (int i = 0; i < r; i++) {
            p[idx] = 1;
            idx--;
        }


        int answer = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int cnt, ny, nx, qSize; int[] curr;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int[][][] newArr = new int[2][n][];
        int time;
        do {
//            System.out.println(Arrays.toString(p));
            for (int i = 0; i < n; i++) {
                newArr[0][i] = arr[i].clone();
                newArr[1][i] = new int[m];
            }

            for (int i = 0; i < aCnt; i++) {
                if(p[i]!=0) {
                    q.offer(new int[] {available[i][0], available[i][1], -p[i]});
                    newArr[0][available[i][0]][available[i][1]] = -p[i];
                }
            }
            cnt = 0;
            time = 0;
            while(!q.isEmpty()){
                qSize = q.size();
                time++;
                while(qSize-->0){
                    curr = q.poll();
                    if(newArr[0][curr[0]][curr[1]] == 0||newArr[0][curr[0]][curr[1]]==3) continue;
                    for (int i = 0; i < 4; i++) {
                        ny = curr[0]+dy[i];
                        nx = curr[1]+dx[i];
                        if(ny<0||nx<0||n<=ny||m<=nx) continue;
                        if(newArr[0][ny][nx]==0 || newArr[0][ny][nx]==3||newArr[0][ny][nx]==curr[2]) continue;
                        if(newArr[0][ny][nx]<0){
                            if(newArr[1][ny][nx]==time) {
//                                System.out.println(ny + " " + nx);
                                newArr[0][ny][nx] = 3;
                                cnt++;
                            }
                        }
                        else {
                            newArr[0][ny][nx] = curr[2];
                            newArr[1][ny][nx] = time;
                            q.offer(new int[]{ny, nx, curr[2]});
                        }
                    }
                }
            }
//            System.out.println("cnt: "+cnt);
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(newArr[0][i]));
//            }
            answer = Math.max(answer,cnt);
        } while(perm(p));
        System.out.println(answer);
    }
}