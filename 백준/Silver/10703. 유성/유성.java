import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static int r, s;
	static char [][] picture;
	static int [] meteor;
	static int meteorLow;
	static int shortestGap;
	private static void printPic() {
		for (int i=0; i<r; i++) {
			System.out.println(Arrays.toString(picture[i]));
		}
	}
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	    
		r = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		picture = new char[r][s];
		meteor = new int[s];
		Arrays.fill(meteor, -1);
		shortestGap = Integer.MAX_VALUE;
		
		for (int i=0; i<r; i++) {
			String tmp = br.readLine();
			for (int j=0; j<s; j++) {
				picture[i][j] = tmp.charAt(j);
				if (picture[i][j]=='X') {meteor[j]=i; meteorLow = Math.max(meteorLow, i);}
				if (picture[i][j]=='#' && meteor[j]!=-1) shortestGap = Math.min(shortestGap, i-meteor[j]-1);
			}
		}

		if(shortestGap!=Integer.MAX_VALUE) {
			for (int j=0;j<s;j++) {
				if (meteor[j]!=-1) {
					for (int i=meteor[j]; i>=0; i--) {
						picture[i+shortestGap][j] = picture[i][j];
						picture[i][j] = '.';
					}
				}
			}
		}
		for (int i=0; i<r; i++) {
			sb.append(picture[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
