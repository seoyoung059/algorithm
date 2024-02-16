import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//	static boolean ans;
	// swap함수
	static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
	
	// nextPermuation 함수
	static boolean perm(int[] p) {
		int i = 4;
		while(i>0 && p[i-1]>= p[i]) i--;
		if(i==0) return false;
		
		int j = 4;
		while(j>i && p[i-1]>=p[j]) j--;
		
		swap(p, i-1, j);
		
		int k = 4;
		while(i<k) swap(p, i++, k--);
		
		return true;
	}	
	
	static boolean sol(int team, int[][] arr, int[][] games) {
		boolean ans=true;
		if(team==6) {
			int a, b, c;
			for(int i=0; i<6; i++) {
				a=0; b=0;c=0;
				for(int j=0; j<6; j++) {
					if(i==j)continue;
					switch(games[i][j]) {
					case 1:
						a++;
						break;
					case 2:
						b++;
						break;
					case 3:
						c++;
						break;
					}
				}
				if(a!=arr[i][0]||b!=arr[i][1]||c!=arr[i][2]) {
					ans = false;
					break;
				}
			}
//			if(ans) {
//
//				for(int[] g: games) {
//					System.out.println(Arrays.toString(g));
//				}
//			}
			return ans;
		}
		int[] tmp = new int[5];
		int a, b, c;
		a=arr[team][0];
		b=arr[team][1];
		c=arr[team][2];
		int idx=0;
		while(a-->0) tmp[idx++]=1;
		while(b-->0) tmp[idx++]=2;
		while(c-->0) tmp[idx++]=3;
		boolean skip = false;
		int pidx = 0;
		do {
//			System.out.println(team+" "+Arrays.toString(tmp));
			pidx = 0;
			skip=false;
			for(int i=0; i<6; i++) {
				if(i==team) continue;
				if(team > i && games[team][i]!=tmp[pidx]) {
//					System.out.print(" nono");
					skip = true;
					break;
				}
				games[team][i] = tmp[pidx];
				games[i][team] = 4-tmp[pidx++];
			}
			
			if(!skip) {
//				for(int[] g: games) {
//					System.out.println(Arrays.toString(g));
//				}
				if (sol(team+1, arr, games)) return true;
			}
		} while(perm(tmp));
		return false;
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[6][3];
		int tmp;
		testcase: for(int T=0;T<4;T++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				tmp = 0;
				for(int k=0; k<3; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					tmp+=arr[j][k];
				}
				if(tmp!=5) {
					sb.append(0).append(" ");
					continue testcase;
				}
			}

			int[][] games = new int[6][6];
			boolean ans = sol(0,arr, games);
			
			sb.append((ans)?1:0).append(" ");
		}
		System.out.print(sb);

	}

}