class Solution {
    
    static int userCnt, idCnt, answer;
    static boolean[] visited;
    
    public boolean check(String user, String id){
        if(user.length()!=id.length()) return false;
        
        for(int i=0; i<user.length(); i++){
            if(id.charAt(i)=='*') continue;
            if(user.charAt(i)!=id.charAt(i)) return false;
        }
        return true;
    }
    
    public void dfs(String[] user_id, String[] banned_id, int jth_id, int banned){
        if(jth_id==idCnt){
            if(!visited[banned]){
                // System.out.println(Integer.toBinaryString(banned));
                visited[banned]=true;
                answer++;
            }
            return;
        }
        
        for(int i=0; i<userCnt; i++){
            if((banned&(1<<i))>0){
                continue;
            }
            
            if(check(user_id[i], banned_id[jth_id])){
                // System.out.println(user_id[i]+" "+ banned_id[jth_id]);
                dfs(user_id, banned_id, jth_id+1, banned|(1<<i));
            }
        }
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
    
        userCnt = user_id.length;
        idCnt = banned_id.length;
        visited = new boolean[1<<userCnt];
        
        dfs(user_id, banned_id, 0, 0);
        
        return answer;
    }
    
}