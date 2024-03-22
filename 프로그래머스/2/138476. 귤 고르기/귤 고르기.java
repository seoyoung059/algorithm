import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            if(map.keySet().contains(tangerine[i])){
                map.replace(tangerine[i], map.get(tangerine[i])+1);
            }
            else {
                map.put(tangerine[i],1);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->-o[1]));
        for(int key: map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
        }
        
        int[] curr;
        while(k>0 && !pq.isEmpty()) {
            curr = pq.poll();
            k -= curr[1];
            answer++;
        }
        return answer;
    }
}