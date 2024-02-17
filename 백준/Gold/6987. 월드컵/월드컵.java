import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


    public class Main {
        static int answer;
        static int[][] check;
        static int[][] report;
        static void solution(int teamA, int teamB){
            if(answer==1) return;
            else if(teamA==5) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(check[i][j]!=report[i][j]) return;
                    }
                }
                answer = 1;
                return;
            }
            else if(teamB==6){
                solution(teamA+1, teamA+2);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if(check[teamA][i] >= report[teamA][i] || check[teamB][2-i]>=report[teamB][2-i])
                    continue;
                check[teamA][i]++;
                check[teamB][2-i]++;
                solution(teamA, teamB+1);
                check[teamA][i]--;
                check[teamB][2-i]--;
            }


        }

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            report = new int[6][3];
            check = new int[6][3];

            testcase:
            for (int T = 0; T < 4; T++) {
                answer = 0;
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        report[i][j] = Integer.parseInt(st.nextToken());
                        check[i][j] = 0;
                    }
                }

                solution(0, 1);
                sb.append(answer).append(" ");
            }
            System.out.print(sb);

        }
    }