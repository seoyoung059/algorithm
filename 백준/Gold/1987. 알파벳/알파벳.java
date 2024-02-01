import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.*;

public class Main {
    static int answer;
    static int r, c;
//    static String[] board;
    static int[][] arr;
    static Queue<Point> q;
//    static PriorityQueue<Point> q;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0,0,1, -1};
    static int char2Int (char c) {
        return 1<<((int)c - (int)'A');
    }
    static class Point {
        int y;
        int x;
        int check;
        public Point(int y, int x, int check) {
            this.y = y;
            this.x = x;
            this.check = check;
        }
    }
    static boolean isValid(int y, int x) {
        return (0<=y)&&(y<r)&&(0<=x)&&(x<c);
    }


    static void solution2(int y, int x, int check) {
        int tmp=0;
        int ny, nx;
        boolean ing = false;
        for (int i = 0; i < 4; i++) {
            ny = y+dy[i];
            nx = x+dx[i];
            if(isValid(ny,nx)) {
                if ((check & arr[ny][nx]) != arr[ny][nx]) {
                    ing = true;
                    solution2(ny, nx, check | arr[ny][nx]);
                }
            }
        }
        if (!ing)
            answer = Math.max(answer, Integer.bitCount(check));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

//        board = new String[r];
        arr = new int[r][c];
        String tmp;
        for (int i = 0; i < r; i++) {
            tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = char2Int(tmp.charAt(j));
            }
        }
        answer = 0;
        solution2(0,0,arr[0][0]);
        System.out.println(answer);
    }
}