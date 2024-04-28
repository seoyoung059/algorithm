import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    결국 길이가 n-1인 계단수를 알고있을 때, 길이가 n인 계단수를 만드려면
    - 계단수가 아닌거에서 뒤로 붙여가면서 계단수인지 확인
    - 또는 이미 계단수이면 뒤로 아무거나 붙여도 됨

    그려면 이제 계단수인것과 계단수가 아닌것을 따로 관리해야 하는데
    계단수인것 -> 그냥 더하면 됨


     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        long[][] visited = new long[10][(1 << 10)];
        long[][] newVisited = new long[10][(1 << 10)];
        long[][] tmp;
        for (int i = 1; i <= 9; i++) {
            visited[i][(1 << i)]++;
        }
        long answer = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < (1 << 10); k++) {
                    if (j - 1 >= 0) {
                        newVisited[j - 1][k | (1 << (j - 1))] += visited[j][k];
                        newVisited[j - 1][k | (1 << (j - 1))] %= 1_000_000_000;
                    }
                    if (j + 1 < 10) {
                        newVisited[j + 1][k | (1 << (j + 1))] += visited[j][k];
                        newVisited[j + 1][k | (1 << (j + 1))] %= 1_000_000_000;
                    }
                    visited[j][k] = 0;
                }
            }
            tmp = visited;
            visited = newVisited;
            newVisited = tmp;
        }

        for (int i = 0; i < 10; i++) {
            answer += visited[i][(1 << 10) - 1];
            answer %= 1_000_000_000;
        }
        System.out.println(answer);
    }
}