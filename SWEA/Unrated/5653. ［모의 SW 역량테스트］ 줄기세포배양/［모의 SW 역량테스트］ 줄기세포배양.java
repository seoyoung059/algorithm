import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 문풀시간 14:07*/
public class Solution {

    /*  - 일정시간 배양 후 줄기 세포의 개수가 몇개가 되는지 계산
     *  - 생명력 수치가 x인 줄기세포
     *      - 초기 상태: x시간동안 비활성 상태 (x시간 후 활성화)
     *      - 활성 상태: x시간동안 살아 있을 수 있으며 x시간 지나면 죽음
     *          - 첫 1시간동안 상하좌우로 동시에 번식
     *          - 번식된 줄기 세포는 비활성 상태
     *          - 번식 방향에 줄기세포가 존재하면 추가 번식 x
     *          - 두 개 이상의 줄기 세포가 하나의 그리드 셀에 동시 번식하려고 하면
     *            생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 차지
     *      - 죽은 상태: 소멸이 아닌 죽은 상태로 해당 칸 차지
     *  - 1<= N, M <= 50
     *  - 배양 시간 1<=K<=300
     *  - 배양 용기의 크기는 무한 -> 가장자리가 없으므로 번식할 수 없는 경우는 없음
     *  - 생명력 1<=x<=10
     *
     * 생명력 수치 따로 저장, 처음에 (생명력*2)로 가서 0이면 비활성
     *  - x=3이면 6으로 시작, 3이하면 활성, 0이면 비활성 -> -1로 변경
     *  - 다 bfs하는것보다 활성, 비활성 나눠서 queue로 관리
     */
    static BufferedReader br;
    static ArrayDeque<int[]> deactivated;
    static ArrayDeque<int[]> activated;
    static int[][] arr;

    static void activeCell(int size){
//        int size = activated.size();
        int[] curr;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int ny, nx;
        while(size-->0){
            curr = activated.poll();
            for (int i = 0; i < 4; i++) {
                ny = curr[0]+dy[i];
                nx = curr[1]+dx[i];
                if(arr[ny][nx] == 0){
//                    arr[ny][nx] = curr[2]*2;
                    arr[ny][nx] = -2*curr[2];
                    deactivated.offer(new int[] {ny, nx, curr[2]});
                }
                else if(arr[ny][nx] < 0 && arr[ny][nx] > (-2)*curr[2]){
                    arr[ny][nx] = -2*curr[2];
                    deactivated.offer(new int[] {ny, nx, curr[2]});
                }
            }
            if(--arr[curr[0]][curr[1]]==0){
                arr[curr[0]][curr[1]] = 99;
            } else {
                activated.offer(curr);
            }
        }
    }

    static void deactiveCell(int size){
        int[] curr; int tmp;
        while(size-->0){
            curr = deactivated.poll();
            tmp = arr[curr[0]][curr[1]];
            if(tmp < 0){
                if(tmp == -2*curr[2]){
                    arr[curr[0]][curr[1]] *= -1;
                }
                else {
                    continue;
                }
            }
            if(--arr[curr[0]][curr[1]]==curr[2]){
                activated.offer(curr);
            } else {
                deactivated.offer(curr);
            }
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
                arr[k/2+i][k/2+j] =tmp*2;
                if(arr[k/2+i][k/2+j] > 0) deactivated.offer(new int[] {k/2+i,k/2+j, tmp});
            }
        }

        int activeSize, deactiveSize;
        for (int i = 0; i < k; i++) {
            activeSize = activated.size();
            deactiveSize = deactivated.size();

            deactiveCell(deactiveSize);
            activeCell(activeSize);
//            System.out.println(deactivated.size()+" "+activated.size());
//            for(int[] a: arr){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println();
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