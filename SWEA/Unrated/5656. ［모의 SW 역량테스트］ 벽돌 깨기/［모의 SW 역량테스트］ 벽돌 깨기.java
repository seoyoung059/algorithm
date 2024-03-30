import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {


    static int n, w, h, answer;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};


    static void shoot(int depth, int s, int[][] arr) {
        if(depth==n) {
            int cnt = 0;
            for (int i = 0; i < w; i++) {
                for (int j = h-1; j >= 0 ; j--) {
                    if(arr[j][i]==0) break;
                    cnt++;
                }
            }
            answer = Math.min(answer, cnt);
            return;
        }

        int y = 0;
        while(y<h && arr[y][s]==0){
            y++;
        }
        if(y==h) return;
        boolean[][] visited = new boolean[h][w];
        int[][] newArr = new int[h][];
        for (int i = 0; i < h; i++) {
            newArr[i] = arr[i].clone();
        }
        arr = newArr;
        explode(y, s, arr, visited);

        for (int i = 0; i < w; i++) {
            for (int j = h-1; j >= 0 ; j--) {
                if(arr[j][i]==0){
                    int k = j-1;
                    for (; k >=0 ; k--) {
                        if(arr[k][i] > 0) {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < w; i++) {
            shoot(depth+1, i, arr);
        }
    }
    static void explode(int y, int x, int[][] arr, boolean[][] visited) {
        int ny, nx;
        for (int i = 0; i < arr[y][x]; i++) {
            for (int j = 0; j < 4; j++) {
                ny = y+dy[j]*i;
                nx = x+dx[j]*i;
                if(ny<0||nx<0||h<=ny||w<=nx) continue;
                if(!visited[ny][nx]&& arr[ny][nx]>0) {
                    visited[ny][nx] = true;
                    explode(ny, nx, arr, visited);
                    arr[ny][nx] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;


            int[][] arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < w; i++) {
                shoot(0,i, arr);
            }
            answer = (answer==Integer.MAX_VALUE)? 0: answer;
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}