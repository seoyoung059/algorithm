import java.io.*;
import java.util.*;

class Main {
	static class Juice {
		int price;
		int vitamin;
		String v;
		
		Juice(int price, String v) {
			this.price = price;
			this.vitamin = 0;
			this.v = v;
		}
	}
	
	static ArrayDeque<Juice>[] arr;
	static int answer;
	
	static void solve(int v, int tmp, int price) {
		if(tmp==7) {
			answer = Math.min(answer, price);
			return;
		}
		for(Juice curr: arr[v]) {
			for(int i=v+1; v<4; i++){
				if(((tmp|curr.vitamin) & (1<<i))==0) {
					solve(i, (tmp|curr.vitamin), price+curr.price);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		arr = new ArrayDeque[3];
		for(int i=0; i<3; i++){
			arr[i] = new ArrayDeque<>();
		}
		
		Juice newJuice; int price; String vitamins; int v, tmp;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			price = Integer.parseInt(st.nextToken());
			vitamins = st.nextToken();
			newJuice = new Juice(price, vitamins);
			tmp = 0;
			for(int j=0; j<vitamins.length();j++){
				v = vitamins.charAt(j) - 'A';
				arr[v].offer(newJuice);
				tmp |= (1<<v);
			}
			newJuice.vitamin = tmp;
		}
		
		answer = Integer.MAX_VALUE;
		if(arr[0].isEmpty() || arr[1].isEmpty() || arr[2].isEmpty()) {
			answer = -1;
		} else {
			solve(0, 0, 0);		
		}
		
		System.out.println(answer);
	}
}