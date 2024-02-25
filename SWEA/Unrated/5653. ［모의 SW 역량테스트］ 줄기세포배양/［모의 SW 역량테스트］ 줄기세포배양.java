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
     * 생명력 수치 덱 사용 시 같이 저장, 처음에 -(생명력*2)로 가서 0이면 비활성숫자로 변경
     *  - 지금 턴에 증식한것은 음수로 표시해서 이웃한 자리에서 증식할 때 구분
     *  - x=3이면 6으로 시작, 3이하면 활성, 0이면 비활성 -> -1로 변경
     *  - 다 bfs하는것보다 활성, 비활성 나눠서 queue로 관리
     */
    static BufferedReader br;
    static ArrayDeque<int[]> deactivated;
    static ArrayDeque<int[]> activated;
    static int[][] arr;

    //활성 세포가 증식하는 함수
    static void activeCell(int size){
        int[] curr;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int ny, nx;
        // 활성 세포 수만큼만 동작
        while(size-->0){
            curr = activated.poll();
            // 상하좌우 네 방향에 대해 동작
            for (int i = 0; i < 4; i++) {
                ny = curr[0]+dy[i];
                nx = curr[1]+dx[i];
                // 빈칸이면 증식, 증식할 때 이번에 새로 증식한 것을 확인하기 위해 음수로 변환, 비활성 세포 큐에 추가
                // 음수이면 중복으로 증식하는 칸. 현재 세포 curr의 생명력이 더 크다면 칸을 차지
                if((arr[ny][nx] == 0)||(arr[ny][nx] < 0 && arr[ny][nx] > (-2)*curr[2])){
                    arr[ny][nx] = -2*curr[2];
                    deactivated.offer(new int[] {ny, nx, curr[2]});
                }
            }
            // 활성시간 감소해서 0 되면 세포가 죽음, 따로 99로 표시 (음수이면 새로 증식한 세포와 구분이 어렵고, 0이면 빈칸이 안됨)
            // 0이 아직 안되었으면 여전히 활성세포이므로 활성세포 큐에 추가
            if(--arr[curr[0]][curr[1]]==0) arr[curr[0]][curr[1]] = 99;
            else activated.offer(curr);
        }
    }

    // 비활성 세포 동작
    static void deactiveCell(int size){
        int[] curr; int tmp;
        // 주어진 사이즈만큼만 확인
        while(size-->0){
            curr = deactivated.poll();
            tmp = arr[curr[0]][curr[1]];
            // 음수이면 이번 바로 지난번 반복에서 번식한 세포이므로 이번 시행부터 동작, 구분용으로 부호 바꾼거 되돌림
            if(tmp < 0) arr[curr[0]][curr[1]] *= -1;

            // 생명력 시간 -1 했을 시 생명력과 동일하면 활성 세포로 전환, 활성 세포 큐에 삽입
            if(--arr[curr[0]][curr[1]]==curr[2]) activated.offer(curr);
            // 생명력보다 크면 여전히 비활성 세포이므로 비활성세포 큐에 삽입
            else deactivated.offer(curr);
        }
    }

    static int solution() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 활성 세포, 비활성 세포 arraydeque 초기화
        deactivated.clear();
        activated.clear();

        // 매 초 증식이 아닌, 비활성 k초 이후부터 k초동안 증식하므로 최대 한쪽 방향으로 k/2씩 증가 가능
        // 따라서 전체 배양접시는 n+k, m+k로 설정할 수 있다.
        arr = new int[k+n][k+m];
        int tmp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tmp = Integer.parseInt(st.nextToken());
                arr[k/2+i][k/2+j] = tmp*2;
                // 세포일 시 비활성 세포 queue에 삽입
                if(arr[k/2+i][k/2+j] > 0) deactivated.offer(new int[] {k/2+i,k/2+j, tmp});
            }
        }

        int activeSize, deactiveSize;
        for (int i = 0; i < k; i++) {
            // 미리 비활성 세포와 세포 수를 확인해서 이를 인수로 주고 그 크기만큼 동작
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