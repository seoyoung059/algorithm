import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int dnaInt(char c) {
		switch(c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		
		int[] given = new int[4];
		int[] arr = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			given[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		boolean check;
		for(int i=0; i<s; i++) {
			check = true;
			if (i<p) {
				arr[dnaInt(str.charAt(i))] ++;
			}
			else {
				arr[dnaInt(str.charAt(i-p))]--;
				arr[dnaInt(str.charAt(i))]++;
			}
			if (p-1 <= i) {
				for(int j=0; j<4;j++) {
					if(arr[j] < given[j]) {
						check=false;
						break;
					}
				}
				if (check) {
					answer++;
				}
			}
		}
		System.out.println(answer);
		
	}
}