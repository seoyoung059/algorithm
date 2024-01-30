import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;

    static int[][] belt;
    static int robotOn, robotOff;
    static LinkedList<Robot> robots;
    static int cnt;

    static class Robot {
        int loc;

        public Robot(int loc) {
            this.loc = loc;
        }
    }
    static void beltRotate(){
        robotOn = ((robotOn-1)+(2*n))%(2*n);
        robotOff = (robotOn+n-1+(2*n)) % (2*n);
    }
    static void solution(){
        int answer = 0;

        while (cnt < k) {
            answer++;
            // 한 칸 회전
            beltRotate();
            Robot r;

            if (!robots.isEmpty()) {
                // 로봇
                for (int i=0; i<robots.size();i++) {
                    r = robots.get(i);
//                    System.out.println(r.loc);
                    // 로봇 내려가는 위치 도달 시 내림
                    if(r.loc == robotOff){
                        belt[r.loc][1]=0;
                        robots.remove(r);
                        i--;
                        continue;
                    }

                    // 로봇 이동
                    if (belt[(r.loc + 1)%(2*n)][1] == 0 && belt[(r.loc + 1)%(2*n)][0] >= 1) {
                        belt[r.loc][1] = 0;
                        r.loc++;
                        r.loc%=2*n;
                        belt[r.loc][1] = 1;
                        belt[r.loc][0]--;
                        if (belt[r.loc][0] == 0)
                            cnt++;
                    }
                    if(r.loc == robotOff){
                        belt[r.loc][1]=0;
                        robots.remove(r);
                        i--;
                        continue;
                    }
                }
            }

            if(belt[robotOn][0]!=0){
                belt[robotOn][0]--;
                belt[robotOn][1]=1;
                robots.offer(new Robot(robotOn));
                if(belt[robotOn][0]==0)
                    cnt++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        /*
        컨베이어 칸 -> 2n

        1. 한칸씩 이동
        2. 가장 먼저 올라간 로봇부터
           벨트가 회전하는 방향으로 한칸 이동할 수 있다면 이동
           - 이동하려는 칸에 로봇이 없고 내구도가 1 이상 남아있어야함
        3. 올리는 위치의 칸의 내구도가 0보다 크면 로봇을 올림
        4. 내구도가 0인 칸의 개수가 k개 이상이 되면 과정 종료
         */
        st = new StringTokenizer(br.readLine());
        // 벨트의 길이
        n = Integer.parseInt(st.nextToken());
        // 내구도
        k = Integer.parseInt(st.nextToken());
        belt  = new int[2*n][2];
        robots = new LinkedList<Robot>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            belt[i][0]=(Integer.parseInt(st.nextToken()));
        }
        robotOn = 0;

        solution();

    }
}