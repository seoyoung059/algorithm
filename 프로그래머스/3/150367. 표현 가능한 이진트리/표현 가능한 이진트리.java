class Solution {
    
    boolean solve(String num, int start, int end){
        // System.out.println(start+" "+end+" "+num.substring(start, end+1));
        if(num.charAt((end+start)/2)=='1') {
            if((end-start+1)==3) return true;
            else return (solve(num, start, (start+end)/2-1) && solve(num, (start+end)/2+1, end));
        } else {
            for(int i=start; i<=end; i++){
                if(num.charAt(i)=='1') return false;
            }
            return true;
        }
    }
    
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        String tmp;
        int tmpLength, cnt;
        for(int i=0; i < n; i++){
            if(numbers[i]==1) {
                answer[i] = 1;
                continue;
            }
            tmp = Long.toBinaryString(numbers[i]);
            tmpLength = tmp.length();
            cnt=0;
            while((1<<cnt) <= tmp.length()){
                cnt++;
            }
            tmp = String.format("%1$" + ((1<<cnt)-1) + "s", tmp).replace(' ', '0');
            // System.out.println(numbers[i]+"========"+tmp);
            answer[i] = solve(tmp, 0,tmp.length()-1)?1:0;
        }
        return answer;
    }
}