import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static int[] dy, dx, price;
	static int n;
	
	static boolean isValid(int y, int x) {
		return (0<=y)&&(y<n)&&(0<=x)&&(x<n);
	}
	
	static int distance(int i, int j, int y, int x) {
		return Math.abs(i-y)+Math.abs(j-x);
	}
	
	static int sol() throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> q = new ArrayDeque<>();
	
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) q.offer(new int[] {i, j});
			}
		}
		
		/*
		 * 운영 비용 = k*k +(k-1)*(k-1)
		 * 운영 영역의 크기는 1 이상 정수
		 * 도시를 벗어난 영역에 서비스를 제공해도 운영 비용은 변경되지 않는다.
		 * 
		 * 집들은 각각 m의 비용을 지불할 수 있다.
		 * 손해를 보지 않는 한 최대한 많은 집에 서비스를 제공
		 * 그때의 서비스를 제공받는 집들의 수를 출력하는 프로그램 작성.
		 *
		 * 칸별로 거리별 집 수 세기? 나쁘지않을지도?
		 * 칸-칸 최대 거리는 2*n
		 * k에 대해서는 (k-1)만큼 이동한 거리 내에 집이 있어야
		 * 최대 받을 수 있는 비용은 집을 다 포함한다 하면 m*집의 수
		 * 그러면 m*전체 집의 
		 * 
		 * 집 기준으로 거리별로 칸에 표기하고
		 * 그 다음 각각의 칸에서 얻을 수 있는거 세기
		 * 이게 제일 가능성있어보임?
		 * 
		 * 아니잠깐
		 * 각칸별로집거리만구하면되자
		 */
		
//		int[] price = new int[n*2+1];
//		for(int k=1; k<2*n+2; k++) {
//			price[k-1] = k*k+(k-1)*(k-1);
////			System.out.println(price[k-1]);
//		}
//		System.out.println(Arrays.toString(price));
		
		int[] houseCnt = new int[n*2+1];
		int[] curr;
		int tmp; int max=0;
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp = 0;
				Arrays.fill(houseCnt, 0);
				for(int h=0; h<q.size(); h++) {
					curr = q.pollFirst();
					houseCnt[distance(i,j,curr[0], curr[1])]++;
					q.offerLast(curr);
				}
				for(int k=0; k<2*n+1; k++) {
					tmp+=houseCnt[k];
					if(m*tmp-price[k]>=0) {
						answer = Math.max(answer, tmp);
//						System.out.println(price[k]+" "+tmp);
					}
				}
			}
		}
//		System.out.println(answer);
		return answer;
	}
	public static void main(String args[]) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dy = new int[] {1, -1, 0, 0};
		dx = new int[] {0, 0, 1, -1};
		
		price = new int[20*2+1];
		for(int k=1; k<2*20+2; k++) {
			price[k-1] = k*k+(k-1)*(k-1);
//			System.out.println(price[k-1]);
		}
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ").append(sol()).append("\n");
		}
		System.out.print(sb);
	}
}