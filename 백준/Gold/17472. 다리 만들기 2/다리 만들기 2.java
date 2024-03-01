import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][][] arr;

    static boolean isValid(int y, int x) {
        return (0 <= y) && (y < n) && (0 <= x) && (x < m);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[3][n][m];

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println("입력");
//        for (int[][] a : arr)
//            System.out.println(Arrays.toString(a[0]));

        // 섬 구분하기
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]>[] coast = new ArrayDeque[7];
        int[][] b = new int[7][7];

        int[] curr;
        int islandCnt = 1;
        int ny, nx, d, cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[0][i][j] == 0) {
                    arr[0][i][j] = -1;
                } else if (arr[0][i][j] == 1) {
                    coast[islandCnt] = new ArrayDeque<>();
                    islandCnt++;
                    q.offer(new int[]{i, j});
                    arr[0][i][j] = islandCnt;
                    arr[1][i][j] = islandCnt;
                    while (!q.isEmpty()) {
                        curr = q.poll();
                        arr[0][curr[0]][curr[1]] = islandCnt;
                        arr[1][curr[0]][curr[1]] = islandCnt;
                        for (int k = 0; k < 4; k++) {
                            ny = curr[0] + dy[k];
                            nx = curr[1] + dx[k];
                            if (isValid(ny, nx)) {
                                if(arr[0][ny][nx] == 1) {
                                    q.offer(new int[]{ny, nx});
//                                    System.out.println(ny + " " + nx);
                                }
                                else if (arr[0][ny][nx]<=0) {
                                    coast[islandCnt-1].offer(new int[]{ny, nx, k});
                                }
                            }
                        }
                    }

                }
            }
        }

//        System.out.println("\n섬 구분");
//        for (int i=0; i<n; i++)
//            System.out.println(Arrays.toString(arr[0][i])+"\t"+Arrays.toString(arr[1][i]));

        islandCnt--;


        for (int i = 1; i < islandCnt+1; i++) {
            while (!coast[i].isEmpty()) {
                curr = coast[i].poll();
                ny = curr[0];
                nx = curr[1];
                d = curr[2];
                cnt = 0;
//                arr[d / 2][ny][nx] = i+1;
                while (true) {
                    if (!isValid(ny, nx)) {
                        for (int k = 0; k < cnt; k++) {
                            ny -= dy[d];
                            nx -= dx[d];
                            arr[d / 2][ny][nx] = -1;
                        }
                        break;
                    } else if (arr[d / 2][ny][nx] > 0) {
                        if (cnt < 2) {
                            for (int k = 0; k < cnt; k++) {
                                ny -= dy[d];
                                nx -= dx[d];
                                arr[d / 2][ny][nx] = -1;
                            }
                            break;
                        } else {
                            int s = arr[d/2][ny][nx]-1;
                            int e = arr[d/2][curr[0]][curr[1]]-1;
                            if(b[s][e]==0||b[s][e] > cnt) {
                                b[s][e] = cnt;
                                b[e][s]= cnt;
                            }
                            break;
                        }
                    } else {
                        arr[d / 2][ny][nx] = i+1;
                        cnt++;
                    }
                    ny += dy[d];
                    nx += dx[d];
                }
            }
        }


//        System.out.println("\n다리 건설");
//        for(int k=0; k<2; k++){
//            for (int i=0; i<n; i++){
//                for (int j = 0; j < m; j++) {
//                    System.out.print(arr[k][i][j]+"\t");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < islandCnt; i++) {
//            System.out.println(Arrays.toString(b[i+1]));
//        }

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        int answer = 0; cnt = 1; int cv;
        boolean[] isVisited = new boolean[islandCnt+1];
        isVisited[1] = true;
        for(int i=1; i<islandCnt+1; i++) {
            if(b[1][i]>0) pQueue.offer(new int[] {i, b[1][i]});
        }

        while(!pQueue.isEmpty()&&cnt<islandCnt) {
            curr = pQueue.poll();
            if(isVisited[curr[0]]) continue;
            isVisited[curr[0]] = true;
            answer+= curr[1];
            cv = curr[0];
            cnt++;
            for(int i=1; i<islandCnt+1; i++) {
                if(b[cv][i]>0) pQueue.offer(new int[] {i, b[cv][i]});
//                System.out.println(cv+" "+i);
            }
        }
//        System.out.println( (answer==0)?-1:answer);
        if(cnt<islandCnt) System.out.println(-1);
        else System.out.println(answer);
    }
}