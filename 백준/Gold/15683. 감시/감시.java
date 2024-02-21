import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cNum, answer;
    static int[][] arr, cctv;


    static boolean isValid(int y, int x) {
        return (0<=y)&&(y<n)&&(0<=x)&&(x<m);
    }
    static int[][] deepcopy(int[][] arr){
        int[][] newArr = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }
    static void sol(int idx, int[][] visited, int cnt) {
//        System.out.println(cnt);
        if(idx == cNum){
            answer = Math.max(answer, cnt);
            return;
        }
        int y = cctv[idx][0];
        int x = cctv[idx][1];
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int[][] newVisited;
        if(visited[y][x]==0) cnt++;
        visited[y][x] = 1;
        int ny, nx, d, tmp;
        switch (arr[y][x]){
            case 1:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir; tmp = 0;
                    newVisited = deepcopy(visited);
                    ny = y + dy[d];
                    nx = x + dx[d];
                    while(isValid(ny, nx) && arr[ny][nx]!=6){
                        if(newVisited[ny][nx]==0) tmp++;
                        newVisited[ny][nx]=1;
                        ny+=dy[d];
                        nx+=dx[d];
                    }
                    sol(idx+1, newVisited, cnt+tmp);
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    d = dir; tmp = 0;
                    newVisited = deepcopy(visited);
                    for (int i = 0; i < 2; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 ){
                            if(newVisited[ny][nx]==0) tmp++;
                            newVisited[ny][nx]=1;
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+2)%4;
                    }
                    sol(idx+1, newVisited, cnt+tmp);
                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir; tmp = 0;
                    newVisited = deepcopy(visited);
                    for (int i = 0; i < 2; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 ){
                            if(newVisited[ny][nx]==0) tmp++;
                            newVisited[ny][nx]=1;
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+1)%4;
                    }
                    sol(idx+1, newVisited, cnt+tmp);
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir; tmp = 0;
                    newVisited = deepcopy(visited);
                    for (int i = 0; i < 3; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 ){
                            if(newVisited[ny][nx]==0) tmp++;
                            newVisited[ny][nx]=1;
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+1)%4;
                    }
                    sol(idx+1, newVisited, cnt+tmp);
                }
                break;
            case 5:
                newVisited = visited; tmp = 0;
                for (int i = 0; i < 4; i++) {
                    ny = y+dy[i];
                    nx = x+dx[i];
                    while(isValid(ny, nx) && arr[ny][nx]!=6 ){
                        if(newVisited[ny][nx]==0) tmp++;
                        newVisited[ny][nx]=1;
                        ny+=dy[i];
                        nx+=dx[i];
                    }
                }
                sol(idx+1, newVisited, cnt+tmp);
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        cctv = new int[8][2];
        int wall = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==6){
                    wall++;
                }
                else if(arr[i][j]>0) {
                    cctv[cNum][0] = i;
                    cctv[cNum++][1] = j;
                }
            }
        }

        int[][] visited = new int[n][m];
        sol(0, visited,0);
        System.out.println(n*m-answer-wall);

    }
}