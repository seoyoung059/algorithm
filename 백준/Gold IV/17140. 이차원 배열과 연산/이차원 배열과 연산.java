import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k;
    static int[][] arr;


    static void solve(int rNum, int cNum){
        int nextR = 0; int nextC = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
        }));
        int[][] cntArr = new int[101][2];
        for (int i = 0; i < 101; i++) {
            cntArr[i][0] = i;
        }
        int[] curr; int cnt=0;
        while(cnt<=100) {
//            System.out.println(rNum+" "+cNum+" "+arr[r-1][c-1]);
            if(arr[r-1][c-1]==k) break;
            if (rNum <= cNum) { //R연산 (가로줄 확인하며 연산)
                nextC = cNum;
                nextR = Integer.MIN_VALUE;
                for (int i = 0; i < cNum; i++) {
//                int i = 0;
                    pq.clear();
                    for (int j = 0; j <101; j++) {
                        cntArr[j][1]=0;
                    }
                    for (int j = 0; j < rNum; j++) {
                        cntArr[arr[i][j]][1]++;
                    }
                    for (int j = 1; j < 101; j++) {
                        if(cntArr[j][1]!=0) pq.offer(cntArr[j]);
                    }
                    nextR = Math.max(nextR, Math.min(100,pq.size() * 2));
                    for (int j = 0; j < 99; j += 2) {
                        if (!pq.isEmpty()) {
                            curr = pq.poll();
                            arr[i][j] = curr[0];
                            arr[i][j + 1] = curr[1];
                            curr[1]=0;
                        } else {
//                            if (arr[i][j] == 0) break;
                            arr[i][j] = 0;
                            arr[i][j + 1] = 0;
                        }
                    }
//                    System.out.println(Arrays.toString(arr[i]));
                }
            } else { // C연산 (세로줄 확인하며 연산)
                nextR = rNum;
                nextC = Integer.MIN_VALUE;
                for (int i = 0; i < rNum; i++) {
                    pq.clear();
                    for (int j = 0; j <101; j++) {
                        cntArr[j][1]=0;
                    }
                    for (int j = 0; j < cNum; j++) {
                        cntArr[arr[j][i]][1]++;
                    }
                    for (int j = 1; j < 101; j++) {
                        if(cntArr[j][1]!=0) pq.offer(cntArr[j]);
                    }
                    nextC = Math.max(nextC, Math.min(100,pq.size() * 2));
                    for (int j = 0; j < 99; j += 2) {
                        if (!pq.isEmpty()) {
                            curr = pq.poll();
                            arr[j][i] = curr[0];
                            arr[j+1][i] = curr[1];
                            curr[1]=0;
                        } else {
//                            if (arr[j][i] == 0) break;
//                            if (arr[j][i] == 0) break;
                            arr[j][i] = 0;
                            arr[j+1][i] = 0;
                        }
                    }
                }
            }
            cnt++;
            cNum = nextC; rNum = nextR;
        }

//        for (int i = 0; i < cNum; i++) {
//            for (int j = 0; j < rNum; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        if(cnt<=100) System.out.println(cnt);
        else System.out.println(-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(3,3);

    }
}