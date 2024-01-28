import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] gears = new String[4];
    static int[] gear12 = new int[4];
    static int k;

    static int getLeftTooth(int gear) {
        return gears[gear].charAt((gear12[gear]+6)%8)-'0';
    }

    static int getRightTooth(int gear) {
        return gears[gear].charAt((gear12[gear]+2)%8)-'0';
    }
    static void turnLeftGear(int gear, int direction) {
        int myTooth; int nextTooth;
        // left 확인
        if (gear > 0) {
            myTooth = getLeftTooth(gear);
            nextTooth = getRightTooth(gear-1);
            if(myTooth!=nextTooth) {
                turnLeftGear(gear - 1, -direction);
                gear12[gear - 1] = (gear12[gear - 1] + direction+8) % 8;
            }
        }
    }

    static void turnRightGear(int gear, int direction) {
        int myTooth; int nextTooth;
        if (gear < 3) {
            myTooth = getRightTooth(gear);
            nextTooth = getLeftTooth(gear+1);
            if(myTooth!=nextTooth) {
                turnRightGear(gear + 1, -direction);
                gear12[gear+1] = (gear12[gear+1]+direction+8)%8;
            }
        }
    }
    static void solution() throws IOException {
        int turnGear, turnDirection;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            turnGear = Integer.parseInt(st.nextToken())-1;
            turnDirection = Integer.parseInt(st.nextToken());

            turnLeftGear(turnGear, turnDirection);
            turnRightGear(turnGear, turnDirection);
            gear12[turnGear] = (gear12[turnGear]-turnDirection+8)%8;
        }
    }
    public static void main(String[] args) throws IOException {
        /* 12시 방향 ->  점수 체크
        * (12시 방향 + 2)번 인덱스가 오른쪽 방향, (12시 방향+6)번 인덱스가 왼쪽 방향
        * 시계 방향(+1)로 돌리면 12시 방향이 --, 반시계 방향(-1)으로 돌리면 12시 방향이 ++ 된다.
        * */
        // 4개의 톱니바퀴의 상태 받기
        for (int i = 0; i < 4; i++) {
            gears[i] = br.readLine();
        }

        // 회전 횟수 및 회전 방법 상태 입력
        k = Integer.parseInt(br.readLine());

        solution();
        int answer=0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].charAt(((int)gear12[i]+8)%8)=='1')
                answer += Math.pow(2,i);
        }
        System.out.println(answer);
    }
}
