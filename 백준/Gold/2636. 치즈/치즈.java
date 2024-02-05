import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean isValid(int y, int x){
        return (0<=y)&&(y<n)&&(0<=x)&&(x<m);
    }

    static void printArr(int[][] arr){
        for(int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
    static void printArr(boolean[][] arr){
        for(boolean[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
    static class Point{
        int y;
        int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static Stack<Point> solution() {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0,0, 1, -1};
        Stack<Point> stk = new Stack<>();
        Stack<Point> newStk = new Stack<>();
        stk.push(new Point(0,0));
        Point curr; int ny, nx;
        while(!stk.isEmpty()){
            curr = stk.pop();
            arr[curr.y][curr.x] = -1;
            for (int i = 0; i < 4; i++) {
                ny = curr.y+dy[i];
                nx = curr.x+dx[i];
                if (isValid(ny, nx) && arr[ny][nx]!=-1){
                    if(arr[ny][nx]>0){
                        arr[ny][nx]=-1;
                        newStk.push(new Point(ny, nx));
                    }
                    else {
                        stk.push(new Point(ny, nx));
                    }
                }
            }
        }
        return newStk;
    }

    static Stack<Point> solution2(Stack<Point> stk) {
        Stack<Point> newStk = new Stack<>();
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int ny, nx;
        Point curr;
        while (!stk.isEmpty()) {
            curr = stk.pop();
            arr[curr.y][curr.x] = -1;
            for (int i = 0; i < 4; i++) {
                ny = curr.y + dy[i];
                nx = curr.x + dx[i];
                if (isValid(ny, nx) && arr[ny][nx] != - 1) {
                    if (arr[ny][nx] > 0) {
                        arr[ny][nx] = -1;
                        newStk.push(new Point(ny, nx));
                    } else {
                        stk.push(new Point(ny, nx));
                    }
                }
            }
        }
        return newStk;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int prev=1; int answer = 0;
        Stack<Point> stk= solution();
        while(!stk.isEmpty()){
            prev = stk.size();
            stk = solution2(stk);
            answer++;
        }
        sb.append(answer).append("\n").append(prev);
        System.out.println(sb.toString());

    }
}