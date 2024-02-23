import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, fuel, ty, tx, currP;
    static int[][] map, destination;

    static boolean isValid(int y, int x){
        return (0<=y)&&(y<n)&&(0<=x)&&(x<n);
    }
    static boolean findP() {
        if(map[ty][tx]<0) {
            currP = -map[ty][tx];
            map[ty][tx] = 0;
            return true;
        }
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        q.offer(new int[] {ty, tx});
        visited[ty][tx] = true;
//        System.out.println("current: "+ty+" "+tx);

        int[] curr;
        int ny, nx, qsize; int cnt=0; boolean found = false;
        int tmpy = n, tmpx = n;
        while(!q.isEmpty()&&!found){
            qsize = q.size();
            if(fuel<=0) {
                return false;
            }
            while(qsize-->0) {
                curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    ny = curr[0] + dy[i];
                    nx = curr[1] + dx[i];
                    if (isValid(ny, nx) && !visited[ny][nx]) {
                        if (map[ny][nx] < 0) {
                            found = true;
                            if((ny<tmpy)||((ny==tmpy)&&(nx<tmpx))){
                                currP = -map[ny][nx];
                                map[ty][tx] = 0;
//                                System.out.println("손님: "+currP);
                                tmpy = ny; tmpx = nx;
                            }
                        } else if (map[ny][nx] == 0) {
                            visited[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
            cnt++;
            fuel--;
        }
        if(found) {
            map[tmpy][tmpx] = 0;
            ty = tmpy; tx = tmpx;
        }
        return found;
    }

    static boolean toDst(){
        if(destination[currP][0]==ty && destination[currP][1] == tx){
            return true;
        }
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        q.offer(new int[] {ty, tx});
        visited[ty][tx] = true;

        int[] curr;
        int ny, nx, qsize; int cnt=0; boolean arrived = false;
        while(!q.isEmpty()){
            qsize = q.size();
            if(fuel<=0) {
//                fuel = -1;
                return false;
            }
            while(qsize-->0) {
                curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    ny = curr[0] + dy[i];
                    nx = curr[1] + dx[i];
                    if(destination[currP][0]==ny && destination[currP][1] == nx){
                        fuel+=(1+cnt)*2-1;
                        ty = ny; tx = nx;
                        return true;
                    }
                    if (isValid(ny, nx) && !visited[ny][nx]) {
                        if (map[ny][nx] != 1) {
                            visited[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
            cnt++;
            fuel--;
        }

        return false;
    }
    static boolean sol(){
        for (int i = 0; i < m; i++) {
//            System.out.println("====P"+(i+1)+"=====");
//            System.out.println("taxi: "+ty+" "+tx);
            if(!findP()) {return false;}
//            System.out.println("p: "+currP+" fuel: "+fuel);
            if(!toDst()) {return false;}
//            System.out.println("taxi: "+ty+" "+tx);
//            System.out.println("fuel: "+fuel);

        }

        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        /*
         * 전체 N*N 영역, M명의 승객
         * 승객 고를때
         *  - 현재 위치에서 최단경로가 가장 짧은 승객
         *  - 그런 승객이 여러명이면 그중 행 번호가 가장 작은 승객
         *  - 그런 승객이 여러명이면 그중 열 번호가 가장 작은 승객
         *  - 택시와 승객이 같은 위치이면 승객까지의 최단거리는 0
         * 연료
         *  - 한 칸 이동시 1 소모
         *  - 승객 도착 시 승객을 태워 이동하면서 소모한 연료 양의 2배 충전
         *  - 연료 모두 소모 시 이동 실패
         * 구하는것
         *  - 모든 승객을 성공적으로 데려다줄 수 있는지
         *  - 데려다 줄 수 있는 경우 최종적으로 남는 연료의 양 출력
         */


        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        ty = Integer.parseInt(st.nextToken())-1;
        tx = Integer.parseInt(st.nextToken())-1;


        destination = new int[m+1][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -(i+1);
            destination[i+1][0] = Integer.parseInt(st.nextToken())-1;
            destination[i+1][1] = Integer.parseInt(st.nextToken())-1;
        }

        System.out.println(sol()?fuel:-1);
    }
}