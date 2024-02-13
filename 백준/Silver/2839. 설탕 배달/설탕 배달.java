import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
        
        for(int i=1; i<n+1; i++){
            if(i==3||i==5) arr[i] = 1;
            else if(i-5>=0 && arr[i-5]>0 && arr[i-3]>0){
                arr[i] = Math.min(arr[i-5], arr[i-3])+1;
            }
            else if(i-5>=0&&arr[i-5]>0){
                arr[i] = arr[i-5]+1;
            }
            else if(i-3>=0 && arr[i-3]>0){
                arr[i] = arr[i-3]+1;
            }
            else arr[i]=-1;
        }
        
        System.out.print(arr[n]);
	}

}