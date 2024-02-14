import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int nqueen(int x, int check1, int check2, int check3) {
		if(x==n) return 1;
		int tmp = 0;
		for(int y=0; y<n; y++) {
			if((check1&(1<<y))==(1<<y)) continue;
			if((check2&(1<<(x+y)))==(1<<(x+y))) continue;
			if((check3&(1<<(n-1+x-y)))==(1<<(n-1+x-y))) continue;
			tmp+=nqueen(x+1, check1|(1<<y), check2|(1<<(x+y)), check3|(1<<(n-1+x-y)));
		}
		return tmp;
	}
	
	static void solution() {
		System.out.println(nqueen(0,0,0,0));
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		System.out.print(nqueen(0,0,0,0));
	}

}