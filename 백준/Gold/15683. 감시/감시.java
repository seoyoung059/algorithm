import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cNum;
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
    static int sol(int idx, int[][] visited) {
        if(idx == cNum){
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans+=(visited[i][j]==0)?1:0;
                }
            }
            return ans;
        }
        int answer = Integer.MAX_VALUE;
        int y = cctv[idx][0];
        int x = cctv[idx][1];
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int[][] newVisited;
        int ny, nx, d;
        switch (arr[y][x]){
            case 1:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir;
                    newVisited = deepcopy(visited);
                    newVisited[y][x] |= (1<<d);
                    ny = y + dy[d];
                    nx = x + dx[d];
                    while(isValid(ny, nx) && arr[ny][nx]!=6 && ((newVisited[ny][nx]&(1<<d))!=(1<<d))){
                        newVisited[ny][nx]|=(1<<d);
                        ny+=dy[d];
                        nx+=dx[d];
                    }
                    answer = Math.min(answer,sol(idx+1, newVisited));
                }
                break;
            case 2:
                for (int dir = 0; dir < 2; dir++) {
                    d = dir;
                    newVisited = deepcopy(visited);
                    newVisited[y][x] |= ((1<<d)|(1<<((d+2)%4)));
                    for (int i = 0; i < 2; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 && ((newVisited[ny][nx]&(1<<d))!=(1<<d))){
                            newVisited[ny][nx]|=(1<<d);
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+2)%4;
                    }
                    answer = Math.min(answer,sol(idx+1, newVisited));
                }
                break;
            case 3:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir;
                    newVisited = deepcopy(visited);
                    newVisited[y][x] |= ((1<<d)|(1<<((d+1)%4)));
                    for (int i = 0; i < 2; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 && ((newVisited[ny][nx]&(1<<d))!=(1<<d))){
                            newVisited[ny][nx]|=(1<<d);
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+1)%4;
                    }
                    answer = Math.min(answer,sol(idx+1, newVisited));
                }
                break;
            case 4:
                for (int dir = 0; dir < 4; dir++) {
                    d = dir;
                    newVisited = deepcopy(visited);
                    newVisited[y][x] |= ((1<<d)|(1<<((d+1)%4))|(1<<((d+2)%4)));
                    for (int i = 0; i < 3; i++) {
                        ny = y+dy[d];
                        nx = x+dx[d];
                        while(isValid(ny, nx) && arr[ny][nx]!=6 && ((newVisited[ny][nx]&(1<<d))!=(1<<d))){
                            newVisited[ny][nx]|=(1<<d);
                            ny+=dy[d];
                            nx+=dx[d];
                        }
                        d = (d+1)%4;
                    }
                    answer = Math.min(answer,sol(idx+1, newVisited));
                }
                break;
            case 5:
                newVisited = visited;
                newVisited[y][x] = (1<<4)-1;
                for (int i = 0; i < 4; i++) {
                    ny = y+dy[i];
                    nx = x+dx[i];
                    while(isValid(ny, nx) && arr[ny][nx]!=6 && ((newVisited[ny][nx]&(1<<i))!=(1<<i))){
                        newVisited[ny][nx]|=(1<<i);
                        ny+=dy[i];
                        nx+=dx[i];
                    }
                }
                answer = Math.min(answer,sol(idx+1, newVisited));
                break;
        }
        return answer;
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
        System.out.println(sol(0, visited)-wall);

    }
}