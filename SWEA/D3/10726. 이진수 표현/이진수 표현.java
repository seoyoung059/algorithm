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
			int n = sc.nextInt();
            int m = sc.nextInt();
            
            if ((m&((1<<n)-1))==((1<<n)-1)){
                System.out.printf("#%d ON\n",test_case);
            }
                else 
                System.out.printf("#%d OFF\n",test_case);
            
		}
	}
}