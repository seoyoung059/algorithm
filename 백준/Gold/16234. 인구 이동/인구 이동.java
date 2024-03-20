import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = -1;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1, -1};
        boolean going = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]> opened = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        int[] curr; int ny, nx, tmp, cnt, sum;
        while (going) {
            going = false;
            cnt = 0; answer++;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i],0);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]==0){
                        q.offerLast(new int[] {i,j});
                        opened.offer(q.peekLast());
                        visited[i][j] = ++cnt;
                        sum=arr[i][j];
                        while(!q.isEmpty()) {
                            curr = q.pollFirst();
                            for (int k = 0; k < 4; k++) {
                                ny = curr[0]+dy[k];
                                nx = curr[1]+dx[k];

                                if(ny<0 || nx<0 || ny>=n||nx>=n) continue;
                                tmp = Math.abs(arr[ny][nx]-arr[curr[0]][curr[1]]);
                                if(visited[ny][nx]==0 && l<=tmp && tmp<=r){
                                    q.offerLast(new int[] {ny, nx});
                                    opened.offer(q.peekLast());
                                    visited[ny][nx] = cnt;
                                    sum+=arr[ny][nx];
                                }
                            }
                        }

                        sum /= opened.size();
                        if(opened.size()>1) {
                            while (!opened.isEmpty()) {
                                going = true;
                                curr = opened.pollFirst();
                                arr[curr[0]][curr[1]] = sum;
                            }
                        }
                        else opened.clear();
                    }
                }
            }
        }
        System.out.println(answer);
    }
}