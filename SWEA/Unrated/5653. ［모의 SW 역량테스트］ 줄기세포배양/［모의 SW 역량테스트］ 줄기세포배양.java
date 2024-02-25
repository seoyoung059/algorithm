import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br;
    static ArrayDeque<int[]> deactivated;
    static ArrayDeque<int[]> activated;
    static int[][] arr;

    static void activeCell(int size){
        int[] curr;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int ny, nx;
        while(size-->0){
            curr = activated.poll();
            for (int i = 0; i < 4; i++) {
                ny = curr[0]+dy[i];
                nx = curr[1]+dx[i];
                if((arr[ny][nx] == 0)||(arr[ny][nx] < 0 && arr[ny][nx] > (-2)*curr[2])){
                    arr[ny][nx] = -2*curr[2];
                    deactivated.offer(new int[] {ny, nx, curr[2]});
                }
            }
            if(--arr[curr[0]][curr[1]]==0) arr[curr[0]][curr[1]] = 99;
            else activated.offer(curr);
        }
    }

    static void deactiveCell(int size){
        int[] curr; int tmp;
        while(size-->0){
            curr = deactivated.poll();
            tmp = arr[curr[0]][curr[1]];
            if(tmp < 0) arr[curr[0]][curr[1]] *= -1;

            if(--arr[curr[0]][curr[1]]==curr[2]) activated.offer(curr);
            else deactivated.offer(curr);
        }
    }

    static int solution() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        deactivated.clear();
        activated.clear();

        arr = new int[k+n][k+m];
        int tmp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tmp = Integer.parseInt(st.nextToken());
                arr[k/2+i][k/2+j] = tmp*2;
                if(arr[k/2+i][k/2+j] > 0) deactivated.offer(new int[] {k/2+i,k/2+j, tmp});
            }
        }

        int activeSize, deactiveSize;
        for (int i = 0; i < k; i++) {
            activeSize = activated.size();
            deactiveSize = deactivated.size();

            deactiveCell(deactiveSize);
            activeCell(activeSize);
        }
        return (deactivated.size()+activated.size());
    }


    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        deactivated = new ArrayDeque<>();
        activated = new ArrayDeque<>();
        for (int tc = 0; tc < T; tc++) {
            sb.append("#").append(tc+1).append(" ").append(solution()).append("\n");
        }
        System.out.print(sb);
    }
}