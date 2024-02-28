import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;


    static int solution() throws Exception {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int[][] people = new int[10][2]; // 사람 시작 위치
        int[][] stairs = new int[2][3]; // 계단 위치 및 높이
        PriorityQueue<Integer> stair0wait = new PriorityQueue<>();
        PriorityQueue<Integer> stair1wait = new PriorityQueue<>();

        int cntP = 0;
        int cntS = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) continue;
                else if (arr[i][j] == 1) {
                    people[cntP][0] = i;
                    people[cntP++][1] = j;
                } else {
                    stairs[cntS][0] = i;
                    stairs[cntS][1] = j;
                    stairs[cntS++][2] = arr[i][j];
                }
            }
        }
        int d;
        int answer = Integer.MAX_VALUE;
        ArrayDeque<Integer> s0 = new ArrayDeque<>();
        ArrayDeque<Integer> s1 = new ArrayDeque<>();
        for (int i = 0; i < (1 << cntP); i++) {
            s0.clear(); s1.clear(); stair0wait.clear();stair1wait.clear();
            for (int j = 0; j < cntP; j++) {
                //i번째 사람이 0번 계단으로 갈 때
                if ((i & (1 << j)) == 0) {
                    d = Math.abs(people[j][0] - stairs[0][0]) + Math.abs(people[j][1] - stairs[0][1]);
                    stair0wait.offer(d);
                }
                //i번째 사람이 1번 계단으로 갈 때
                else {
                    d = Math.abs(people[j][0] - stairs[1][0]) + Math.abs(people[j][1] - stairs[1][1]);
                    stair1wait.offer(d);
                }
            }

            int cnt = 1;
            int ans = 0;
            while (!stair0wait.isEmpty() || !stair1wait.isEmpty() || !s0.isEmpty() || !s1.isEmpty()) {

                while (!s0.isEmpty() && s0.peekFirst() <= cnt) s0.poll();
                while (!s1.isEmpty() && s1.peekFirst() <= cnt) s1.poll();
                while (!stair0wait.isEmpty() && stair0wait.peek() <= cnt && s0.size() < 3) {
                    stair0wait.poll();
                    ans = Math.max(ans, cnt + stairs[0][2] + 1);
                    s0.offerLast(cnt + stairs[0][2]);
                }
                while (!stair1wait.isEmpty() && stair1wait.peek() <= cnt && s1.size() < 3) {
                    stair1wait.poll();
                    ans = Math.max(ans, cnt + stairs[1][2] + 1);
                    s1.offerLast(cnt + stairs[1][2]);
                }
                cnt++;
                if(ans>answer) break;
            }
            answer = Math.min(ans, answer);
        }

        /*
            계단 입구까지 이동시간은 행차이+열차이
            계단을 내려가는 시간은 계단 입구부터 계단을 완전히 내려갈 때까지의 시간
                - 계단 입구 도착 시 1분 후 아래칸
                - 계단 위에는 동시에 최대 3명까지만
                - 이미 3명이 내려가고 있다면 그중 한명이 계단을 완전히 내려갈 때까지 입구에서 대기
                - 계단 길이 K -> 계단에 올라간 후 완전히 내려가는 데 K분
            모든 사람들이 계단을 내려가 이동이 완료되는 시간이 최소가 되는 경우
            그때의 소요시간을 출력

            사람마다 어느 계단으로 갈지 결정 후
            해당 경우에 대해 방법 진행 (완탐)
            몇초에 계단에 도착하는지 확인해서 PQ 생성 후,
            계단에 들어가면 계단 q에다가 계단에서 나오는 시간과 함께 넣음
            계단에 못들어가면 poll하지 않고 다음 턴까지 대기
         */
        return answer;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append("#").append(i).append(" ").append(solution()).append("\n");
        }
        System.out.print(sb);
    }
}