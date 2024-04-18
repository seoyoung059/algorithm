import java.util.*;

class Solution {
    
    static int n, m, newN;
    public boolean check(int[][] newlock, int i, int j, int[][] key){
        int ky, kx;
        for(int y=m-1; y<n+m-1; y++){
            for(int x=m-1; x<n+m-1; x++){
                ky = y-i;
                kx = x-j;
                if((newlock[y][x]+((0<=ky&&ky<m&&0<=kx&&kx<m)?key[ky][kx]:0))!=1)
                    return false;
            }
        }
        
        
        // for(int y=m-1; y<n+m-1; y++){
        //     for(int x=m-1; x<n+m-1; x++){
        //         ky = y-i;
        //         kx = x-j;
        //         System.out.print(newlock[y][x]+((0<=ky&&ky<m&&0<=kx&&kx<m)?key[ky][kx]:0)+" ");
        //     }
        //     System.out.println();
        // }
        
        return true;
    }
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        n = lock.length;
        m = key.length;
        newN = n+2*(m-1);
        
        int[][] newlock = new int[newN][newN];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newlock[m-1+i][m-1+j] = lock[i][j];
            }
        }
        
        // for(int i=0; i<n+2*(m-1); i++){
        //     System.out.println(Arrays.toString(newlock[i]));
        // }
        int[][] newkey = new int[m][m];
        int[][] tmp;
        for(int t=0; t<5; t++){
            // for(int i=0; i<m; i++){
            //     System.out.println(Arrays.toString(newkey[i]));
            // }
            
            for(int i=0; i<n+m-1; i++){
                for(int j=0; j<n+m-1; j++){
                    // System.out.println(i+" "+j);
                    if(check(newlock, i, j, newkey)){
                        // System.out.println(i+" "+j);
                        return true;
                    }
                }
            }
            
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    newkey[i][j] = key[m-1-j][i];
                }
            }
            tmp = key;
            key = newkey;
            newkey = tmp;
        }
            
        return false;
    }
}