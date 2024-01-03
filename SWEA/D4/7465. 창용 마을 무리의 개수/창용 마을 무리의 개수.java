import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt(); int m = sc.nextInt();
            int[][] relations = new int[n][n];
            int[] group = new int[n];
            int g = 0;
            int a, b;
            for (int i=0; i<m; i++){
                a = sc.nextInt()-1; b = sc.nextInt()-1;
                relations[a][b] = 1;
                relations[b][a] = 1;
            }
             
            for (int i=0; i<n; i++){
                if (group[i]==0){
                    g++;
                    group_check(n,i,g,relations,group);
                }
            }
             
            System.out.printf("#%d %d\n", test_case,g);
        }
    }
     
    public static void group_check(int n,int k, int g, int[][] relations, int[] group){
        if(group[k]==0) {
            group[k] = g;
            for (int i = 0; i<n; i++){
                if(relations[k][i]==1){
                    group_check(n,i,g,relations,group);
                }
            }
        }
        else {
            return;
        }
        return;
    }
}