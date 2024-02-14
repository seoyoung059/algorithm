import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int solution(int size, int r, int c) {
		if(size==1) return r*2+c;
		return 
				(int)Math.pow(2*2, size-1)*
				((r/((int)Math.pow(2, size-1))*2
						+(c)/(int)Math.pow(2, size-1)))
				+ solution(size-1, 
						(int)(r%((int)(Math.pow(2, size-1)))),
						(int)(c%((int)(Math.pow(2, size-1)))));
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(solution(n,r,c));
		
	}

}