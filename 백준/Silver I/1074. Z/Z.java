import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int sol(int size, int r, int c) {
		if(size==1) return 2*r+c;
		int tmp = (int)Math.pow(2,  size-1);
		
		return (2*(r/tmp)+c/tmp)*tmp*tmp
				+ sol(size-1, r%tmp, c%tmp);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(sol(n,r,c));
		
	}

}