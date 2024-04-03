import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<Integer>[][] hs;
    static int n;
    static int[][] cntArr;
    static boolean[][] checked;
    static void cnt(int i, int isTall) {
//        System.out.println(i);
        if(!checked[i][isTall]) {
            for(Integer t: hs[i][isTall]){
                cnt(t, isTall);
                for (int j = 1; j < n+1; j++) {
                    if(cntArr[t][j] == isTall) cntArr[i][j] = isTall;
                }
                cntArr[i][t] = isTall;
            }
        }
        checked[i][isTall] = true;
    }
    static int sol(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        hs = new HashSet[n+1][3];
        cntArr = new int[n+1][n+1];
        checked = new boolean[n+1][3];
        for (int i = 1; i < n+1; i++) {
            hs[i][1] = new HashSet<>();
            hs[i][2] = new HashSet<>();
            cntArr[i][i] = 3;
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            hs[a][1].add(b); // 나보다 큰건 1에 담음
            hs[b][2].add(a); // 나보다 작은건 2에 담음
        }

        int answer = 0;
//        for (int i = 1; i < n+1; i++) {
//            cnt(i, 1);
//            cnt(i, 2);
//        }
        loop: for (int i = 1; i < n+1; i++) {
//            System.out.println(Arrays.toString(cntArr[i]));
            cnt(i, 1);
            cnt(i, 2);
            for (int j = 1; j < n+1; j++) {
                if(cntArr[i][j]==0) continue loop;
            }
            answer++;
        }

//        for (int i = 1; i < n+1; i++) {
//            System.out.println(Arrays.toString(cntArr[i]));
//        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(sol(br));
        System.out.println(sb);


    }
}