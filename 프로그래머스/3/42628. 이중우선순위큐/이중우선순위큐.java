import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        StringTokenizer st;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        char Op; int val;
        for(int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            Op = st.nextToken().charAt(0);
            val = Integer.parseInt(st.nextToken());
            
            switch(Op) {
                case 'I':
                    if(tm.get(val)==null){
                        tm.put(val,1);
                    }
                    else {
                        tm.replace(val, tm.get(val)+1);
                    }
                    break;
                case 'D':
                    if(tm.size()==0) break;
                    if(val==1){
                        if(tm.get(tm.lastKey())==1){
                            tm.remove(tm.lastKey());
                        }
                        else {
                            tm.replace(tm.lastKey(), tm.get(tm.lastKey())-1);
                        }
                    }
                    else {
                        if(tm.get(tm.firstKey())==1){
                            tm.remove(tm.firstKey());
                        }
                        else {
                            tm.replace(tm.firstKey(), tm.get(tm.firstKey())-1);
                        }
                        
                    }
                    break;
            }
        }
        
        if(tm.size()!=0){
            answer[0] = tm.lastKey();
            answer[1] = tm.firstKey();
        }
        return answer;
    }
}