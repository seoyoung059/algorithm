import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int solution(int n) {
        int check = 1<<10;
        int tmp;
        int i = 0;
        do {
            i++;
            tmp = i*n;
            while(tmp>0) {
                check|=1<<(tmp%10);
                tmp/=10;
            }
        } while ((check&((1<<11)-1)) != (1<<11)-1);
        return i*n;
    }
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        int num;
        for (int test_case = 1; test_case <= T; test_case++) {
            num = Integer.parseInt(br.readLine());

            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(solution(num));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}