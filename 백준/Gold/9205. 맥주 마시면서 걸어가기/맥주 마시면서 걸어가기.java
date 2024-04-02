import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 999_999_999;

    static boolean canGo(int[][] points, int a, int b) {
        return (Math.abs(points[a][0]-points[b][0])+Math.abs(points[a][1]-points[b][1]) <= 50*20);
    }
    static boolean sol(BufferedReader br) throws Exception{
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[n+2][n+2];
        int[][] points = new int[n+2][2];
        StringTokenizer st;

        for (int i = 0; i < n+2; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                arr[i][j] = canGo(points, i,j);
            }
        }



        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                for (int k = 0; k < n+2; k++) {
                    arr[j][k] = arr[j][k]||(arr[j][i]&&arr[i][k]);
                }
            }
        }
        return (arr[0][n+1]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append(sol(br)?"happy":"sad").append("\n");
        }
        System.out.println(sb);
    }
}