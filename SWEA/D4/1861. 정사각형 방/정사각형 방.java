import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
//	static boolean[][] isVisited;
	static int[][] arr;

	// 범위 확인 함수
	static boolean isValid(int y, int x, int n) {
		return (0 <= y) && (y < n) && (0 <= x) && (x < n);
	}

	// dfs 수행
	static int[] dfs(int y, int x, int val, int n) {
		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		int ny, nx;
		int[] tmp;
		int min = val;
		int newVal;
		int cnt = 1;
		
		//동서남북 4방향에 대해서 수행
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			// 배열 이내 방문하지 않은 칸에 대해서
			if (isValid(ny, nx, n) && arr[ny][nx]!=-1) {
				// 차의 절대값이 1 이하 -> 증가 또는 감소하는 칸에 대해서만 dfs 수행
				if (Math.abs(arr[ny][nx] - val) <= 1) {
					newVal = arr[ny][nx];
					arr[ny][nx] = -1;
					tmp = dfs(ny, nx, newVal, n);
					// 가장 작은 값(출발하는 칸) 확인
					min = Math.min(min, tmp[0]);
					//총 순회 거리의 합 구함
					cnt += tmp[1];
				}
			}
		}
		// 출발하는 칸, 이동거리 의 배열 return
		return new int[] { min, cnt };
	}

	static void solution(int[][] arr, int n) {
//		isVisited = new boolean[n][n];
		int min = Integer.MAX_VALUE;
		int maxCnt = 1;
		int[] tmp;
		int val;
		//전체 배열 중 방문하지 않은 칸에 대해 DFS 수행
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (arr[y][x]!=-1) {
					val = arr[y][x];
					arr[y][x] = -1;
					tmp = dfs(y, x, val, n);
					// 더 많은 수의 방을 이동할 수 있는 것으로 업데이트
					if (tmp[1] > maxCnt) {
						maxCnt = tmp[1];
						min = tmp[0];
					// 이동할 수 있는 방의 개수가 최대인 방이 여럿이면
					// 적힌 수가 가장 작은 것을 출력
					} else if (tmp[1] == maxCnt) {
						min = Math.min(tmp[0], min);
					}
				}
			}
		}
		sb.append(min).append(" ").append(maxCnt).append("\n");
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int n;
		//테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			//입력
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append('#').append(tc).append(" ");
			solution(arr, n);
		}

		System.out.println(sb);

	}

}