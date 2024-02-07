import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static void printArr(int[][] arr) {
		for(int[] a: arr) {
			for(int j=0; j<a.length; j++)
				sb.append(a[j]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void arr1(int[][]arr) {
		int n=arr.length;
		int m = arr[0].length;
		int tmp;
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[n-1-i][j];
				arr[n-1-i][j] = tmp;
			}
		}
	}
	
	static void arr2(int[][] arr) {
		int n=arr.length;
		int m = arr[0].length;
		int tmp;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m/2; j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[i][m-1-j];
				arr[i][m-1-j] = tmp;
			}
		}
	}
	static int[][] rotateLeft90(int[][] arr) {
		int n=arr.length;
		int m = arr[0].length;
		int[][] newArr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				newArr[i][j] = arr[j][m-1-i];
			}
		}
		return newArr;
	}
	
	static int[][] rotateRight90(int[][] arr) {
		int n=arr.length;
		int m = arr[0].length;
		int[][] newArr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				newArr[i][j] = arr[n-1-j][i];
			}
		}
		return newArr;	
	}
	
	static int region(int i, int j, int n, int m) {
		int tmp = (j/(m/2));
		return ((i/(n/2))==0)?tmp:3-tmp;
	}
	static int[][] moveClockwise(int[][] arr, boolean dir) {
		int n=arr.length;
		int m = arr[0].length;
		int[][] newArr = new int[n][m];
		int startN, startM;
		int rotate = (dir)?-1:1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				startN = i%(n/2);
				startM = j%(m/2);
				switch(Math.floorMod(region(i,j,n,m)+rotate,4)) {
				case 0:
					newArr[i][j]=arr[startN][startM];
					break;
				case 1:
					newArr[i][j]=arr[startN][startM+(m/2)];
					break;
				case 2:
					newArr[i][j]=(arr[startN+(n/2)][startM+(m/2)]);
					break;
				case 3:
					newArr[i][j]=arr[startN+(n/2)][startM];
					break;
				}
			}
		}
		return newArr;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<r; i++) {
			int c = Integer.parseInt(st.nextToken());
			switch(c) {
			case 1:
				arr1(arr);
				break;
			case 2:
				arr2(arr);
				break;
			case 3:
				arr = rotateRight90(arr);
				break;
			case 4:
				arr = rotateLeft90(arr);
				break;
			case 5:
				arr=moveClockwise(arr,true);
				break;
			case 6:
				arr=moveClockwise(arr,false);
				break;
			}
		}
		
		printArr(arr);
		
	}

}