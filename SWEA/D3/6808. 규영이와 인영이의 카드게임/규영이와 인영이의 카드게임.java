import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 24,260 kb
 * 873 ms
 */
public class Solution {
	// swap함수
	static void swap(int[] p, int i, int j) {
		p[i] ^= p[j];
		p[j] ^= p[i];
		p[i] ^= p[j];
	}
	
	// nextPermuation 함수
	static boolean perm(int[] p) {
		int i = 8;
		while(i>0 && p[i-1]>= p[i]) i--;
		if(i==0) return false;
		
		int j = 8;
		while(j>i-1 && p[i-1]>=p[j]) j--;
		
		swap(p, i-1, j);
		
		int k = 8;
		while(i<k) swap(p, i++, k--);
		
		return true;
	}
	
	// 해당 카드 배열에서 게임의 승/패/무승부 여부(규영 기준)
	static int game(int[] kyu, int[] in) {
		int kScore =0, iScore=0;
		for(int i=0; i<9; i++) {
			if(kyu[i]>in[i]) kScore+=kyu[i]+in[i];
			else iScore+=kyu[i]+in[i];
		}
		
		if (kScore>iScore) return 1;
		else if (kScore < iScore) return 2;
		else return 3;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
//		boolean[] arr = new boolean[19];
		int check = 0;
		int[] kyu = new int[9];
		int[] in = new int[9];
		
		int idx, win, lose;
		for(int tc=1; tc<=T; tc++) {
//			Arrays.fill(arr, false);
			check = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
//				arr[kyu[i]]=true;
				check|=(1<<kyu[i]);
			}
			idx = 0;
			for(int i=1; i<19; i++) {
				if((check&(1<<i))==0) in[idx++] = i;
//				if(!arr[i]) in[idx++] = i;
			}
			
			win = 0;
			lose = 0;
			do {
				switch(game(kyu, in)) {
				case 1: 
					win++;
					break;
				case 2:
					lose++;
					break;
				}
				
			}while(perm(in));
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb);
	}

}