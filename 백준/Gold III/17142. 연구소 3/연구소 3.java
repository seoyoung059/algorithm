import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작시간 08:48

 */
public class Main {
    static int n, m;
    static int[][] lab;

    static boolean isValid(int y, int x){
        return (0<=y)&&(y<n)&&(0<=x)&&(x<n);
    }

    static void swap(int[] p, int i, int j){
        p[i] ^= p[j];
        p[j]^= p[i];
        p[i] ^= p[j];
    }

    static boolean perm(int[] p){
        int length = p.length;
        int i = length-1;
        while(i>0 && p[i-1]>=p[i]) i--;
        if(i==0) return false;

        int j = length-1;
        while(j>i && p[i-1] >= p[j]) j--;

        swap(p, i-1, j);

        int k = length - 1;
        while(i<k) swap(p, i++, k--);
        return true;
    }
    static void solution(ArrayDeque<int[]> virus) {
        int vNum = virus.size();
        int[][][] arr = new int[n][n][vNum];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[] curr; int ny, nx;
        for (int i = 0; i < vNum; i++) {
            q.clear();
            if(!virus.isEmpty()){
            q.offer(new int[] {virus.peek()[0], virus.peek()[1], 1});
            arr[q.peek()[0]][q.peek()[1]][i] = 1;}
            while(!q.isEmpty()){
                curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    ny = curr[0]+dy[j];
                    nx = curr[1]+dx[j];
                    if(isValid(ny, nx)){
                        if(arr[ny][nx][i]==0){
                            if(lab[ny][nx]==0){
                                arr[ny][nx][i] = arr[curr[0]][curr[1]][i]+1;
                                q.offer(new int[] {ny, nx, curr[2]+1});
                            }
                            else if (lab[ny][nx]==2){
                                arr[ny][nx][i] = arr[curr[0]][curr[1]][i]+1;
                                q.offer(new int[] {ny, nx, curr[2]+1});
                            }
                        }
                    }

                }
            }
            virus.poll();
        }

        int[] p = new int[vNum];
        for (int i = 0; i < vNum; i++) {
            if(i<vNum-m) p[i] = 0;
            else p[i]=1;
        }

        int tmp; boolean isVirus = false;
        int answer = Integer.MAX_VALUE;
        int caseMax = Integer.MIN_VALUE;

        do{
            caseMax = Integer.MIN_VALUE;
            caseTest: for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(lab[i][j]==0){
                        tmp = Integer.MAX_VALUE;
                        isVirus = false;
                        for (int k = 0; k < vNum; k++) { // 바이러스 확인
                            if(p[k]==1 && arr[i][j][k]>0){ // 활성 바이러스일 때
                                tmp = Math.min(tmp, arr[i][j][k]);
                                isVirus = true;
                            }
                        }
                        // 해당 칸에 바이러스가 도달할 수 없는 경우
                        if(!isVirus) break caseTest;
                        else {
                            caseMax = Math.max(tmp, caseMax);
                        }
                    }
                }
            }
            if(isVirus) {
                answer = Math.min(answer, caseMax);
            }
        } while(perm(p));
        if(answer<Integer.MAX_VALUE) System.out.println(answer-1);
        else System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 배열 크기 m: 놓을 수 있는 바이러스의 개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 0은 빈칸, 1은 벽, 2는 비활성 바이러스 (m <= (2의 개수) <= 10)
        lab = new int[n][n]; boolean noEmpty = true;
        ArrayDeque<int[]> virus = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virus.offer(new int[]{i, j});
                if (lab[i][j] == 0) noEmpty = false;
            }
        }
        /* 연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간 출력
           어떻게 놓아도 모든 빈칸에 퍼뜨릴 수 없는 경우는 -1
                - 바이러스 선택 경우 다 해보는것보다 각각의 바이러스에 대해 구하고
                  조합별로 가능한지 확인하기?
         */
        if(noEmpty) System.out.println(0);
        else solution(virus);

    }
}