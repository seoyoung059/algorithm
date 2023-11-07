import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = a.length();
        
        for(char c: a.toCharArray()){
            if ((int)c <= 90){
                System.out.printf("%c",(c+32));
            }
            else {
                System.out.printf("%c",(c-32));
            }
        }
    }
}