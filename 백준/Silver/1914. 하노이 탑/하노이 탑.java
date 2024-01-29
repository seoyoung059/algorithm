import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static void Hanoii_num(int n) {
//		return (int) (Math.pow(2, n)-1);
		BigInteger base = new BigInteger("2");
		sb.append(base.pow(n).subtract(new BigInteger("1")));
	}
	static void Hanoii_move (int n, int s, int m, int e){
		if(n==1) {
			sb.append(s);
			sb.append(" ");
			sb.append(e);
			sb.append("\n");
		}
		else {
			Hanoii_move(n-1, s, e, m);
			Hanoii_move(1, s, m, e);
			Hanoii_move(n-1, m, s, e);
		}
			
	}
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
//		sb.append(Hanoii_num(n));
		Hanoii_num(n);
		if (n<=20) {
			sb.append("\n");
			Hanoii_move(n, 1, 2, 3);
		}
		System.out.println(sb.toString());
	}
}
